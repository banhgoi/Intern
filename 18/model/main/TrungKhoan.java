package company.model.main;

import company.model.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TrungKhoan {
    public static List<User> listUser;
    public static List<Stock> listStock;
    public static List<Order> listOrder;
    //public static Map<String, Stock> listStock;
    public static List<Company> listCompany;
    public static Set<Trader> LoggedInlistTrader;   //Trader đang đăng nhập
    public static Map<String,Trader> listRegisterTrader;    //Đăng ký trader

    //
    public static Map<String, BlockingQueue<Order>> sell = new HashMap<>();
    public static Map<String, BlockingQueue<Order>> buy = new HashMap<>();

    public static Connection connection = null;
    public static Statement statement = null;

    public static void main(String[] args) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        listUser = new ArrayList<>();
        listStock = new ArrayList<>();
        listCompany = new ArrayList<>();
        listOrder = new ArrayList<>();
        getConnect();


        //Admin
        //SelectListUser();
        //SelectListStock();
        //SelectListCompany();
        //SelectListOrder();

        //Ký quỹ tiền
        //KyQuyTien(102,20);
        //Ký quỹ trứng khoán
        //KyQuyTrungKhoan(101,"ST1",2);

        //Trader
        SelectListOrder();
        //Add vào hàng đợi

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (Order order: listOrder){
                    if (order.getType().equals("sell")) {
                        if (sell.entrySet().stream().anyMatch(i -> i.getKey().equals(order.getIdStock()))) {
                            sell.get(order.getIdStock()).add(order);
                        }
                        //Nếu khóa chưa được tạo
                        else {
                            sell.put(order.getIdStock(), new PriorityBlockingQueue<>(15,new Comparator<Order>() {
                                @Override
                                public int compare(Order o1, Order o2) {
                                    return (int) (o1.getPrice() - o2.getPrice());
                                }
                            }));
                            sell.get(order.getIdStock()).add(order);
                        }
                    }
                    //Nếu là buy Order
                    else {
                        if (buy.entrySet().stream().anyMatch(i -> i.getKey().equals(order.getIdStock()))) {
                            buy.get(order.getIdStock()).add(order);
                        } else {
                            buy.put(order.getIdStock(), new PriorityBlockingQueue<>(15,new Comparator<Order>() {
                                @Override
                                public int compare(Order o1, Order o2) {
                                    return (int) (o2.getPrice() - o1.getPrice());
                                }
                            }));
                            buy.get(order.getIdStock()).add(order);
                        }
                    }
                }
            }
        };

    }

    public static void SelectListOrder(){
        String query = "SELECT * FROM `order`";
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                listOrder.add(new Order(resultSet.getInt("idOrder"),resultSet.getInt("idTrader"),
                        resultSet.getString("idStock"),resultSet.getDate("orderDate"),resultSet.getInt("amount"),resultSet.getInt("price"),resultSet.getString("type")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(listOrder);
    }

    public static void SelectListCompany(){
        String query = "Select * from company";
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                listCompany.add(new Company(resultSet.getString("idCompany"),resultSet.getString("name"),
                        resultSet.getString("address"),resultSet.getString("phone")));

            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(listCompany);
    }

    public static void SelectListStock(){
        String query = "Select * from stock";
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                listStock.add(new Stock(resultSet.getString("idStock"),resultSet.getString("name"),
                        resultSet.getInt("amount"),resultSet.getInt("price"), resultSet.getString("idCompany"),resultSet.getDate("DayTime")));

            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(listStock);
    }
    //
    public static void SelectListUser(){
        String query = "Select * from user";
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                listUser.add(new User(resultSet.getString("idUser"),resultSet.getString("name"),
                        resultSet.getString("email"),resultSet.getString("phone")));

            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(listUser);
    }

    public static void KyQuyTien(int idTrader,int money){
        String update = "Update money_trader set money = (Select money from money_trader where idTrader = "+idTrader
                +" ) + "+money+" where idTrader = "+idTrader;
        try {
            statement = connection.createStatement();
            int check = statement.executeUpdate(update);
            if (check>0){
                System.out.println("Ký quỹ tiền thành công");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void KyQuyTrungKhoan(int idTrader,String idStock, int amount){

        //Kiểm tra xem đã tồn tại
        String queryCheck = "Select * from stock_trader Where idTrader = "+idTrader+" and idStock = '"+idStock+"'";
        try {
            statement = connection.createStatement();
            ResultSet resultSetCheck = statement.executeQuery(queryCheck);
            //
            boolean check1 = resultSetCheck.next();
            if (check1){
                String TangSL = "Update stock_trader set amount = (Select amount from stock_trader where idTrader = "+idTrader
                        +" ) + "+amount+" where idTrader = "+idTrader;
                int check = statement.executeUpdate(TangSL);
                if (check>0){
                    System.out.println("Ký quỹ cổ phiếu thành công");
                }
            }
            //
            else {
                String newStock = "insert into stock_trader values ("+idTrader+", "+amount+", '"+idStock+"') ";
                int check = statement.executeUpdate(newStock);
                if (check>0){
                    System.out.println("Ký quỹ cổ phiếu thành công");
                }
            }
            //System.out.println(check1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getConnect(){

        String strConnect = "jdbc:mysql://localhost/dbTrungKhoan";
        try {
            connection = DriverManager.getConnection(strConnect,"root","");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        //
        if (connection != null) System.out.println("Ket noi DB thanh cong");
        else System.out.println("Ket noi DB khong thanh cong");
    }
}

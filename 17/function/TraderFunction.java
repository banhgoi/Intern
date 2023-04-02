package function;

import obj.Order;
import obj.Stock;
import obj.Trader;
import obj.User;

import java.sql.*;

public class TraderFunction {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// nap driver
        } catch (ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
        }
    }
    ;
    private String dbURL = "jdbc:mysql://localhost:3306/exchangestock";
    private String user = "root";
    private String password = "dat123";
    private Connection conn;

    public void connect() {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
            System.out.println("Connected.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Closed.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void dangkyTrader(Trader a) throws SQLException {
        String sql="insert into trader values(?,?,?);";
        PreparedStatement prest = conn.prepareStatement(sql);
        prest.setString(1, a.getIDTrader());
        prest.setString(2, a.getIDUser());
        prest.setDouble(3,  a.getBalance());
        prest.executeUpdate();
        prest.close();

    }
    public void noptienTrader(Trader a, Double tien) throws SQLException {
        PreparedStatement prest1 = conn.prepareStatement("select balance from trader where trader_id =?");
        prest1.setString(1, a.getIDTrader());

        ResultSet kq = prest1.executeQuery();
        double balance=0;
        try{
            while(kq.next()){
                balance=kq.getDouble(1);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        prest1.close();
        String selectQuery = "Update trader set balance=? where trader_id=?";

        try{
            PreparedStatement prest = conn.prepareStatement(selectQuery);
            balance+=tien;
            prest.setDouble(1, balance);
            prest.setString(2,  a.getIDTrader());
            prest.executeUpdate();

            prest.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    //Đặt mua, đặt bán
    public void AddOrder(Trader trader, Stock stock, int amount, double price, boolean issale){
        Order order=new Order();
        order.setIDTrader(trader.getIDTrader());
        order.setIDStock(stock.getIDStock());
        order.setAmount(amount);
        order.setPrice(price);
        String query;
        if(issale)
            query= "insert into orders(trader_id,stock_id,amount,price,saleorbuy)  values (?,?,?,?,1)";
        else
            query= "insert into orders(trader_id,stock_id,amount,price,saleorbuy)  values (?,?,?,?,0)";
        try{
            PreparedStatement prest = conn.prepareStatement(query);
            prest.setString(1, order.getIDTrader());
            prest.setString(2,  order.getIDStock());
            prest.setInt(2,  order.getAmount());
            prest.setDouble(2,  order.getAmount());
            prest.executeUpdate();

            prest.close();
        }catch(SQLException e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args) throws SQLException {
        TraderFunction traderFunction =new TraderFunction();
        traderFunction.connect();
        Trader td1=new Trader("kh1", "kh1td2", 100000.0);
        //dang ky tai khoan

        traderFunction.dangkyTrader(td1);
        //nap tien
        traderFunction.noptienTrader(new Trader("kh1td1"), 100000.0);
        traderFunction.disconnect();

    }
}

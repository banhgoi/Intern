package System;

import function.Connect;
import obj.Order;
import obj.Stock;
import obj.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;

public class TransactionQueue {
    Map<Stock, PriorityBlockingQueue<Order>> sellqueue =new HashMap<>();
    Map<Stock, PriorityBlockingQueue<Order>> buyqueue =new HashMap<>();
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
    public void ReadOrders() throws SQLException {
        String sql= "select distinct stock_id from orders  "; //lay danh sach ten stock
        Statement stmt=conn.createStatement();
        ResultSet kq = stmt.executeQuery(sql);
        try{
            while(kq.next()){
                Stock stock=new Stock(kq.getString("stock_id"));
                ReadOrdersbyStock(stock);

            }

        } catch(Exception e){
            System.out.println("loi truy van: "+e);
        }
        stmt.close();
    }
    public void ReadOrdersbyStock(Stock stock) throws SQLException {
        ArrayList<Order> saleList = new ArrayList<>();
        ArrayList<Order> buyList = new ArrayList<>();
        String sql= "select * from orders where stock_id = '"+stock.getIDStock()+"'"; //mot ma co phieu
        //PreparedStatement prest = conn.prepareStatement(sql);
        //prest.setString(1, stock.getIDStock());
        Statement stmt=conn.createStatement();
        ResultSet kq = stmt.executeQuery(sql);
        try{
            while(kq.next()){
                Order order1=new Order(kq.getInt("order_id"), //kq.getString("order_date"),
                        kq.getString("trader_id"),kq.getString("stock_id"),kq.getInt("amount"),kq.getDouble("price"), kq.getBoolean("saleorbuy"));
               if(order1.isSale())
                   saleList.add(order1);
               else
                   buyList.add(order1);

            }

//            sellqueue.put(new Stock("flc"), saleList);
  //          buyqueue.put(new Stock("flc"), buyList);

        } catch(Exception e){
            System.out.println("loi truy van: "+e);
        }
        stmt.close();
        System.out.println("stock: "+stock.getIDStock());
        saleList.forEach(System.out::println);
        buyList.forEach(System.out::println);
    }
    public void matchOrders(){

    }
    public void matchOrdersByStock(Stock stock){


    }
    public static void main(String[] args) throws SQLException {
        TransactionQueue transactionQueue=new TransactionQueue();
        transactionQueue.connect();
        //transactionQueue.ReadOrdersbyStock(new Stock("flc"));
        transactionQueue.ReadOrders();
        transactionQueue.disconnect();

        //System.out.println(transactionQueue.buyqueue);
    }
}

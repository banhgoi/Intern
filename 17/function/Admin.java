package function;

import obj.User;

import java.sql.*;
import java.util.ArrayList;

public class Admin {

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

public void printUsers(String sql) throws SQLException {
    ArrayList<User> arrList = new ArrayList<>();
    Statement stmt=conn.createStatement();
    ResultSet kq = stmt.executeQuery(sql);
    try{
        while(kq.next()){
            arrList.add(new User(kq.getString("user_id"),kq.getString("user_name"),kq.getString("address"),kq.getString("tel")));
        }
    } catch(Exception e){
        System.out.println(e);
    }
    stmt.close();
    arrList.forEach(System.out::println);

}
public void addUsers(User a) throws SQLException {
    String sql="insert into users values(?,?,?,?);";
    PreparedStatement prest = conn.prepareStatement(sql);
    prest.setString(1, a.getIdUser());
    prest.setString(2, a.getName());
    prest.setString(3,  a.getAddress());
    prest.setString(4, a.getTel());
    prest.executeUpdate();
    prest.close();
}
    public  void updateUsers(User a){
        String selectQuery = "Update users set user_name=?,address=?, tel=?  where user_id=?";

            try{
                PreparedStatement prest = conn.prepareStatement(selectQuery);

                prest.setString(1, a.getName());
                prest.setString(2,  a.getAddress());
                prest.setString(3, a.getTel());
                prest.setString(4, a.getIdUser());
                prest.executeUpdate();

                prest.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    public  void deleteUsers(User a){
        String selectQuery = "Delete from Products where user_id=?";
        if (conn != null){
            try{
                PreparedStatement prest = conn.prepareStatement(selectQuery);
                prest.setString(1, a.getIdUser());
                prest.executeUpdate();
                prest.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        Admin demo =new Admin();
        demo.connect();
        demo.printUsers("select * from users");
        //demo.addUsers(new User("kh5", "nam", "hanam", "0123"));
        demo.updateUsers(new User("kh5", "ha", "hanam", "0123"));
        System.out.println("-------------");
        demo.printUsers("select * from users");
        demo.disconnect();

    }
}

package function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

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

}

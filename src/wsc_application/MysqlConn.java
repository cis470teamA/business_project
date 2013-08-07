package wsc_application;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConn {
    private String user = "appl_user";
    private String pass = "4Eche4AfETupHu";
    private Connection conn;
    
    public MysqlConn () {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            System.out.println("Exception loading com.mysql.jdbc.Driver" + ex.getMessage());
        }
    }
    
    public void makeConnection() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://mysql.durivage.org", user, pass);
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}

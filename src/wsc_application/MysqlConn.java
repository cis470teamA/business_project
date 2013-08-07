package wsc_application;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MysqlConn {
    private String user = "appl_user";
    private String pass = "4Eche4AfETupHu";
    private Connection conn;
    
    public MysqlConn () {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "MySQL driver failed to load.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            System.out.println("Exception loading com.mysql.jdbc.Driver" + ex.getMessage());
        }
    }
    
    protected void makeConnection() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://mysql.durivage.org", user, pass);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,  "Failed to connect to the "
                    + "MySQL Server.  Check console for more information", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }   
    }
    
    protected ResultSet query(String query) {
        Statement statement = null;
        ResultSet resultset = null;
        try {
            statement = this.conn.createStatement();
            resultset = statement.executeQuery(query);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            return resultset;
        }
    }
}

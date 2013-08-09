package wsc_application;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MysqlConn {
    private String user = "appl_user";
    private String pass = "password123"; // Select only user
    private String database = "cis470"; // Database on the MySQL server to use
    private Connection conn;
    
    protected Statement stmt = null;
    protected ResultSet rs = null;
    
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
        makeConnection();
    }
    
    private void makeConnection() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://mysql.durivage.org", user, pass);
            this.conn.setCatalog(database);
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
    
    protected ResultSet doQuery(String query) {
        try {
            this.stmt = this.conn.createStatement();
            this.rs = this.stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            return rs;
        }
    }
    
    protected ResultSet runStatement(String query) {
        try {
            this.stmt = this.conn.createStatement();
            this.stmt.execute(query);
            this.rs = this.stmt.getResultSet();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            return this.rs;
        }
    }
    
    protected void closeAll() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.stmt != null) {
                this.stmt.close();
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

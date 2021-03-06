package wsc_application;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Login.java
 * Paul Durivage
 * for CIS470 GroupA
 */

public class Login {
    public static boolean isAuthenticated = false;
    /*
     * REFER TO THIS AS THE APPLICATION GLOBAL EMPLOYEE OBJ
     * It's convenient to set when logging in, and most of the work in the 
     * doQuery method is already doing that -- refer to the class vars set
     * there.
     */
    public static Employee emp = null; // App-level Employee obj.
    
    private static long empid;
    private static String passwd;
    private static String fname;
    private static String lname;
    private static String email;
    private static String type;
    
    /**
     * 
     * @param user 
     * @param pass
     * @return Boolean indicating success of login method
     */
    public static boolean processLogin(String user, String pass) {
        boolean result = doQuery(user, pass);
        if (result) {
            isAuthenticated = true;
            emp = new Employee(); // CREATE EMPLOYEE OBJECT
            // Now set attributes.
            emp.setEmpId(empid);
            emp.setFirstName(fname);
            emp.setLastName(lname);
            emp.setEmpType(type);
            emp.setEmail(email);
            // Done.
            SrProject.win.lblLoginStatus.setText("Login successful");
            SrProject.win.lblLoginStatus.setForeground(Color.GREEN);
            SrProject.win.lblLoginStatus.setVisible(true);
            SrProject.win.WSCInterface.setEnabled(true);
            SrProject.win.WSCInterface.setToolTipText("Enabled");
            return true;
        } else {
            SrProject.win.lblLoginStatus.setText("Login failed.");
            SrProject.win.lblLoginStatus.setForeground(Color.red);
            SrProject.win.lblLoginStatus.setVisible(true);
        }
        return false;
    }
    
    public static void processLogout(){
        isAuthenticated = false;
        emp = null;
        SrProject.win.WSCInterface.setEnabled(false);
        SrProject.win.lblLoginStatus.setText("Logout complete.");
        SrProject.win.lblLoginStatus.setForeground(Color.GREEN);
        SrProject.win.lblLoginStatus.setVisible(true);
    }
    
    private static boolean doQuery(String user, String pass) {
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        boolean rval = false;
        String query = "select * from USER, EMPLOYEE where "
                + "USER.EMPID = " + user + " and "
                + "EMPLOYEE.EMPID = " + user + ";";
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
                empid = rs.getInt("EMPID");
                passwd = rs.getString("pass");
                fname = rs.getString("EmpFirstName");
                lname = rs.getString("EmpLastName");
                email = rs.getString("EmpEmail");
                type = rs.getString("EmpType");
                if (passwd.equals(pass)) {
                    rval = true;
                } 
            }
        }
        catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            mysql.closeAll();
            return rval;
        }
    }
}


package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login {
    public static boolean isAuthenticated = false;
    /*
     * REFER TO THIS AS THE APPLICATION GLOBAL EMPLOYEE OBJ
     * It's convenient to set when logging in, and most of the work in the 
     * doQuery method is already doing that -- refer to the class vars set
     * there.
     */
    public static Employee emp; // App-level Employee obj.
    
    private static int empid;
    private static String passwd;
    private static String fname;
    private static String lname;
    private static String email;
    private static String type;
    
    public static boolean processLogin(String user, String pass) {
        System.out.println("Processing login.");
        boolean result = doQuery(user, pass);
        if (result) {
            isAuthenticated = true;
            emp = new Employee(); // CREATE EMPLOYEE OBJECT
            // ALSO TIME TO POPULATE EMPLOYEE OBJECT FROM AUTHENTICAION
            System.out.println("Login successful");
            JOptionPane.showMessageDialog(null, "Login sucessful", "Login sucessful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Login failed");
            JOptionPane.showMessageDialog(null, "Username/password not a match", "Login failed", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public static void processLogout(){
        
    }
    
    private static boolean doQuery(String user, String pass) {
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        boolean rval = false;
        String query = "select * from USER, EMPLOYEE where "
                + "USER.EMPID = " + user + " and "
                + "EMPLOYEE.EMPID = " + user + ";";
        System.out.println(query);
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
                System.out.println("Found row.");
                empid = rs.getInt("EMPID");
                passwd = rs.getString("pass");
                fname = rs.getString("EmpFirstName");
                lname = rs.getString("EmpLastName");
                email = rs.getString("EmpEmail");
                type = rs.getString("EmpType");
                System.out.println("Form: " + pass);
                System.out.println("DB: " + passwd);
                if (passwd.equals(pass)) {
                    System.out.println("Password matches");
                    rval = true;
                } 
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            mysql.closeAll();
            return rval;
        }
    }
}


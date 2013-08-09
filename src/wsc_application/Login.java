package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login {
    public static boolean isAuthenticated = false;
    public static Employee emp;
    
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
        } else {
            System.out.println("Login failed");
        }
        return false;
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

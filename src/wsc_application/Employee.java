package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Employee{
    
    protected String firstName;
    protected String lastName;
    protected Long EMPID;
    protected String email;
    protected String empType;
    
    public enum type {
        SalesPerson, EngrSpec, PrintSpec, StockClerk, OpsMan, Admin;
    }
    
    public Employee(){
        
    }
     public Employee(String fName, String lName, Long empId, String eMail) {
        setFirstName(fName);
        setLastName(lName);
        setEmpId(empId);
        setEmail(eMail);
        
    }
    public Employee(String fName, String lName, Long empId, String eMail, String empType) {
        setFirstName(fName);
        setLastName(lName);
        setEmpId(empId);
        setEmail(eMail);
        setEmpType(empType);
    }
    
    // Employee class code goes here.  Methods and stuff.
    public static Employee searchBy(long EmpId) {
        Employee employee = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "select * from EMPLOYEE where EMPID = " + Long.toString(EmpId) + ";";
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
                employee = new Employee(
                        rs.getString("EmpFirstName"),
                        rs.getString("EmpLastName"),
                        rs.getLong("EMPID"),
                        rs.getString("EmpEmail"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
         }
         finally {
             mysql.closeAll();
             return employee;
         }
    }
    
    //Jacob: Added Employee update method 
    public static Employee updateBy(Employee employee) {     
        Employee emp = null; 
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from EMPLOYEE where EMPID =  " + Long.toString(employee.EMPID) + ";";
            rs = mysql.stmt.executeQuery(query);
            if (rs.next()) {
                rs.updateString("EmpFirstName", employee.firstName);
                rs.updateString("EmpLastName", employee.lastName);
                rs.updateString("EmpEmail", employee.email);
                rs.updateString("EmpType", employee.empType);
                rs.updateRow();
            }
            rs = mysql.doStatement(query);
            if (rs.next()) {
                emp = new Employee(
                        rs.getString("EmpFirstName"),
                        rs.getString("EmpLastName"),
                        rs.getLong("EMPID"),
                        rs.getString("EmpEmail"),
                        rs.getString("EmpType"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            mysql.closeAll();
            return emp;
        }
    }
    
    //Jacob: Added CreateEmp method
    public static Employee createEmp(Employee employee) {
        Employee emp = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String query = "insert into EMPLOYEE values (0, '"
                    + employee.firstName + "', '"
                    + employee.lastName + "', '"
                    + employee.email + "', '"
                    + employee.empType + "');";
            mysql.stmt.executeUpdate(query, java.sql.Statement.RETURN_GENERATED_KEYS);   
        }   
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            return emp;
        }
    }
    
    //Added isEmployee to check for exist before adding new employee
    public static boolean isEmployee(long EmpID){
        boolean checkExist = false;
         ResultSet rs;
         MysqlConn mysql = new MysqlConn();
        String query = "select * from EMPLOYEE where EMPID = " + Long.toString(EmpID) +";";
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
                checkExist = true;
            }
        }
        catch (SQLException ex) {
            
        }
        finally{
            mysql.closeAll();
            return checkExist;
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setEmpId(Long empId){
        this.EMPID = empId;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setEmpType(String empType){
        this.empType = empType;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public Long getEmpId(){
        return EMPID;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getEmpType(){
        return empType;
    }
    // </editor-fold>
}

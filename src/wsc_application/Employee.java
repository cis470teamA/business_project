package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Employee{
    
    protected String firstName;
    protected String lastName;
    protected Long EMPID;
    protected String email;
    
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
    // </editor-fold>
}

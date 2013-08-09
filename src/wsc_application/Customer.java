package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Customer {
    
    private int CUSTID;
    private String custFName;
    private String custLName;
    private String custStreet1;
    private String custStreet2;
    private String custCity;
    private String custState;
    private int custZip;
    private long custPhone;
    private String custEmail;
    
    public Customer(){
    }
    
    public Customer(int custid, String fName, String lName, String street1, String street2, 
            String city, String state, int zip, long phone, String email) {
        setCUSTID(custid);
        setFName(fName);
        setLName(lName);
        setStreet1(street1);
        setStreet2(street2);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhone(phone);
        setEmail(email);
    }
     
     /**
     * By Paul
     * @param col Name of column to search in
     * @param value Value of the column to search by
     * @return Customer object or null if nothing found
     */
    public static Customer searchBy(String col, String value) {     
         Customer cust = null;
         ResultSet rs;
         MysqlConn mysql = new MysqlConn();
         String query = "select * from customer where "
                 + "" + col + " = " + value;
         rs = mysql.doQuery(query);
         try {
             if (rs.next()) {
                 cust = new Customer(
                         rs.getInt("CUSTID"),
                         rs.getString("CustFirstName"),
                         rs.getString("CustLastName"),
                         rs.getString("CustStreet1"),
                         rs.getString("CustStreet2"),
                         rs.getString("CustCity"),
                         rs.getString("CustState"),
                         rs.getInt("CustZip"),
                         rs.getLong("CustPhone"),
                         rs.getString("CustEmail"));
             }
         }
         catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
         }
         finally {
             mysql.closeAll();
             return cust;
         }
     }
     
    /**
     *
     * @param customer An object of Customer class
     * @return Customer object from database
     */
    public static Customer updateBy(Customer customer) {     
        Customer cust = null; 
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "select * from customer where CUSTID = " + Integer.toString(customer.CUSTID) + ";";
        rs = mysql.doStatement(query);
        try {
            if (rs.next()) {
                rs.updateString("CustFirstName", customer.custFName);
                rs.updateString("CustLastName", customer.custLName);
                rs.updateString("CustStreet1", customer.custStreet1);
                rs.updateString("CustStreet2", customer.custStreet2);
                rs.updateString("CustCity", customer.custCity);
                rs.updateString("CustState", customer.custState);
                rs.updateInt("Custzip", customer.custZip);
                rs.updateLong("CustPhone", customer.custPhone);
                rs.updateString("CustEmail", customer.custEmail);
            }
            rs = mysql.doStatement(query);
            if (rs.next()) {
                cust = new Customer(
                        rs.getInt("CUSTID"),
                        rs.getString("CustFirstName"),
                        rs.getString("CustLastName"),
                        rs.getString("CustStreet1"),
                        rs.getString("CustStreet2"),
                        rs.getString("CustCity"),
                        rs.getString("CustState"),
                        rs.getInt("CustZip"),
                        rs.getLong("CustPhone"),
                        rs.getString("CustEmail"));
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            mysql.closeAll();
            return cust;
        }
     }
     
     
     
     
     // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setCUSTID(int custid){
        this.CUSTID = custid;
    }
    public void setFName(String fName){
        this.custFName = fName;
    }
    public void setLName(String lName){
        this.custLName = lName;
    }
    
    public void setStreet1(String street1){
        this.custStreet1 = street1;
    }
    public void setStreet2(String street2){
        this.custStreet2 = street2;
    }
    public void setCity(String City){
        this.custCity = City;
    }
    public void setState(String state){
        this.custState = state;
    }
    public void setZip(int zip){
        this.custZip = zip;
    }
    public void setPhone(long phone){
        this.custPhone = phone;
    }
    public void setEmail(String email){
        this.custEmail = email;
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="getters">
    public int getCustId(){
        return CUSTID;
    }
    
    public String getCustFName(){
        return custFName;
    }
    
    public String getCustLName(){
        return custLName;
    }
    
    public String getCustStreet1(){
        return custStreet1;
    }
    
    public String getCustStreet2(){
        return custStreet2;
    }
    
    public String getCustCity(){
        return custCity;
    }
    
    public String getCustState(){
        return custState;
    }
    
    public int getCustZip(){
        return custZip;
    }
    
    public long getCustPhone(){
        return custPhone;
    }
    
    public String getCustEmail(){
        return custEmail;
    }
    // </editor-fold>
}



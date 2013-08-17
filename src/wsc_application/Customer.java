package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Customer {
    
    private int CUSTID;
    private String custFName;
    private String custLName;
    private String custOrg;
    private String custStreet1;
    private String custStreet2;
    private String custCity;
    private String custState;
    private int custZip;
    private long custPhone;
    private String custEmail;
    
    //Default constructor
    public Customer(){
    }
    //Constructor with values pasted and sets variables
    public Customer(int custid, String fName, String lName, String custOrg, String street1, String street2, 
            String city, String state, int zip, long phone, String email) {
        setCUSTID(custid);
        setFName(fName);
        setLName(lName);
        setCustOrg(custOrg);
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
    //Jacob: Altered Query to include CustOrg
    public static Customer searchBy(String col, String value) {     
        Customer cust = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "select * from CUSTOMER where "
                + "" + col + " = " + value;
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
                cust = new Customer(
                        rs.getInt("CUSTID"),
                        rs.getString("CustFirstName") != null ? rs.getString("CustFirstName") : new String(),
                        rs.getString("CustLastName") != null ? rs.getString("CustLastName") : new String(),
                        rs.getString("CustOrg") != null ? rs.getString("CustOrg") : new String(),                        
                        rs.getString("CustStreet1") != null ? rs.getString("CustStreet1") : new String(),
                        rs.getString("CustStreet2") != null ? rs.getString("CustStreet2") : new String(),
                        rs.getString("CustCity") != null ? rs.getString("CustCity") : new String(),
                        rs.getString("CustState") != null ? rs.getString("CustState") : new String(),
                        rs.getInt("CustZip"),
                        rs.getLong("CustPhone"),
                        rs.getString("CustEmail") != null ? rs.getString("CustEmail") : new String());
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
             return cust;
         }
     }

    /**
     * By Paul
     * @param customer An object of Customer class
     * @return Customer object from database
     */
    //Jacob: Altered Qty to include custOrg
    public static Customer updateBy(Customer customer) {     
        Customer cust = null; 
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String query = "select * from CUSTOMER where CUSTID = " + Integer.toString(customer.CUSTID) + ";";
            rs = mysql.stmt.executeQuery(query);
            if (rs.next()) {
                rs.updateString("CustFirstName", customer.custFName);
                rs.updateString("CustLastName", customer.custLName);
                rs.updateString("CustOrg", customer.custOrg);
                rs.updateString("CustStreet1", customer.custStreet1);
                rs.updateString("CustStreet2", customer.custStreet2 != null ? customer.custStreet2 : new String());
                rs.updateString("CustCity", customer.custCity);
                rs.updateString("CustState", customer.custState);
                rs.updateInt("Custzip", customer.custZip);
                rs.updateLong("CustPhone", customer.custPhone);
                rs.updateString("CustEmail", customer.custEmail);
                rs.updateRow();
            }
            rs = mysql.doStatement(query);
            if (rs.next()) {
                cust = new Customer(
                        rs.getInt("CUSTID"),
                        rs.getString("CustFirstName"),
                        rs.getString("CustLastName"),
                        rs.getString("CustOrg"),
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
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            mysql.closeAll();
            return cust;
        }
    }
    
    /**
     * By Paul
     * Inserts a record into the DB
     * @param customer Customer object
     * @return Customer object or null if failed.
     */
    //Jacob: Altered Qty to include custOrg
    public static Customer createCust(Customer customer) {
        Customer cust = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String query = "insert into CUSTOMER values (0, '"
                    + customer.custFName + "', '"
                    + customer.custLName + "', '"
                    + customer.custOrg + "', '"
                    + customer.custStreet1 + "', '"
                    + customer.custStreet2 + "', '"
                    + customer.custCity + "', '" 
                    + customer.custState + "', '"
                    + customer.custZip + "', '"
                    + customer.custPhone + "', '"
                    + customer.custEmail + "');";
            mysql.stmt.executeUpdate(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            int key = -1;
            rs = mysql.stmt.getGeneratedKeys();
            if (rs.next()) {
                rs.getInt(1);
            }
            if (key > 0) {
                cust = Customer.searchBy("CUSTID", Integer.toString(key));
            }
            
        }   
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            return cust;
        }
    }
     
    /**
     * By Paul
     * Checks to see if a customer number is valid -- if a number is a customer?
     * @param CustId customer id as integer
     * @return boolean false, not customer; true, customer
     */
    public static boolean isCustomer(int CustId, String CustStreet1) {
        ResultSet rs;
        boolean retval = false;
        MysqlConn mysql = new MysqlConn();
        String query = "select * from CUSTOMER where CUSTID = " + Integer.toString(CustId) + " OR CustStreet1 = '"+CustStreet1+"';";
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
                retval = true;
            }
        }
        catch (SQLException ex) {
//            OptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            mysql.closeAll();
            return retval;
        }
    }
    
    //Jacob: Added to get orders for customer tab
      public static ArrayList<String> getOrders(long custid)
    {
        int i = 1;
        String temp = "";
        ArrayList<String> orders = new ArrayList<String>();
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "select ORDERID from `ORDER` WHERE CUSTID = " + Long.toString(custid) + ";";
        rs = mysql.doQuery(query);
        
         try {
            while (rs.next()) {
                temp = rs.getString("ORDERID");
                orders.add(temp);
                temp = "";
            }
            return orders;
         }
            catch (SQLException ex) {
            
                    }
         return null;
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
    
    public void setCustOrg(String custOrg){
        this.custOrg = custOrg;
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
    
   public String getCustOrg(){
        return custOrg;
    }
    // </editor-fold>
}

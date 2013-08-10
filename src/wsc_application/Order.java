package wsc_application;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Order {    
    private Customer customer;
    private int ORDID;
    private String mediaType;
    private String content;
    private float total;
    private boolean paymentOnAccount;
    private float deposit;
    private String orderStatus;
    private Employee modifiedBy;
    private String mediaStatus;
//    private CatalogItem catalogItem;
//    private Employee createdBy;
//    private Employee assignedTo;
    
    protected static ArrayList<Order> orders;
    
    public Order(){
    }

    public Order(Customer cust, int OrderId, String mediaType,
            String content, Boolean onAcct, float total, float deposit, 
            String orderStatus, String mediaStatus, Employee modBy){
        setCustomer(cust);
        setORDID(OrderId);
        setMediaType(mediaType);
        setContent(content);
        setTotal(total);
        setPaymentOnAccount(onAcct);
        setDeposit(deposit);
        setOrderStatus(orderStatus);
        setMediaStatus(mediaStatus);
        setModifiedBy(modBy);
//        setCatalogItem(catItem);
//        setCreatedBy(createBy);
//        setAssignedTo(assignTo);
    }
    
    // Search by Customer ID only?  Not sure!
    /**
     * Create an ArrayList of Order objects by customer.
     * @param CustId Customer ID as integer
     * @return An array list of order objects; A search by customer ID can 
     * 
     */
    public static ArrayList searchBy(int CustId) {
        orders = new ArrayList(0);
        Order order = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "select * from ORDER where CUSTID = " + CustId + ";";
        rs = mysql.doQuery(query);
        try {
            while (rs.next()) {
                Employee employee;
                Customer customer;
                employee = Employee.searchBy(rs.getLong("EMPID"));
                customer = Customer.searchBy("CUSTID", rs.getString("CUSTID"));
                order = new Order(
                        customer,
                        rs.getInt("ORDERID"),
                        rs.getString("MediaType"),
                        rs.getString("Content"),
                        rs.getBoolean("PaymentOnAccount"),
                        rs.getFloat("Total"),
                        rs.getFloat("Deposit"),
                        rs.getString("OrderStatus"),
                        rs.getString("MediaStatus"),
                        employee);
                // Add the new order to the ArrayList
                orders.add(order);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return orders;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer cust){
        this.customer = cust;
    }
    public int getORDID(){
        return ORDID;
    }
    public void setORDID(int ordID){
        this.ORDID = ordID;
    }
    public CatalogItem getCatalogItem(){
        return catalogItem;
    }
    public void setCatalogItem(CatalogItem catItem){
        this.catalogItem = catItem;
    }
    public String getMediaType(){
        return mediaType;
    }
    public void setMediaType(String medType){
        this.mediaType = medType;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String cont){
        this.content = cont;
    }
    public float getTotal(){
        return total;
    }
    public void setTotal(float tot){
        this.total = tot;
    }
    public Boolean getPaymentOnAccount(){
        return paymentOnAccount;
    }
    public void setPaymentOnAccount(Boolean onAcct){
        this.paymentOnAccount = onAcct;
    }
    public float getDeposit(){
        return deposit;
    }
    public void setDeposit(float dep){
        this.deposit = dep;
    }
    public String getOrderStatus(){
        return orderStatus;
    }
    public void setOrderStatus(String ordStat){
        this.orderStatus = ordStat;
    }
    public String getMediaStatus(){
        return mediaStatus;
    }
    public void setMediaStatus(String medStat){
        this.mediaStatus = medStat;
    }
//    public Employee getCreatedBy(){
//        return createdBy;
//    }
//    public void setCreatedBy(Employee createBy){
//        this.createdBy = createBy;
//    }
    public Employee getModifiedBy(){
        return modifiedBy;
    }
    public void setModifiedBy(Employee modBy){
        this.modifiedBy = modBy;
    }
//    public Employee getAssignedTo(){
//        return assignedTo;
//    }
//    public void setAssignedTo(Employee assignTo){
//        this.assignedTo = assignTo;
//    }
    //</editor-fold>
}

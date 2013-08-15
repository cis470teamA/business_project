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
    private int paymentOnAccount;
    private float deposit;
    private OrderStatus orderStatus;
    private Employee createdBy;
    public MediaStatus mediaStatus;
    public enum OrderStatus {
        Shipped("Shipped"), Pending("Pending"), Complete("Complete"),
        Hold("On Hold"), InProgress("In Progress");
        private String value;
        private OrderStatus(String value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return this.value;
        }
    }
    public enum MediaStatus {
        Requested("Requested"), Sold("Sold"), enRoute("En Route"),
        requestedOrder("Requested Order"), onOrder("On Order"), 
        Delivered("Delivered");
        private String value;
        private MediaStatus(String value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return this.value;
        }
    }
    protected static ArrayList<Order> orders;
    
    public Order() {}

    public Order(Customer cust, int OrderId, String mediaType,
            String content, Boolean onAcct, float total, float deposit, 
            String orderStatus, String mediaStatus, Employee createdBy){
        setCustomer(cust);
        setORDID(OrderId);
        setMediaType(mediaType);
        setContent(content);
        setTotal(total);
        setPaymentOnAccount(onAcct);
        setDeposit(deposit);
        setOrderStatus(orderStatus);
        setMediaStatus(mediaStatus);
        setCreatedBy(createdBy);
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.ORDID);
    }
    
    // Search by Customer ID only?  Not sure!
    /**
     * Create an ArrayList of Order objects by customer.
     * @param CustId Customer ID as integer
     * @return An array list of order objects; A search by customer ID can 
     * 
     */
    public static ArrayList getOrders(int CustId) {
        orders = new ArrayList(0);
        Order order;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
            String query = "select * from cis470.ORDER where CUSTID = " + CustId + ";";
        System.out.println(query);
        try {
            rs = mysql.doQuery(query);
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
    
    public static Order getOrder(int orderId) {
        Order order = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "select * from cis470.ORDER where ORDERID = " + orderId + ";";
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
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
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return order;
    }
    
    public static Order createOrder(Order order) {
        Order thisOrder = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String query = "INSERT INTO cis470.ORDER values (0, '"
                    + order.customer.getCustId() + "', '"
                    + order.createdBy.getEmpId() + "', '"
                    + order.orderStatus + "', '"
                    + order.mediaType + "', '"
                    + order.mediaStatus + "', '"
                    + order.content + "', '"
                    + order.paymentOnAccount + "', '"
                    + order.total + "', '" +
                    + order.deposit + "');";
            System.out.println(query);
            mysql.stmt.executeUpdate(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            int key = -1;
            rs = mysql.stmt.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
            if (key > 0) {
                thisOrder = Order.getOrder(key);
            }
        }   
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            return thisOrder;
        }
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
        if (this.paymentOnAccount == 0)
            return false;
        else
            return true;
    }
    public void setPaymentOnAccount(Boolean onAcct){
        if (onAcct)
            this.paymentOnAccount = 1;
        else
            this.paymentOnAccount = 0;
    }
    public float getDeposit(){
        return deposit;
    }
    public void setDeposit(float dep){
        this.deposit = dep;
    }
    // By Paul
    public String getOrderStatus(){
        return orderStatus.toString();
    }
    // By Paul
    public void setOrderStatus(String status){
        switch (status.toLowerCase()) {
            case "shipped":
                this.orderStatus = OrderStatus.Shipped;
                break;
            case "in progress":
                this.orderStatus = OrderStatus.InProgress;
                break;
            case "pending":
                this.orderStatus = OrderStatus.Pending;
                break;
            case "hold":
                this.orderStatus = OrderStatus.Hold;
                break;
            case "complete":
                this.orderStatus = OrderStatus.Complete;
                break;
            default:
                this.orderStatus = OrderStatus.Hold;
        }    
    }
    // By Paul
    public String getMediaStatus(){
        return this.mediaStatus.toString();
    }
    // By Paul
    public void setMediaStatus(String status){
        switch (status.toLowerCase()) {
            case "requested":
                this.mediaStatus = MediaStatus.Requested;
                break;
            case "sold":
                this.mediaStatus = MediaStatus.Sold;
                break;
            case "en route":
                this.mediaStatus = MediaStatus.enRoute;
                break;
            case "requested order":
                this.mediaStatus = MediaStatus.requestedOrder;
                break;
            case "on order":
                this.mediaStatus = MediaStatus.onOrder;
                break;
            case "delivered":
                this.mediaStatus = MediaStatus.Delivered;
                break;
            default:
                this.mediaStatus = MediaStatus.Requested;
    }
    }
    public Employee getCreatedBy(){
        return createdBy;
    }
    public void setCreatedBy(Employee createdBy){
        this.createdBy = createdBy;
    }
    //</editor-fold>
}

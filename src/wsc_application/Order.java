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

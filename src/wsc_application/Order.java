package wsc_application;

public class Order {
    
    
    private Customer customer;
    private int ORDID;
    private CatalogItem catalogItem;
    private String mediaType;
    private String content;
    private float total;
    private boolean onAccount;
    private float deposit;
    private String orderStatus; 
    private String mediaStatus;
    private Employee createdBy;
    private Employee modifiedBy;
    private Employee assignedTo;
    
    
    public Order(){
        
    }
    public Order(Customer cust, int ordID, CatalogItem catItem, String medType,
            String cont, float tot, Boolean onAcct, float dep,
            String ordStat, String medStat, Employee createBy, Employee modBy, 
            Employee assignTo){
        
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer cust){
        customer = cust;
    }
    public int getORDID(){
        return ORDID;
    }
    public void setORDID(int ordID){
        ORDID = ordID;
    }
    public CatalogItem getCatalogItem(){
        return catalogItem;
    }
    public void setCatalogItem(CatalogItem catItem){
        catalogItem = catItem;
    }
    public String getMediaType(){
        return mediaType;
    }
    public void setMediaType(){
        
    }
    public String getContent(){
        return content;
    }
    public void setContent(String cont){
        content = cont;
    }
    public float getTotal(){
        return total;
    }
    public void setTotal(float tot){
        total = tot;
    }
    public Boolean getOnAccount(){
        return onAccount;
    }
    public void setOnAccount(Boolean onAcct){
        onAccount = onAcct;
    }
    public float getDeposit(){
        return deposit;
    }
    public void setDeposit(float dep){
        deposit = dep;
    }
    public String getOrderStatus(){
        return orderStatus;
    }
    public void setOrderStatus(String ordStat){
        orderStatus = ordStat;
    }
    public String getMediaStatus(){
        return mediaStatus;
    }
    public void setMediaStatus(String medStat){
        mediaStatus = medStat;
    }
    public Employee getCreatedBy(){
        return createdBy;
    }
    public void setCreatedBy(Employee createBy){
        createdBy = createBy;
    }
    public Employee getModifiedBy(){
        return modifiedBy;
    }
    public void setModifiedBy(Employee modBy){
        modifiedBy = modBy;
    }
    public Employee getAssignedTo(){
        return assignedTo;
    }
    public void setAssignedTo(Employee assignTo){
        assignedTo = assignTo;
    }
}

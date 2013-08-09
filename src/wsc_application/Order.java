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
        setCustomer(cust);
        setORDID(ordID);
        setCatalogItem(catItem);
        setMediaType(medType);
        setContent(cont);
        setTotal(tot);
        setOnAccount(onAcct);
        setDeposit(dep);
        setOrderStatus(ordStat);
        setMediaStatus(medStat);
        setCreatedBy(createBy);
        setModifiedBy(modBy);
        setAssignedTo(assignTo);
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
    public Boolean getOnAccount(){
        return onAccount;
    }
    public void setOnAccount(Boolean onAcct){
        this.onAccount = onAcct;
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
    public Employee getCreatedBy(){
        return createdBy;
    }
    public void setCreatedBy(Employee createBy){
        this.createdBy = createBy;
    }
    public Employee getModifiedBy(){
        return modifiedBy;
    }
    public void setModifiedBy(Employee modBy){
        this.modifiedBy = modBy;
    }
    public Employee getAssignedTo(){
        return assignedTo;
    }
    public void setAssignedTo(Employee assignTo){
        this.assignedTo = assignTo;
    }
}

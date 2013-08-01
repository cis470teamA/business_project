package wsc_application;

public class OldCustomer {
    
    private int customerId;
    private String billTitle;
    private String billFName;
    private String billLName;
    private String billStAddress;
    private String billStAddress2;
    private String billState;
    private int billZip;
    private int phoneNumber;
    private String emailAddr;
    private int faxNumber;
    private String shipFName;
    private String shipLName;
    private String shipStAddress;
    private String shipStAddress2;
    private String shipState;
    private int shipZip;
    private int createdBy;
    private String dateCreated;
    private double accountBalance;

    //default constructor for Customer
    public OldCustomer (){
        // Code goes here; 
        // basically, do nothing since we didn't receive any constructor args
    }
    
    //overloaded constructor for Customer
    public OldCustomer(int custId, String bFName, String bLName, String bStAddr, String bStAddr2, String bState,
            int bZip, int phone, String email, int fax, String sFName, String sLName, String sStAddr,
            String sStAddr2, String sState, int sZip, OldEmployee created_by, String date_created, double acctBal){
        // Code goes to set all the instance attributes
    }
    
    /* 
     * START getters and setter methods
     */
    public void setCustId(int value){
        this.customerId = value;
    }
    
    public int getCustId(){
        return this.customerId;
    }
    
    public void setBillTitle(String value){
        this.billTitle = value;
    }
    
    public String getBillTitle(){
        return this.billTitle;
    }
        
    public void setBillFName(String value){
        this.billFName = value;
    }
    
    public String getBillFName(){
        return this.billFName;
    }
    
    public void setBillLName(String value){
        this.billLName = value;
    }
    
    public String getBillLName(){
        return this.billLName;
    }
    
    public void setBillStAddr(String value){
        this.billStAddress = value;
    }
    
    public String getBillStAddr(){
        return this.billStAddress;
    }
    
    public void setBillStAddr2(String value){
        this.billStAddress2 = value;
    }
    
    public String getBillStAddr2(){
        return this.billStAddress2;
    }
    
    public void setBillState(String value){
        this.billState = value;
    }
    
    public String getBillState(){
        return this.billState;
    }
    
    public void setBillZip(int value){
        this.billZip = value;
    }
    
    public int getBillZip(){
        return this.billZip;
    }
    
    public void setShipFName(String value){
        this.shipFName = value;
    }
    
    public String getShipFName(){
        return this.shipFName;
    }
    
    public void setShipLName(String value){
        this.shipLName = value;
    }
    
    public String getShipLName(){
        return this.shipLName;
    }
    
    public void setShipStAddr(String value){
        this.shipStAddress = value;
    }
    
    public String getShipStAddr(){
        return this.shipStAddress;
    }
    
    public void setShipStAddr2(String value){
        this.shipStAddress2 = value;
    }
    
    public String getShipStAddr2(){
        return this.shipStAddress2;
    }
    
    public void setShipState(String value){
        this.shipState = value;
    }
    
    public String getShipState(){
        return this.shipState;
    }
    
    public void setShipZip(int value){
        this.shipZip = value;
    }
    
    public int getShipZip(){
        return this.shipZip;
    }
    /*
     * END getters and setters
     */
    
    
}

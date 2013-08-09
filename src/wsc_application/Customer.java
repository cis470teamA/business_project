package wsc_application;

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
    
    public Customer(){
    }
     public Customer(int custid, String fName, String lName,String org, String street1,
            String street2, String city, String state, int zip, int phone, String email) {
        setCUSTID(custid);
        setFName(fName);
        setLName(lName);
        setOrg(org);
        setStreet1(street1);
        setStreet2(street2);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhone(phone);
        setEmail(email);
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
    public void setOrg(String org){
        this.custOrg = org;
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
    public void setPhone(int phone){
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
    
    public String getCustOrg(){
        return custOrg;
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



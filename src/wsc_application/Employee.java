package wsc_application;

public class Employee{
    
    protected String firstName;
    protected String lastName;
    protected Long EMPID;
    protected String email;
    
    public enum type {
        SalesPerson, EngrSpec, PrintSpec, StockClerk, OpsMan;
    }
    
    public Employee() {
        
    }
    
    // Employee class code goes here.  Methods and stuff.
    
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
    
    // <editor-fold defaultstate="collapsed" desc="getters">
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

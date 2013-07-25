/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package srproject;

/**
 *
 * @author Bradley
 */
public class Customer {
    
    private static int customerId;
    private static String billTitle;
    private static String billFName;
    private static String billLName;
    private static String billStAddress;
    private static String billStAddress2;
    private static String billState;
    private static int billZip;
    private static int phoneNumber;
    private static String emailAddr;
    private static int faxNumber;
    private static String shipFName;
    private static String shipLName;
    private static String shipStAddress;
    private static String shipStAddress2;
    private static String shipState;
    private static int shipZip;
    private static int createdBy;
    private static String dateCreated;
    private double accountBalance;
    
    public Customer (){
        //default constructor for Customer
    }
    public Customer(int custId, String bFName, String bLName, String bStAddr, String bStAddr2, String bState,
            int bZip, int phone, String email, int fax, String sFName, String sLName, String sStAddr,
            String sStAddr2, String sState, int sZip, Employee created_by, String date_created, double acctBal){
        //overloaded constructor for Customer
    
    }
    public static void setCustId(){
        
    }
    public static int getCustId(){
        return customerId;
    }
    public static void setBillFName(){
        
    }
    public static String getBillFName(){
        return billFName;
    }
    public static void setBillLName(){
        
    }
    public static String getBillLName(){
        return billLName;
    }
    public static void setBillStAddr(){
        
    }
    public static String getBillStAddr(){
        return billStAddress;
    }
    public static void setBillStAddr2(){
        
    }
    public static String getBillStAddr2(){
        return billStAddress2;
    }
    public static void setBillState(){
        
    }
    public static String getBillState(){
        return billState;
    }
    public static void setBillZip(){
        
    }
    public static int getBillZip(){
        return billZip;
    }
    public static void setShipFName(){
        
    }
    public static String getShipFName(){
        return shipFName;
    }
    public static void setShipLName(){
        
    }
    public static String getShipLName(){
        return shipLName;
    }
    public static void setShipStAddr(){
        
    }
    public static String getShipStAddr(){
        return shipStAddress;
    }
    public static void setShipStAddr2(){
        
    }
    public static String getShipStAddr2(){
        return shipStAddress2;
    }
    public static void setShipState(){
        
    }
    public static String getShipState(){
        return shipState;
    }
    public static void setShipZip(){
        
    }
    public static int getShipZip(){
        return shipZip;
    }
    
    
}

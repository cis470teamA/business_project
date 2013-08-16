package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * OrderVerify Class
 * Class Created By Jacob Savage
 * Static SQL methods created by
 * Paul Durivage & Brad Clawson 
 * for CIS470 GroupA
 * 8/17/2013 
 */

public class InventoryItem {
    
    //Global Variables
    private int itemId;
    private int manid;
    private String name;
    private int qtyOnHand;
    private int qtyOnOrder;
    private String deliveryDate;
    
    //Constructor
    public InventoryItem(){
        
    }
    //Overloaded constructor to create InventoryItem Object
    public InventoryItem(int itemNum,int manufacturer, String itemName, int onHand,
            int onOrder, String delDate){
        setItemNum(itemNum);
        setManufacturerID(manufacturer);
        setName(itemName);
        setQtyOnHand(onHand);
        setQtyOnOrder(onOrder);
        setDeliveryDate(delDate);
    }
    
    public Boolean checkExistBy(String column, String id){
        Boolean itemExist = false;
        InventoryItem ii = null;
         ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "Select * from cis470.INVENTORY WHERE "
                    + column + " = " + id;
        //if result set is populated record exists & bool value set to true          
        rs = mysql.doQuery(query);
        try {
            if (rs.next()){
                itemExist = true;
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
       }return itemExist;
    }
    //This method searches for a InventoryItem by ITEMID or MANID and returns a copy of the II that is found
    public static InventoryItem getIIby(String column, String id){
        InventoryItem ii = null;
         ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "Select * from cis470.QUALITYASSURANCE WHERE "
                    + column + " = " + id;
                    
        rs = mysql.doQuery(query);
        //create new InventoryItem object with data found in Database
        try {
            if (rs.next()) {
                ii = new InventoryItem(
                        rs.getInt("ITEMID"),
                        rs.getInt("MANID"),
                        rs.getString("Name") != null ? rs.getString("Name") : new String(),
                        rs.getInt("QtyOnHand"),
                        rs.getInt("QtyOnOrder"),
                        rs.getString("DiliveryDate") != null ? rs.getString("DeliveryDate") : new String());         
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
         }
        //if no sql errors, return created II object
         finally {
             mysql.closeAll();
             return ii;
         }
        
    }
    //this method inserts or updates a II record in the database
    public static InventoryItem insertOrUpdateII(InventoryItem ii){
        InventoryItem thisII = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            /*create query for INSERT INTO INVENTORY ON DUPLICATE KEY UPDATE. Using this method reduces redundant code
             * and allowed for a single submit button to be used on the II tab
             */ 
            String query = "INSERT INTO INVENTORY (ITEMID,MANID,Name,QtyOnHand,QtyOnOrder,DeliveryDate)"
                    + " values ("
                    + ii.itemId + ", "
                    + ii.manid + ", '"
                    + ii.name + "', "
                    + ii.qtyOnHand + ", "
                    + ii.qtyOnOrder + ", '"
                    + ii.deliveryDate + "')"
                    //if record with ItemID exists UPDATE instead of INSERT
                    + "ON DUPLICATE KEY UPDATE " 
                    + "ITEMID" + ii.itemId + ", "
                    + "MANID = "+ ii.manid + ", "
                    + "Name = '" + ii.name + "', "
                    + "QtyOnHand = " + ii.qtyOnHand + ", "
                    + "QtyOnOrder = " + ii.qtyOnOrder + ", "
                    + "workmanship = '" + ii.deliveryDate + "';";
            System.out.println(query);
            mysql.stmt.executeUpdate(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            int key = -1;
            rs = mysql.stmt.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
            //search for updated/inserted record to verify action
            if (key > 0) {
                thisII = InventoryItem.getIIby("ITEMID", String.valueOf(key));
            }
        }   
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        //return verified object
        finally {
            mysql.closeAll();
            return thisII;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Inc/Dec onOrder onHand">
    public void incrementQtyOnHand(){
        this.qtyOnHand = qtyOnHand + 1;
    }
    public void decrementQtyOnHand(){
        this.qtyOnHand = qtyOnHand - 1;
    }
    public void incrementQtyOnOrder(){
        this.qtyOnOrder = qtyOnOrder + 1;
    }
    public void decrementQtyOnOrder(){
        this.qtyOnOrder = qtyOnOrder - 1;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setters">
    
    public void setItemNum(int itemId){
        this.itemId = itemId;
    }
    
    public void setManufacturerID(int manufacturerID){
        this.manid = manufacturerID;
    }
    
    public void setName(String itemName){
        this.name = itemName;
    }
    
    public void setQtyOnHand(int qtyOnHand){
        this.qtyOnHand = qtyOnHand;
    }
    
    
    public void setQtyOnOrder(int qtyOnOrder){
        this.qtyOnOrder = qtyOnOrder;
    }
    
     public void setDeliveryDate(String deliveryDate){
        this.deliveryDate = deliveryDate;
    }
      // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters">
     public int getItemNumber(){
         return itemId;
     }
     public String getName(){
         return name;
     }
     public int getManufacturerID(){
         return manid;
     }
     public int getQtyOnHand(){
         return qtyOnHand;
     }
     public int getQtyOnOrder(){
         return qtyOnOrder;
     }
     public String getDeliveryDate(){
         return deliveryDate;
     }
     //</editor-fold>
}

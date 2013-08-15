package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InventoryItem {
    
    //Global Variables
    private String itemId;
    private String manufacturer;
    private String itemName;
    private int qtyOnHand;
    private int qtyOnOrder;
    private String deliveryDate;
    
    //Constructor
    public InventoryItem(){
        
    }
    public InventoryItem(String itemNum, String manufacturer, String itemName, int onHand,
            int onOrder, String delDate){
        setItemNum(itemNum);
        setManufacturer(manufacturer);
        setItemName(itemName);
        setQtyOnHand(onHand);
        setQtyOnOrder(onOrder);
        setDeliveryDate(delDate);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    
    public void setItemNum(String itemNum){
        this.itemId = itemNum;
    }
    
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    
    public void setItemName(String itemName){
        this.itemName = itemName;
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
     public String getItemNumber(){
         return itemId;
     }
     public String getItemName(){
         return itemName;
     }
     public String getManufacturer(){
         return manufacturer;
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

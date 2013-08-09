package wsc_application;

public class CatalogItem {
    
    //Global Variables
    private String itmNum;
    private String manufacturer;
    private String itmName;
    private int qtyOnHand;
    private int qtyOnOrder;
    private String deliveryDate;
    
    //Constructor
    public CatalogItem(){
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setItmNum(String itmNum){
        this.itmNum = itmNum;
    }
    
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    
    public void setItmName(String itmName){
        this.itmName = itmName;
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
}

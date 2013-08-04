package wsc_application;

public class Order {
    
    
    private Customer customer;
    private long OrderID;
    private CatalogItem catalogItem;
    private boolean jobType;
    private boolean engrType;
    private float total;
    private float deposit;
    private boolean onAccount;
    private enum orderStatus 
    {CREATED, FAIL_VERIFIED, VERIFIED, WORKING, MEDIA_HOLD, COMPLETE, QA_PASS,
    QA_FAIL, CLOSED};
    private enum mediaStatus
    {REQUESTED, SOLD, VERIFIED_SOLD, ON_ORDER, DELIVERED};
    private String orderContent;
    private Employee createdBy;
    private Employee lastModifiedBy;
    private Employee verifiedBy;
    private Employee assignedTo;
    
    
    
    
}

package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * OrderVerify Class
 * Class Created By Brad Clawson
 * Static SQL methods created by
 * Paul Durivage & Brad Clawson 
 * for CIS470 GroupA
 * 8/16/2013 
 */

public class OrderVerify {
    //variable declaration, bool values are recorded as int for db use
    private int VERID;
    private Order order;
    private Employee verifiedBy;
    private int nameCheck;
    private int accountCheck;
    private int mediaCheck;
    private int contentCheck;
    private int paymentCheck;
    private int depositCheck;
    private String nameFailComment;
    private String accountFailComment;
    private String mediaFailComment;
    private String contentFailComment;
    private String paymentFailComment;
    private String depositFailComment;
    private String correctiveActionComment;
    
    public OrderVerify(){
        
    }
    //overloaded constructor for creating new OrderVerify object
    public OrderVerify(int verID, Employee verBy, Order ord, Boolean nameChk,
            Boolean acctChk, Boolean medChk, Boolean contChk, Boolean payChk,
            Boolean depChk, String nameFail, String acctFail, String medFail,
            String contFail, String payFail, String depFail,
            String corrActComm){
        setVerID(verID);
        setOrder(ord);
        setVerifiedBy(verBy);
        setNameCheck(nameChk);
        setAccountCheck(acctChk);
        setMediaCheck(medChk);
        setContentCheck(contChk);
        setPaymentCheck(payChk);
        setDepositCheck(depChk);
        setNameFailComment(nameFail);
        setAccountFailComment(acctFail);
        setMediaFailComment(medFail);
        setContentFailComment(contFail);
        setPaymentFailComment(payFail);
        setDepositFailComment(depFail);
        setCorrectiveActionComment(corrActComm);        
        }
    //this method checks to see if record exist in db by ORDERID or VERID
    public Boolean checkExistBy(String column, int id){
        Boolean ovExist = false;
        OrderVerify ov = null;
         ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "Select * from cis470.ORDERVERIFY WHERE "
                    + column + " = " + id;
        //if result set is populated then record exists & bool is set to true           
        rs = mysql.doQuery(query);
        try {
            if (rs.next()){
                ovExist = true;
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
       }return ovExist;
    }
    //this method searches the db by ORDERID or VERID and returns an OrderVerify object if found 
    public static OrderVerify getOVby(String column, int id){
        OrderVerify ov = null;
         ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        String query = "Select * from cis470.ORDERVERIFY WHERE "
                    + column + " = " + id;
        System.out.println(query);
        rs = mysql.doQuery(query);
        try {
            if (rs.next()) {
                //Create new OrderVerify object with data from record
                ov = new OrderVerify(
                        rs.getInt("VERID"),
                        Employee.searchBy(rs.getInt("EMPID")),  
                        Order.getOrder(rs.getInt("ORDERID")),
                        rs.getBoolean("nameCheck"),
                        rs.getBoolean("accountCheck"),
                        rs.getBoolean("mediaCheck"),
                        rs.getBoolean("contentCheck"),
                        rs.getBoolean("paymentCheck"),
                        rs.getBoolean("depositCheck"),
                        rs.getString("nameFailComment") != null ? rs.getString("nameFailComment") : new String(),
                        rs.getString("accountFailComment") != null ? rs.getString("accountFailComment") : new String(),                        
                        rs.getString("mediaFailComment") != null ? rs.getString("mediaFailComment") : new String(),
                        rs.getString("contentFailComment") != null ? rs.getString("contentFailComment") : new String(),
                        rs.getString("paymentFailComment") != null ? rs.getString("paymentFailComment") : new String(),
                        rs.getString("depositFailComment") != null ? rs.getString("depositFailComment") : new String(),
                        rs.getString("correctiveActionComment") != null ? rs.getString("correctiveActionComment") : new String());
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
         }
        //if no errors, return newly created OrderVerify object
         finally {
             mysql.closeAll();
             return ov;
         }
        
    }
    //this method inserts or updates an ORDERVERIFY record in the database
    public static OrderVerify insertOrUpdateOV(OrderVerify ov){
        OrderVerify thisOV = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
             /*create query for INSERT INTO QA ON DUPLICATE KEY UPDATE. Using this method reduces redundant code
             * and allowed for a single submit button to be used on the QA tab
             */ 
            String query = "INSERT INTO ORDERVERIFY (VERID,EMPID,ORDERID,nameCheck,"
                    + "accountCheck,mediaCheck,contentCheck,paymentCheck,depositCheck,nameFailComment,"
                    + "accountFailComment,mediaFailComment,contentFailComment,paymentFailComment,"
                    + "depositFailComment,correctiveActionComment)"
                    + " values ("
                    + ov.VERID + ", "
                    + ov.verifiedBy.getEmpId() + ", "
                    + ov.order.getORDID() + ", "
                    + ov.nameCheck + ", "
                    + ov.accountCheck + ", "
                    + ov.mediaCheck + ", "
                    + ov.contentCheck + ", "
                    + ov.paymentCheck + ", "
                    + ov.depositCheck + ", '"
                    + ov.nameFailComment + "', '"
                    + ov.accountFailComment + "', '"
                    + ov.mediaFailComment + "', '"
                    + ov.contentFailComment + "', '"
                    + ov.paymentFailComment + "', '"
                    + ov.depositFailComment + "', '"
                    + ov.correctiveActionComment + "')"
                    //if record with VERID exists UPDATE instead of INSERT
                    + "ON DUPLICATE KEY UPDATE " 
                    + "EMPID = " + ov.verifiedBy.getEmpId() + ", "
                    + "ORDERID = "+ ov.order.getORDID() + ", "
                    + "nameCheck = " + ov.getNameCheck() + ", "
                    + "accountCheck = " + ov.getAccountCheck() + ", "
                    + "mediaCheck = " + ov.getMediaCheck() + ", "
                    + "contentCheck = " + ov.getContentCheck() + ", "
                    + "paymentCheck = " + ov.getPaymentCheck() + ", "
                    + "depositCheck = " +ov.getDepositCheck() + ", "
                    + "nameFailComment = '" + ov.nameFailComment + "', "
                    + "accountFailComment = '" + ov.accountFailComment + "', "
                    + "mediaFailComment = '" + ov.mediaFailComment + "', "
                    + "contentFailComment = '" + ov.contentFailComment + "', "
                    + "paymentFailComment = '" + ov.paymentFailComment + "', "
                    + "depositFailComment = '" + ov.depositFailComment + "', "
                    + "correctiveActionComment = '" + ov.correctiveActionComment
                    + "';";
            System.out.println(query);
            mysql.stmt.executeUpdate(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            int key = -1;
            rs = mysql.stmt.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
            //search for updated/inserted record to verify action
            if (key > 0) {
                thisOV = OrderVerify.getOVby("VERID", key);
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
            return thisOV;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="getters">
    public int getVerID(){
        return VERID;
    }
    public Order getOrder(){
        return order;
    }
    public Employee getVerifiedBy(){
        return verifiedBy;
    }    
    public Boolean getNameCheck(){
        if (nameCheck == 1){
            return Boolean.TRUE;}
        else{
            return Boolean.FALSE;
        }
    }
    public String getCorrectiveActionComment(){
        return correctiveActionComment;
    }
    public Boolean getAccountCheck(){
        if (accountCheck == 1){
            return Boolean.TRUE;}
        else{
            return Boolean.FALSE;
        }
    }    public Boolean getContentCheck(){
        if (contentCheck == 1){
            return Boolean.TRUE;}
        else{
            return Boolean.FALSE;
        }
    }    public Boolean getPaymentCheck(){
        if (paymentCheck == 1){
            return Boolean.TRUE;}
        else{
            return Boolean.FALSE;
        }
    }
    public String getNameFailComment(){
        return nameFailComment;
    }
    public Boolean getMediaCheck(){
        if (mediaCheck == 1){
            return Boolean.TRUE;}
        else{
            return Boolean.FALSE;
        }
    }
    public Boolean getDepositCheck(){
        if (depositCheck == 1){
            return Boolean.TRUE;}
        else{
            return Boolean.FALSE;
        }
    }
    public String getAccountFailComment(){
        return accountFailComment;
    }
    public String getMediaFailComment(){
        return mediaFailComment;
    }
    public String getContentFailComment(){
        return contentFailComment;
    }
    public String getDepositFailComment(){
        return depositFailComment;
    }
    public String getPaymentFailComment(){
        return paymentFailComment;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setVerID(int verID){
        VERID = verID;
    }
    public void setOrder(Order ord){
        order = ord;
    }
    public void setVerifiedBy(Employee verBy){
        verifiedBy = verBy;
    }
    public void setNameCheck(Boolean nameChk){
        if (nameChk){
            nameCheck = 1;
        }
        else{
            nameCheck = 0;
        }
    }
    public void setAccountCheck(Boolean acctChk){
        if (acctChk){
            accountCheck = 1;
        }
        else{
            accountCheck = 0;
        }
    }
    public void setMediaCheck(Boolean medChk){
        if (medChk){
            mediaCheck = 1;
        }
        else{
            mediaCheck = 0;
        }
    }
    public void setContentCheck(Boolean contChk){
        if (contChk){
            contentCheck = 1;
        }
        else{
            contentCheck = 0;
        }
    }
    public void setPaymentCheck(Boolean payChk){
        if (payChk){
            paymentCheck = 1;
        }
        else{
            paymentCheck = 0;
        }
    }
    public void setDepositCheck(Boolean depChk){
        if (depChk){
            depositCheck = 1;
        }
        else{
            depositCheck = 0;
        }
    }
    public void setNameFailComment(String nameFail){
        nameFailComment = nameFail;
    }
    public void setAccountFailComment(String acctFail){
        accountFailComment = acctFail;
    }
    public void setMediaFailComment(String medFail){
        mediaFailComment = medFail;
    }
    public void setContentFailComment(String contFail){
        contentFailComment = contFail;
    }
    public void setPaymentFailComment(String payFail){
        paymentFailComment = payFail;
    }
    public void setDepositFailComment(String depFail){
        depositFailComment = depFail;
    }
    public void setCorrectiveActionComment(String corrActComm){
        correctiveActionComment = corrActComm;
    }
    //</editor-fold>
}

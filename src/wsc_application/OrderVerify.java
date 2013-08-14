/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsc_application;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bradley
 */
public class OrderVerify {
    private int VERID;
    private Order order;
    private Employee verifiedBy;
    private Boolean nameCheck;
    private Boolean accountCheck;
    private Boolean mediaCheck;
    private Boolean contentCheck;
    private Boolean jobTypeCheck;
    private Boolean paymentCheck;
    private Boolean depositCheck;
    private String nameFailComment;
    private String accountFailComment;
    private String mediaFailComment;
    private String contentFailComment;
    private String jobTypeFailComment;
    private String paymentFailComment;
    private String depositFailComment;
    private String correctiveActionComment;
    
    public OrderVerify(){
        
    }
    public OrderVerify(int verID, Order ord, Employee verBy, Boolean nameChk,
            Boolean acctChk, Boolean contChk, Boolean jobChk, Boolean payChk,
            Boolean depChk, String nameFail, String acctFail, String medFail,
            String contFail, String jobFail, String payFail, String depFail,
            String corrActComm){
        }
    
    public Boolean checkExistBy(String column, int id){
        Boolean ovExist = false;
        
        return ovExist;
    }
    public static OrderVerify getOVby(String column, int id){
        OrderVerify ov = null;
         ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String query = "Select * from cis470.ORDERVERIFY WHERE "
                    + column + " = " + id;
                    ov = new OrderVerify(
                            
                            );
                    }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ov;
    }
    public static OrderVerify insertOrUpdateOV(OrderVerify ov){
        OrderVerify thisOV = null;
        ResultSet rs;
        MysqlConn mysql = new MysqlConn();
        try {
            mysql.stmt = mysql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            String query = "INSERT INTO cis470.ORDERVERIFY values ('"
                    + ov.getVerID() + "', '"
                    + ov.verifiedBy.getEmpId() + "', '"
                    + ov.order.getORDID() + "', '"
                    + ov.getNameCheck() + "', '"
                    + ov.getAccountCheck() + "', '"
                    + ov.getMediaCheck() + "', '"
                    + ov.getContentCheck() + "', '"
                    + ov.getJobCheck() + "', '"
                    + ov.getPaymentCheck() + "', '"
                    + ov.getDepositCheck() + "', '"
                    + ov.getNameFailComment() + "', '"
                    + ov.getAccountFailComment() + "', '"
                    + ov.getMediaFailComment() + "', '"
                    + ov.getContentFailComment() + "', '"
                    + ov.getJobTypeFailComment() + "', '"
                    + ov.getPaymentFailComment() + "', '"
                    + ov.getDepositFailComment() + "', '"
                    + ov.getCorrectiveActionComment() + "')"
                    + "ON DUPLICATE KEY UPDATE cis470.ORDERVERIFY" 
                    + "SET verifiedBy = '" + ov.verifiedBy.getEmpId() + "', '"
                    + "ORDERID = '"+ ov.order.getORDID() + "', '"
                    + "nameCheck = '" + ov.getNameCheck() + "', '"
                    + "accountCheck = '" + ov.getAccountCheck() + "', '"
                    + "mediaCheck = '" + ov.getMediaCheck() + "', '"
                    + "contentCheck = '" + ov.getContentCheck() + "', '"
                    + "jobTypeCheck = '" + ov.getJobCheck() + "', '"
                    + "paymentCheck = '" + ov.getPaymentCheck() + "', '"
                    + "depositCheck = '" +ov.getDepositCheck() + "', '"
                    + "nameFailComment = '" + ov.getNameFailComment() + "', '"
                    + "accountFailComment = '" + ov.getAccountFailComment() + "', '"
                    + "mediaFailComment = '" + ov.getMediaFailComment() + "', '"
                    + "contentFailComment = '" + ov.getContentFailComment() + "', '"
                    + "jobTypeFailComment = '" + ov.getJobTypeFailComment() + "', '"
                    + "paymentFailComment = '" + ov.getPaymentFailComment() + "', '"
                    + "depositFailComment = '" + ov.getDepositFailComment() + "', '"
                    + "correctiveActionComment = '" + ov.getCorrectiveActionComment()
                    + "';";
            System.out.println(query);
            mysql.stmt.executeUpdate(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            int key = -1;
            rs = mysql.stmt.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
            if (key > 0) {
                thisOV = OrderVerify.getOVby("VERID", key);
            }
            else{
                thisOV = OrderVerify.getOVby("VERID", ov.getVerID());
            }
        }   
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "MySQL Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            return thisOV;
        }
    }
    public int getVerID(){
        return VERID;
    }
    public void setVerID(int verID){
        VERID = verID;
    }
    public Order getOrder(){
        return order;
    }
    public void setOrder(Order ord){
        order = ord;
    }
    public Employee getVerifiedBy(){
        return verifiedBy;
    }
    public void setVerifiedBy(Employee verBy){
        verifiedBy = verBy;
    }
    public Boolean getNameCheck(){
        return nameCheck;
    }
    public void setNameCheck(Boolean nameChk){
        nameCheck = nameChk;
    }
    public Boolean getAccountCheck(){
        return accountCheck;
    }
    public void setAccountCheck(Boolean acctChk){
        accountCheck = acctChk;
    }
    public Boolean getMediaCheck(){
        return mediaCheck;
    }
    public void setMediaCheck(Boolean medChk){
        mediaCheck = medChk;
    }
    public Boolean getContentCheck(){
        return contentCheck;
    }
    public void setContentCheck(Boolean contChk){
        contentCheck = contChk;
    }
    public Boolean getJobCheck(){
        return jobTypeCheck;
    }
    public void setJobCheck(Boolean jobChk){
        jobTypeCheck = jobChk;
    }
    public Boolean getPaymentCheck(){
        return paymentCheck;
    }
    public void setPaymentCheck(Boolean payChk){
        paymentCheck = payChk;
    }
    public Boolean getDepositCheck(){
        return depositCheck;
    }
    public void setDepositCheck(Boolean depChk){
        depositCheck = depChk;
    }
    public String getNameFailComment(){
        return nameFailComment;
    }
    public void setNameFailComment(String nameFail){
        nameFailComment = nameFail;
    }
    public String getAccountFailComment(){
        return accountFailComment;
    }
    public void setAccountFailComment(String acctFail){
        accountFailComment = acctFail;
    }
    public String getMediaFailComment(){
        return mediaFailComment;
    }
    public void setMediaFailComment(String medFail){
        mediaFailComment = medFail;
    }
    public String getContentFailComment(){
        return contentFailComment;
    }
    public void setContentFailComment(String contFail){
        contentFailComment = contFail;
    }
    public String getJobTypeFailComment(){
        return jobTypeFailComment;
    }
    public void setJobTypeFailComment(String jobFail){
        jobTypeFailComment = jobFail;
    }
    public String getPaymentFailComment(){
        return paymentFailComment;
    }
    public void setPaymentFailComment(String payFail){
        paymentFailComment = payFail;
    }
    public String getDepositFailComment(){
        return depositFailComment;
    }
    public void setDepositFailComment(String depFail){
        depositFailComment = depFail;
    }
    public String getCorrectiveActionComment(){
        return correctiveActionComment;
    }
    public void setCorrectiveActionComment(String corrActComm){
        correctiveActionComment = corrActComm;
    }
}

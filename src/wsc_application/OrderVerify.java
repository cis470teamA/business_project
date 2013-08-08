/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsc_application;

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
}

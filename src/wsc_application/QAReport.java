
package wsc_application;

public class QAReport {
    
    private Order order;
    private long QAID;
    private Employee inspector;
    private boolean correctContent;
    private boolean correctMedia;
    private boolean mediaFinish;
    private boolean workmanship;
    private String contentFailComment;
    private String mediaFailComment;
    private String mediaFinishFailComment;
    private String workmanshipFailComment;
    private String correctiveActionComment;
    
    public QAReport(){
        
    }
    
    public QAReport(long qaID, Order ord, Employee inspect, Boolean corrCont,
        Boolean corrMed, Boolean medFin, Boolean work, String contFail, String medFail,
        String medFinFail, String workFail, String corrAct){
        setQAID(qaID); 
        setOrder(ord); 
        setInspector(inspect); 
        setCorrectContent(corrCont);
        setCorrectMedia(corrMed); 
        setMediaFinish(medFin); 
        setWorkmanship(work);
        setContentFailComment(contFail);
        setMediaFailComment(medFail);
        setMediaFinishFailComment(medFinFail);
        setWorkmanshipFailComment(workFail); 
        setCorrectiveActionComment(corrAct);
        }
    
    public void setQAID(long qaID){
       this.QAID = qaID;
    } 
    public void setOrder(Order ord){
       this.order = ord;
    } 
    public void setInspector(Employee inspect){
       this.inspector = inspect;
    }
    public void setCorrectContent(Boolean corrCont){
       this.correctContent = corrCont;
    }
    public void setCorrectMedia(Boolean corrMed){
       this.correctMedia = corrMed;
    }
    public void setMediaFinish(Boolean medFin){
       this. mediaFinish = medFin;
    }
    public void setWorkmanship(Boolean work){
        this.workmanship = work;
    }
    public void setContentFailComment(String contFail){
        this.contentFailComment = contFail;
    } 
    public void setMediaFailComment(String medFail){
        this.mediaFailComment = medFail;
    }
    public void setMediaFinishFailComment(String medFinFail){
        this.mediaFinishFailComment = medFinFail;
    }
    public void setWorkmanshipFailComment(String workFail){
        this.workmanshipFailComment = workFail;
    }
    public void setCorrectiveActionComment(String corrAct){
        this.correctiveActionComment = corrAct;
    }
    public long getQAID(){
        return QAID;
    }
    public Employee getInspector(){
        return inspector;
    }
    public Boolean getCorrectContent(){
        return correctContent;
    }
    public Boolean getCorrectMedia(){
        return correctMedia;
    }
    public Boolean getMediaFinish(){
        return mediaFinish;
    }
    public Boolean getWorkmanship(){
        return workmanship;
    }
    public String getContentFailComment(){
        return contentFailComment;
    }
    public String getMediaFailComment(){
        return mediaFailComment;
    }
    public String getMediaFinishFailComment(){
        return mediaFinishFailComment;
    }
    public String getWorkmanshipFailComment(){
        return workmanshipFailComment;
    }
    public String getCorrectiveActionComment(){
        return correctiveActionComment;
    }
}    

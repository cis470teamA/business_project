/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsc_application;

/**
 *
 * @author Bradley
 */
public class QAReport {
    private Order order;
    private long inspectionID;
    private Employee inspector;
    private boolean correctContent;
    private boolean correctMedia;
    private boolean mediaFinish;
    private boolean workmanship;
    private String contentIncorrectComment;
    private String mediaIncorrectComment;
    private String mediaFinishFailComment;
    private String workmanshipFailComment;
    private String correctiveActionComment;
}

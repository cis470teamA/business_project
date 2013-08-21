package wsc_application;

import javax.swing.JOptionPane;

public class Messaging {
    public static void sendMessage(String recipient) {
        JOptionPane.showMessageDialog(null, 
                "Sending message to " + recipient + ".",
                "Sending Message", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void sendMessage(String recipient, String message) {
        JOptionPane.showMessageDialog(null, 
                "To: " + recipient + ".\n" + 
                "Body: " + message,
                "Sending Message", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(message);
    }
    public static void sendMessage(String recipient, String message, String subject) {
        JOptionPane.showMessageDialog(null, 
                "To: " + recipient + ".\n" +
                "Subject: " + subject +
                "Body: " + message,
                "Sending Message", JOptionPane.INFORMATION_MESSAGE);
    }
}

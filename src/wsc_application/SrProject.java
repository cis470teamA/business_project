
package wsc_application;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SrProject {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createAndShowGUI();
        MysqlConn mysql = new MysqlConn();
//        Paul's testing functions
//        Customer customer = Customer.searchBy("CUSTID", "1");
//        customer.setFName("Billy");
//        customer = Customer.updateBy(customer);
//        customer.setLName("Smith");
//        customer.setStreet1("111 Street St.");
//        Customer.createCust(customer);
//        if (Customer.isCustomer(1)) {
//            JOptionPane.showMessageDialog(null, "Is customer", null, JOptionPane.INFORMATION_MESSAGE);
//        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new WilliamsSpecialtyGUI());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
     }
}
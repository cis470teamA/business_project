
package wsc_application;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SrProject {
    protected static WilliamsSpecialtyGUI win = new WilliamsSpecialtyGUI();
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createAndShowGUI();
        MysqlConn mysql = new MysqlConn();
//        Paul's testing statements
//        Customer customer = Customer.searchBy("CUSTID", "1");
//        customer.setFName("Billy");
//        customer = Customer.updateBy(customer);
//        customer.setLName("Smith");
//        customer.setStreet1("111 Street St.");
//        Customer.createCust(customer);
//        if (Customer.isCustomer(1)) {
//            JOptionPane.showMessageDialog(null, "Is customer", null, JOptionPane.INFORMATION_MESSAGE);
//        }
//        ArrayList<Order> testlist = Order.getOrders(1);
//        for (Order o : testlist) {
//            System.out.println("OrderId:" + o.getORDID());
//        }
//        Order order = Order.getOrder(1);
//        System.out.println("Customer " + order.getCustomer().getCustFName());
//        order.setContent("We all love kittens, yes we do, kittens are fun and stuff.");
//        order.setMediaStatus("Ordered");
//        order.setMediaStatus("T-Shirt");
//        order = Order.createOrder(order);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(win);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
     }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsc_application;

import javax.swing.JFrame;

/**
 *
 * @author Bradley
 */
public class SrProject {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createAndShowGUI();
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
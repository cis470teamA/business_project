package srproject;

public class SrProject {
    public static final String appTitle = "Williams Specialty Application";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WilliamsSpecialtyGUI().setVisible(true);
            }
        });
    }
}

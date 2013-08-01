package wsc_application;

import java.util.Date;

public class Person {
    protected long id;
    protected String firstName;
    protected String lastName;
    protected String street1;
    protected String street2;
    protected String state;
    protected int zip;
    protected long phone;
    protected String email;
    protected boolean status;  // Active?
    protected Date date;
    
    // Clearly a default constructor
    public Person() {
        // TODO
    }
    
    // Overloaded constructor
    public Person(String firstName, String lastName, String street1, String street2,
            String state, int zip, long phone, String email, boolean status, Date date) {
        // TODO
    }
}

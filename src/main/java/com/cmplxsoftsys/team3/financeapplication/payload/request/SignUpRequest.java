package com.cmplxsoftsys.team3.financeapplication.payload.request;

/**
 * This class marshalls the request for a new customer account.
 */
public class SignUp {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;

    /**
     * Returns the username from the request.
     * @return a String containing the username in the request
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the password from the request.
     * @return a String containing the username in the request
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the customer email address.
     * @return customer's email address.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the customer's first name.
     * @return customer first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the customer's last name.
     * @return customer last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the customer's full address where they receive business communications.
     * @return customer full address as a single string.
     */
    public String getAddress() {
        return this.address;
    }

}

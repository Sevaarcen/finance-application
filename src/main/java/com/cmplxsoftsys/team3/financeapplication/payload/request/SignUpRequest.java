package com.cmplxsoftsys.team3.financeapplication.payload.request;

import com.cmplxsoftsys.team3.financeapplication.model.Role;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.Set;

/**
 * This class marshalls the request for a new customer account.
 */
public class SignUpRequest {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;

    @DBRef
    private Set<String> roles = new HashSet<>();

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}

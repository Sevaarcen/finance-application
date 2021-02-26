package com.cmplxsoftsys.team3.financeapplication.payload.request;

/**
 * This class is used to marshal Login requests for use in authenticating users.
 */
public class LoginRequest {
    private String username;

    private String password;

    /**
     * Returns the username from the request.
     *
     * @return a String containing the username in the request
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the password from the request.
     *
     * @return a String containing the username in the request
     */
    public String getPassword() {
        return this.password;
    }
}

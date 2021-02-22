package com.cmplxsoftsys.team3.financeapplication.controller;

import org.springframework.stereotype.Controller;
/**
 * This class is used as an authorization mechanism to verify current and future users.
 */

@Controller
public class AuthController {
    private final String username;
    private String password;

    /**
     * Default constructor
     */
    public AuthController() {
        this("hi", "hello");
    }

    public AuthController(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Checks to verify username and password as a comparison to what is already set
     */
    public static boolean isVerified(String username,String password){
        if (username.equals("hi") && password.equals("hello")){
            return true;
        }
        else{
            return false;
        }
    }

}

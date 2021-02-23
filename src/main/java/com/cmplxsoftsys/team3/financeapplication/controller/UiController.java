package com.cmplxsoftsys.team3.financeapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class is used to handle all of the interfaces that we will be using and implementing within the application
 */

@Controller
public class UiController {

    /**
     * This method renders and sends the HTML of the Homepage view
     */

    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }

    /**
     * This method renders and sends the HTML of the Login Page view
     */

    @GetMapping("/login")
    public String getLoginPage() {
        return "index";
    }

    /**
     * This method renders and sends the HTML of the Create Account Page view
     */

    @GetMapping("/account")
    public String getCreateAccountPage() {
        return "index";
    }
}

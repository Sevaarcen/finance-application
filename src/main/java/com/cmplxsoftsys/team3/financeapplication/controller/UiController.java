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
     * This method renders and sends the HTML of the Create Account Page view
     */

    @GetMapping("/account")
    public String getCreateAccountPage() {
        return "account";
    }

    /**
     * This method renders and sends the HTML of the Dashboard Page View
     */
    @GetMapping("/dashboard")
    public String getDashboard() { return "dashboard";}

    /**
     * This method renders and sends the HTML of the Sign In View
     */
    @GetMapping("/signin")
    public String getSignIn() { return "signin";}

    /**
     * This method renders and sends the HTML of the Sign Up View
     */
    @GetMapping("/signup")
    public String getSignUp() { return "signup";}

    /**
     * This method renders and sends the HTML New Loan Application View
     */
    @GetMapping("/newLoan")
    public String getNewLoan() { return "newLoan";}

    /**
     * This method renders and sends the HTML Banking View
     */
    @GetMapping("/banking")
    public String getBanking() { return "banking";}
}

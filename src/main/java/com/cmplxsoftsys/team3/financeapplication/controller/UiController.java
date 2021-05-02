package com.cmplxsoftsys.team3.financeapplication.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * This class is used to handle all of the interfaces that we will be using and implementing within the application
 */

@Controller
public class UiController implements ErrorController {

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
     * This method clears localstorage and Cookies and logs the user out
     */
    @GetMapping("/logout")
    public String logout() { return "logout";}

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

    /**
     * This method renders and sends the HTML Employee Loan Application View
     */
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/loanAppReview")
    public String getLoanAppReview() { return "loanAppReview";}

    /**
     * This method renders and sends the HTML User Transaction History View
     */
    @GetMapping("/viewTransactions")
    public String getViewTransactions() { return "viewTransactions";}

    /**
     * This method renders and sends the HTML New Loan Payment View
     */
    @GetMapping("/newPayment")
    public String getNewPayment() { return "newPayment";}

    /**
     * This method renders and sends the HTML Custom Error View
     */
    @GetMapping("/error")
    public String handleError() { return "error";}

    @Override
    public String getErrorPath() {
        return null;
    }
}

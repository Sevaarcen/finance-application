package com.cmplxsoftsys.team3.financeapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    /**
     * Calling each of the interfaces
     */

    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }

    @GetMapping("/")
    public String getLoginPage() {
        return "index";
    }

    @GetMapping("/")
    public String getCreateAccountPage() {
        return "index";
    }
}

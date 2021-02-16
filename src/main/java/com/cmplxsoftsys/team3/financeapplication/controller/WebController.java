package com.cmplxsoftsys.team3.financeapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class WebController {

    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }
}

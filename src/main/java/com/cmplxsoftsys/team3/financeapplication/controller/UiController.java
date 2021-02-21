package com.cmplxsoftsys.team3.financeapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }
}

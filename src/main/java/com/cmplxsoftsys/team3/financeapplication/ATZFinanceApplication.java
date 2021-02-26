package com.cmplxsoftsys.team3.financeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the launcher class with the main method.
 */
@SpringBootApplication
public class ATZFinanceApplication {

    /**
     * This method starts the Spring Application and the associated web services.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ATZFinanceApplication.class, args);
    }

}

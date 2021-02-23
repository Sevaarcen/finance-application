package com.cmplxsoftsys.team3.financeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is the launcher class with the main method.
 */
@SpringBootApplication
public class FinanceapplicationApplication {

    /**
     * This method starts the Spring Application and the associated web services.
     * @param args command line arguments
     */
    public static void main(String[] args) {
            SpringApplication.run(FinanceapplicationApplication.class, args);
    }

}

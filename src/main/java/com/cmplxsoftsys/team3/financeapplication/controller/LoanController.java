package com.cmplxsoftsys.team3.financeapplication.controller;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.service.LoanService;
import org.springframework.stereotype.Controller;

/**
 * This class is used to connect the loan model class to its respective interface.
 */

@Controller
public class LoanController {
    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    /**
    private final Loan model;
    private final Loan view;

    public LoanController(Loan model, Loan view){
        this.model = model;
        this.view = view;
    }


    //get loan view

    /**
     * Connects data from model class into the view
     */
    /**
    public void setLoanAnnualInterestRate(double annualInterestRate){
        model.setAnnualInterestRate(annualInterestRate);
    }

    public double getLoanAnnualInterestRate(){
        return model.getAnnualInterestRate();
    }


    public void setLoanNumberOfYears(int numberOfYears){
        model.setNumberOfYears(numberOfYears);
    }

    public int getLoanNumberOfYears(){
        return model.getNumberOfYears();
    }


    public void setLoanLoanAmount(double loanAmount){
        model.setLoanAmount(loanAmount);
    }

    public double getLoanLoanAmount(){
        return model.getLoanAmount();
    }
    */
}

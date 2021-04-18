package com.cmplxsoftsys.team3.financeapplication.modeltests;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanTests {

    private double annualInterestRate = 1.99;
    private int numberOfYears = 5;
    private double loanAmount = 12345.67;
    private String loanType = "testtype";
    private int tenure = 3;
    private String userID = "238ae9965t3";

    
    @Test
    public void loanCanBeInstantiated() {
        Loan testLoan = new Loan(annualInterestRate, numberOfYears, loanAmount, loanType, tenure, userID);
        assertThat(testLoan).isNotNull();
    }


    @Test
    public void loanCorrectlyReturnsFieldValues() {
        Loan testLoan = new Loan(annualInterestRate, numberOfYears, loanAmount, loanType, tenure, userID);

        assertThat(testLoan.getAnnualInterestRate()).isEqualTo(annualInterestRate);
        assertThat(testLoan.getNumberOfYears()).isEqualTo(numberOfYears);
        assertThat(testLoan.getLoanAmount()).isEqualTo(loanAmount);
        assertThat(testLoan.getLoanType()).isEqualTo(loanType);
    }


    @Test
    public void loanAttributesCanSuccessfullyBeChanged() {
        Loan testLoan = new Loan(annualInterestRate, numberOfYears, loanAmount, loanType, tenure, userID);

        testLoan.setAnnualInterestRate(99999);
        assertThat(testLoan.getAnnualInterestRate()).isNotEqualTo(annualInterestRate);
        testLoan.setNumberOfYears(99999);
        assertThat(testLoan.getNumberOfYears()).isNotEqualTo(numberOfYears);
        testLoan.setLoanAmount(99999);
        assertThat(testLoan.getLoanAmount()).isNotEqualTo(loanAmount);
        testLoan.setLoanType("something different");
        assertThat(testLoan.getLoanType()).isNotEqualTo(loanType);
    }
}

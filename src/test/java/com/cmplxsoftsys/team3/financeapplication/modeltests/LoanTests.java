package com.cmplxsoftsys.team3.financeapplication.modeltests;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.model.Loan.STATUS;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanTests {

    private double annualInterestRate = 1.99;
    private int tenure = 60;
    private double loanAmount = 12345.67;
    private String loanType = "testtype";
    private String userID = "238ae9965t3";
    private STATUS testStatus = STATUS.APPROVED;

    
    @Test
    public void loanCanBeInstantiated() {
        Loan testLoan1 = new Loan(tenure, loanAmount, loanType, userID);
        assertThat(testLoan1).isNotNull();
        Loan testLoan2 = new Loan(annualInterestRate, tenure, loanAmount, loanType, userID, testStatus);
        assertThat(testLoan2).isNotNull();
    }


    @Test
    public void loanCorrectlyReturnsFieldValues() {
        Loan testLoan1 = new Loan(tenure, loanAmount, loanType, userID);
        assertThat(testLoan1.getAnnualInterestRate()).isEqualTo(0);
        assertThat(testLoan1.getTenure()).isEqualTo(tenure);
        assertThat(testLoan1.getLoanAmount()).isEqualTo(loanAmount);
        assertThat(testLoan1.getLoanType()).isEqualTo(loanType);
        assertThat(testLoan1.getUserId()).isEqualTo(userID);
        assertThat(testLoan1.getApplicationStatus()).isEqualTo(STATUS.PENDING);

        Loan testLoan2 = new Loan(annualInterestRate, tenure, loanAmount, loanType, userID, testStatus);
        assertThat(testLoan2.getAnnualInterestRate()).isEqualTo(annualInterestRate);
        assertThat(testLoan2.getTenure()).isEqualTo(tenure);
        assertThat(testLoan2.getLoanAmount()).isEqualTo(loanAmount);
        assertThat(testLoan2.getLoanType()).isEqualTo(loanType);
        assertThat(testLoan2.getUserId()).isEqualTo(userID);
        assertThat(testLoan2.getApplicationStatus()).isEqualTo(testStatus);
    }


    @Test
    public void loanAttributesCanSuccessfullyBeChanged() {
        Loan testLoan = new Loan(tenure, loanAmount, loanType, userID);

        testLoan.setAnnualInterestRate(99999);
        assertThat(testLoan.getAnnualInterestRate()).isNotEqualTo(annualInterestRate);
        testLoan.setNumberOfYears(99999);
        assertThat(testLoan.getTenure()).isNotEqualTo(tenure);
        testLoan.setLoanAmount(99999);
        assertThat(testLoan.getLoanAmount()).isNotEqualTo(loanAmount);
        testLoan.setLoanType("something different");
        assertThat(testLoan.getLoanType()).isNotEqualTo(loanType);
        testLoan.setApplicationStatus(STATUS.REJECTED);
        assertThat(testLoan.getApplicationStatus()).isNotEqualTo(testStatus);
    }
}

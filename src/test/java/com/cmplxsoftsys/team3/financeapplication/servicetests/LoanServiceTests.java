package com.cmplxsoftsys.team3.financeapplication.servicetests;

import static org.assertj.core.api.Assertions.assertThat;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LoanServiceTests {

    @Autowired
    LoanServiceImpl loanService;

    @MockBean
    LoanRepository repository;


    @Test
    public void contextLoads() throws Exception {
        assertThat(repository).isNotNull();
    }


    @Test
    public void validLoanApplicationIsSuccessfullyProcessedIfSubmitted() throws Exception {
        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");

        LoanApplicationRequest loanAppRequest = Mockito.mock(LoanApplicationRequest.class);
        Mockito.when(loanAppRequest.getUserId()).thenReturn(testLoan.getUserId());
        Mockito.when(loanAppRequest.getType()).thenReturn(testLoan.getLoanType());
        Mockito.when(loanAppRequest.getTenure()).thenReturn(testLoan.getTenure());
        Mockito.when(loanAppRequest.getAmount()).thenReturn(testLoan.getLoanAmount());

        loanService.submitLoanApplication(loanAppRequest);
        // verify that save was called once (e.g. it would have been a write)
        Mockito.verify(repository).save(Mockito.any());
    }


    //TODO replace test stubs once the classes are implemented

    @Test
    public void validLoanContentsIsCorrectlyValidated() throws Exception {
        Object results = loanService.verifyLoanContents();
        assertThat(results).isNull();  // for now until stub is written
    }


    @Test
    public void validateUSDConversionIsCalculatedCorrectly() throws Exception {
        Object results = loanService.convertToUSD();
        assertThat(results).isNull();  // for now until stub is written
    }


    @Test
    public void validateLoanApplicationCanBeSubmitted_LoanWouldWriteToDB() throws Exception {
        Object results = loanService.submitLoanApplication();
        assertThat(results).isNull();  // for now until stub is written
    }


    @Test
    public void loanServiceReturnsLoanDetailsForGivenAccount() throws Exception {
        Object results = loanService.getLoansForAccount();
        assertThat(results).isNull();  // for now until stub is written
    }

    
    @Test
    public void userCanCheckLoanApplicationStatusSuccessfully() throws Exception {
        Object results = loanService.getLoanApplicationStatus();
        assertThat(results).isNull();  // for now until stub is written
    }
}

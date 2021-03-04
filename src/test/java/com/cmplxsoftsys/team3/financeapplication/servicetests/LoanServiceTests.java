package com.cmplxsoftsys.team3.financeapplication.servicetests;

import static org.assertj.core.api.Assertions.assertThat;

import com.cmplxsoftsys.team3.financeapplication.model.LoanApplication;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanApplicationRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanApplicationServiceImpl;
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
    LoanApplicationServiceImpl loanApplicationService;

    @Autowired
    LoanServiceImpl loanService;

    @MockBean
    LoanApplicationRepository repository;


    @Test
    public void contextLoads() throws Exception {
        assertThat(repository).isNotNull();
    }


    @Test
    public void validLoanApplicationIsSuccessfullyProcessedIfSubmitted() throws Exception {

        LoanApplication fakeApplication = new LoanApplication("testtype", 12345.67, "testid");

        LoanApplicationRequest loanAppRequest = Mockito.mock(LoanApplicationRequest.class);
        Mockito.when(loanAppRequest.getUserId()).thenReturn(fakeApplication.getUserId());
        Mockito.when(loanAppRequest.getType()).thenReturn(fakeApplication.getType());
        Mockito.when(loanAppRequest.getLoanAmount()).thenReturn(fakeApplication.getAmount());

        loanApplicationService.submitLoanApplication(loanAppRequest);
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

package com.cmplxsoftsys.team3.financeapplication.servicetests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.model.Loan.STATUS;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanDecisionRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LoanServiceTests {

    @Autowired
    LoanServiceImpl loanService;

    @MockBean
    LoanRepository repository;


    @Test
    public void contextLoads() throws Exception {
        assertThat(loanService).isNotNull();
        assertThat(repository).isNotNull();
    }


    @Test
    public void loanServiceLogic_validLoanApplicationIsSuccessfullySubmitted() throws Exception {
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

    @Test
    public void loanServiceLogic_CanSuccessfullyAcceptLoan() throws Exception {
        String testLoanId = "test123456";
        Loan testLoan = new Loan(5, 12345.67, "testtype", testLoanId);
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        LoanDecisionRequest testRequest = Mockito.mock(LoanDecisionRequest.class);
        double testInterestRate = 0.357;
        Mockito.when(testRequest.getAnnualInterestRate()).thenReturn(testInterestRate);

        loanService.approveLoan(testRequest, testLoanId);

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.APPROVED);
        assertThat(testLoan.getAnnualInterestRate()).isEqualTo(testInterestRate);

        // ensure DB would have written changes
        Mockito.verify(repository).save(Mockito.any());  
    }

    @Test
    public void loanServiceLogic_CanSuccessfullyRejectLoan() throws Exception {
        String testLoanId = "test123456";
        Loan testLoan = new Loan(5, 12345.67, "testtype", testLoanId);
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        loanService.rejectLoan(testLoanId);

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.REJECTED);

        // ensure DB would have written changes
        Mockito.verify(repository).save(Mockito.any());  
    }
}

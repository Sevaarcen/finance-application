package com.cmplxsoftsys.team3.financeapplication.servicetests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.model.Loan.STATUS;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanDecisionRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LoanServiceTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    LoanServiceImpl loanService;

    @MockBean
    LoanRepository repository;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(SecurityMockMvcConfigurers.springSecurity())
          .build();
    }


    @Test
    public void contextLoads() throws Exception {
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
        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
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
        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        loanService.rejectLoan(testLoanId);

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.REJECTED);

        // ensure DB would have written changes
        Mockito.verify(repository).save(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "MODERATOR")
    @Test
    public void moderatorUserHasPermissionsAndCanApproveLoan() throws Exception {
        String testLoanId = "test123456";
        String endpoint = String.format("/api/loan/approve/%s", testLoanId);
        
        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        String payload = "{\"annualInterestRate\": 0.357}";

        System.out.println(repository.findById(testLoanId));

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk());

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.APPROVED);

        // ensure DB would have written changes
        Mockito.verify(repository).save(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "MODERATOR")
    @Test
    public void moderatorUserHasPermissionsAndCanRejectLoan() throws Exception {
        String testLoanId = "test123456";
        String endpoint = String.format("/api/loan/reject/%s", testLoanId);

        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.REJECTED);

        // ensure DB would have written changes
        Mockito.verify(repository).save(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "ADMIN")
    @Test
    public void adminUserHasPermissionsAndCanApproveLoan() throws Exception {
        String testLoanId = "test123456";
        String endpoint = String.format("/api/loan/approve/%s", testLoanId);
        
        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        String payload = "{\"annualInterestRate\": 0.357}";

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk());

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.APPROVED);

        // ensure DB would have written changes
        Mockito.verify(repository).save(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "ADMIN")
    @Test
    public void adminUserHasPermissionsAndCanRejectLoan() throws Exception {
        String testLoanId = "test123456";
        String endpoint = String.format("/api/loan/reject/%s", testLoanId);
        
        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.REJECTED);

        // ensure DB would have written changes
        Mockito.verify(repository).save(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "USER")
    @Test
    public void normalUserImproperPermissionsAndCannotApproveLoan() throws Exception {
        String testLoanId = "test123456";
        String endpoint = String.format("/api/loan/approve/%s", testLoanId);
        
        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        String payload = "{\"annualInterestRate\": 0.357}";

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isForbidden());

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.PENDING);

        // ensure DB would NOT have written changes
        Mockito.verify(repository, Mockito.times(0)).save(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "USER")
    @Test
    public void normalUserImproperPermissionsAndCannotRejectLoan() throws Exception {
        String testLoanId = "test123456";
        String endpoint = String.format("/api/loan/reject/%s", testLoanId);

        Loan testLoan = new Loan(5, 12345.67, "testtype", "testid");
        ReflectionTestUtils.setField(testLoan, "id", testLoanId);

        Mockito.when(repository.findById(testLoanId)).thenReturn(Optional.of(testLoan));

        String payload = "{\"annualInterestRate\": 0.357}";

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isForbidden());

        // ensure fields have updated appropriately
        assertThat(testLoan.getApplicationStatus()).isEqualTo(STATUS.PENDING);

        // ensure DB would NOT have written changes
        Mockito.verify(repository, Mockito.times(0)).save(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "USER")
    @Test
    public void normalUserImproperPermissionsAndCannotGetPendingLoans() throws Exception {
        String endpoint = "/api/loan/pending/all";

        Mockito.when(repository.findByApplicationStatus(STATUS.PENDING)).thenReturn(Optional.of(new ArrayList<Loan>()));

        this.mvc.perform(
            get(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());

        Mockito.verify(repository, Mockito.times(0)).findByApplicationStatus(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "MODERATOR")
    @Test
    public void moderatorUserHasPermissionsToGetPendingLoans() throws Exception {
        String endpoint = "/api/loan/pending/all";

        Mockito.when(repository.findByApplicationStatus(STATUS.PENDING)).thenReturn(Optional.of(new ArrayList<Loan>()));

        this.mvc.perform(
            get(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        Mockito.verify(repository).findByApplicationStatus(Mockito.any());  
    }

    @WithMockUser(username = "tester", roles = "ADMIN")
    @Test
    public void adminUserHasPermissionsToGetPendingLoans() throws Exception {
        String endpoint = "/api/loan/pending/all";

        Mockito.when(repository.findByApplicationStatus(STATUS.PENDING)).thenReturn(Optional.of(new ArrayList<Loan>()));

        this.mvc.perform(
            get(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        Mockito.verify(repository).findByApplicationStatus(Mockito.any());  
    }
}

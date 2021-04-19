package com.cmplxsoftsys.team3.financeapplication.controllertests;

import com.cmplxsoftsys.team3.financeapplication.controller.LoanController;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LoanUseCaseTests {

    @Autowired
    private LoanController controller;
    
    @Autowired
    private WebApplicationContext context;

    // for mocking and testing
    private MockMvc mvc;

    @MockBean
    private LoanRepository repository;


    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(SecurityMockMvcConfigurers.springSecurity())
          .build();
    }

    
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }


    @Test
    public void unauthenticatedUserSubmitsLoanRequest_ReturnsUnauthorized() throws Exception {
        String endpoint = "/api/loan/request";

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }


    @WithMockUser("moderator")
    @Test
    public void authenticatedUserSubmitsLoanRequest_RequestIsSuccessful() throws Exception {
        String endpoint = "/api/loan/request";

        double loanAmount = 9999.99;
        String userId = "testrequester";
        String loanType = "testReqType";
        
        String payload = String.format("{\"userId\": \"%s\", \"type\": \"%s\", \"loanAmount\": %f}", userId, loanType, loanAmount);
        
        // since the repo is mocked, it won't actually write here
        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk());

        // verify the data would have been written to DB if it wasn't mocked
        Mockito.verify(repository).save(Mockito.any());
    }
}

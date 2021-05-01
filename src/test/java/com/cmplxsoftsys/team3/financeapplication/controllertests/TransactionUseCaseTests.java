package com.cmplxsoftsys.team3.financeapplication.controllertests;

import com.cmplxsoftsys.team3.financeapplication.controller.TransactionController;
import com.cmplxsoftsys.team3.financeapplication.repository.TransactionRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class TransactionUseCaseTests {
    
    @Autowired
    private TransactionController controller;
    
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @MockBean
    private TransactionRepository repository;


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
    public void unauthenticatedUserSubmitsTransactionRequest_ReturnsUnauthorized() throws Exception {
        String endpoint = "/api/transactions/make";

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isUnauthorized());
    }


    @Test
    public void normalUserCannotViewAllTransactions_Unauthorized() throws Exception {
        String endpoint = "/api/transactions/get/all";

        this.mvc.perform(
            get(endpoint)
        ).andExpect(status().isUnauthorized());
    }


    @WithMockUser(username = "tester", roles = "MODERATOR")
    @Test
    public void moderatorUserCanViewAllTransactions_Ok() throws Exception {
        String endpoint = "/api/transactions/get/all";

        this.mvc.perform(
            get(endpoint)
        ).andExpect(status().isOk());
    }


    @WithMockUser(username = "tester", roles = "ADMIN")
    @Test
    public void adminUserCanViewAllTransactions_Ok() throws Exception {
        String endpoint = "/api/transactions/get/all";

        this.mvc.perform(
            get(endpoint)
        ).andExpect(status().isOk());
    }


    @WithMockUser(username = "tester", roles = "USER")
    @Test
    public void authorizedUserCanSendTransactionRequest() throws Exception {
        String endpoint = "/api/transactions/make";

        String payload = "{\"userId\": \"tester\", \"value\": 1234567890}";

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk());

        Mockito.verify(repository).save(Mockito.any());
    }
}

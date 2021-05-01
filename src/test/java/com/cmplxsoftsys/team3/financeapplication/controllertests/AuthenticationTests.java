package com.cmplxsoftsys.team3.financeapplication.controllertests;

import com.cmplxsoftsys.team3.financeapplication.controller.AuthController;
import com.cmplxsoftsys.team3.financeapplication.model.User;
import com.cmplxsoftsys.team3.financeapplication.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;

import java.util.Optional;

import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthenticationTests {

    @Autowired
    private AuthController controller;
    
    @Autowired
    private WebApplicationContext context;

    // for mocking and testing
    private MockMvc mvc;
    
    @MockBean
    UserRepository repository;
    
    @Autowired
    PasswordEncoder encoder;


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
    public void unauthenticatedUserCanSuccessfullySignUpForAccount_AccountSuccessfullyCreated() throws Exception {
        String endpoint = "/api/auth/signup";

        String testUsername = "nonexaccount";
        String testPassword = "this_does_not_matter";
        String testEmail = "nonex@test.example.com";

        // request to be matched with user below
        String payload = String.format("{\"username\": \"%s\", \"password\": \"%s\", \"email\": \"%s\", \"firstName\": \"Tommy\", \"lastName\": \"Tester\", \"address\": \"123 fake street\"}", testUsername, testPassword, testEmail);

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk());

        // also double check the user would have been written to DB
        Mockito.verify(repository).save(Mockito.any());
    }

    
    @Test
    public void successfullyPerformLogin_UsingCreds() throws Exception {
        String endpoint = "/api/auth/signin";

        String testUsername = "testacc";
        String testPassword = "tester";

        String payload = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", testUsername, testPassword);

        // when auth checks if user is valid, return our test user
        User fakeUser = new User(testUsername, encoder.encode(testPassword), "tester@example.com", "Tommy", "Tester", "fake street");
        Optional<User> fakeRepoReturn = Optional.of(fakeUser);
        Mockito.when(repository.findByUsername(testUsername)).thenReturn(fakeRepoReturn);

        // perform sign in request using the controller logic
        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk());
    }


    @WithMockUser("testuser")
    @Test
    public void successfullyPerformLogoutWhenLoggedIn() throws Exception {
        String endpoint = "/logout";  // not actually part of the API, is part of UI but fits better here
        
        this.mvc.perform(
            get(endpoint)
        ).andExpect(status().isOk())
         .andExpect(cookie().doesNotExist("JSESSIONID"));
    }
}

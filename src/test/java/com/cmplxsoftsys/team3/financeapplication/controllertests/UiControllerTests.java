package com.cmplxsoftsys.team3.financeapplication.controllertests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cmplxsoftsys.team3.financeapplication.controller.UiController;

import org.springframework.beans.factory.annotation.Autowired;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UiControllerTests {
    @Autowired
    private UiController controller;
    
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    
    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(SecurityMockMvcConfigurers.springSecurity())
          .build();
    }


    /**
     * This function tests that the controller can be instantiated correctly.
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }


    @Test
    public void indexRequestReturnsOk_NoAuthReq() throws Exception {
        String endpoint = "/";
        mvc.perform(get(endpoint)).andExpect(status().isOk());
    }


    @Test
    public void loginPageReqestReturnsValid_NoAuthReq() throws Exception {
        String endpoint = "/login";
        mvc.perform(get(endpoint)).andExpect(status().isOk());
    }


    @Test
    public void accountDashboardRequestFails_Unauthorized_NoAuth() throws Exception {
        String endpoint = "/account";
        mvc.perform(get(endpoint)).andExpect(status().is4xxClientError());
    }


    @WithMockUser("moderator")
    @Test
    public void accountDashboardRequestSucceeds_Authorized_MockingUser() throws Exception {
        String endpoint = "/account";
        mvc.perform(get(endpoint)).andExpect(status().isOk());
    }
}

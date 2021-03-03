package com.cmplxsoftsys.team3.financeapplication.controllertests;

import com.cmplxsoftsys.team3.financeapplication.controller.AuthController;
import com.cmplxsoftsys.team3.financeapplication.model.User;
import com.cmplxsoftsys.team3.financeapplication.security.service.UserDetailsImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class AuthenticationTests {

    @Autowired
    private AuthController controller;

    @Autowired
    private PasswordEncoder encoder;

    // for making sure we can communicate with how server is configured
    @LocalServerPort
	private int port;
    
    @Autowired
    private WebApplicationContext context;

    // for mocking and testing
    private MockMvc mvc;
    
    @Autowired
    AuthenticationManager authenticationManager;


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
    public void successfullyPerformLogin_UsingCreds() throws Exception {
        String endpoint = "/api/auth/signin";

        String testUsername = "testuser";
        String testPassword = "testpass";
        String encodedPassword = encoder.encode(testPassword);


        String payload = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", testUsername, testPassword);

        Authentication fakeAuth = new UsernamePasswordAuthenticationToken(testUsername, testPassword);
        Authentication spyAuth = Mockito.spy(fakeAuth);
        User mockUser = new User(testUsername, encodedPassword, "test@example.com", "testFirstname", "testLastname", "123 fake street, fake town, NA 12345");
        UserDetailsImpl mockPrincipal = UserDetailsImpl.build(mockUser);


        // Mock user auth so it always thinks the password is the same as testPassword
        AuthenticationManager spyAuthManager = Mockito.spy(authenticationManager);
        Mockito.when(spyAuthManager.authenticate(Mockito.any())).thenReturn(spyAuth);
        Mockito.when(spyAuth.getPrincipal()).thenReturn(mockPrincipal);

        this.mvc.perform(
            post(endpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(status().isOk())
        .andDo(print());
    }

    
    
}

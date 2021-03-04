package com.cmplxsoftsys.team3.financeapplication.securitytests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import com.cmplxsoftsys.team3.financeapplication.model.User;
import com.cmplxsoftsys.team3.financeapplication.repository.UserRepository;
import com.cmplxsoftsys.team3.financeapplication.security.jwt.JwtUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JwtTests {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authManager;

    @MockBean
    UserRepository repository;

    @Autowired
    JwtUtils jwtUtils;

    
    @Test
    public void forValidAuthenticationJWTIsSuccessfullyGenerated() throws Exception {
        String testUsername = "testUser";
        String testPassword = "testPassword";
        
        User fakeUser = new User(testUsername, encoder.encode(testPassword), "tester@example.com", "Tommy", "Tester", "fake street");
        Optional<User> fakeRepoReturn = Optional.of(fakeUser);
        Mockito.when(repository.findByUsername(testUsername)).thenReturn(fakeRepoReturn);

        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(testUsername, testPassword));

        String jwt = jwtUtils.generateJwtToken(auth);
        System.out.println(jwt);
        assertThat(jwt).isNotNull();
    }


    @Test
    public void forBadAuthenticationJWTIsNotGenerated_ThrowsInvalidArgumentException() throws Exception {
        String testUsername = "nonexistant";
        String testPassword = "doesnt matter";

        Authentication badAuth = new UsernamePasswordAuthenticationToken(testUsername, testPassword);
        assertThrows(IllegalArgumentException.class, () -> {jwtUtils.generateJwtToken(badAuth);});
    }


    @Test
    public void usernameCanBeParsedFromCorrectlyFormattedJWT() throws Exception {
        String testUsername = "testUser";
        String testJWT = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0VXNlciIsImlhdCI6MTYxNDg3ODE5OCwiZXhwIjoxNjE0OTY0NTk4fQ.1-z4_u5uJ-KdrutUV0pB_86LjUTZTTxY86BFe7UTVD4ZAQjWCWZLBK-kaNJ5sUqwuBppOD9tXreQ561FtbCICQ";
        String result = jwtUtils.getUserNameFromJwtToken(testJWT);
        assertThat(result).isEqualTo(testUsername);
    }

    
    @Test
    public void correctlyFormattedJWTIsSuccessfullyValidated() throws Exception {
        String testJWT = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0VXNlciIsImlhdCI6MTYxNDg3ODE5OCwiZXhwIjoxNjE0OTY0NTk4fQ.1-z4_u5uJ-KdrutUV0pB_86LjUTZTTxY86BFe7UTVD4ZAQjWCWZLBK-kaNJ5sUqwuBppOD9tXreQ561FtbCICQ";
        boolean valid = jwtUtils.validateJwtToken(testJWT);
        assertThat(valid).isTrue();
    }


    @Test
    public void invalidFormattedJWTCorrectlyFailsValidation() throws Exception {
        String testJWT = "testing.this.isnt.a.jwt";
        boolean valid = jwtUtils.validateJwtToken(testJWT);
        assertThat(valid).isFalse();
    }
}

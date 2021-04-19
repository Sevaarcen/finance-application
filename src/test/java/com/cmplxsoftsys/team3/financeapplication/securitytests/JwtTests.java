package com.cmplxsoftsys.team3.financeapplication.securitytests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import com.cmplxsoftsys.team3.financeapplication.model.User;
import com.cmplxsoftsys.team3.financeapplication.repository.UserRepository;
import com.cmplxsoftsys.team3.financeapplication.security.jwt.JwtUtils;

import org.junit.jupiter.api.BeforeEach;
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

    private String testJwtUsername = "testUser";

    private Authentication validAuth;
    private String validJwt;

    @BeforeEach
    public void setup() {
        String testPassword = "testPassword";
        
        User fakeUser = new User(testJwtUsername, encoder.encode(testPassword), "tester@example.com", "Tommy", "Tester", "fake street");
        Optional<User> fakeRepoReturn = Optional.of(fakeUser);
        Mockito.when(repository.findByUsername(testJwtUsername)).thenReturn(fakeRepoReturn);

        validAuth = authManager.authenticate(new UsernamePasswordAuthenticationToken(testJwtUsername, testPassword));
        validJwt = jwtUtils.generateJwtToken(validAuth);
    }

    
    @Test
    public void forValidAuthenticationJWTIsSuccessfullyGenerated() throws Exception {
        assertThat(validJwt).isNotNull();
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
        String result = jwtUtils.getUserNameFromJwtToken(validJwt);
        assertThat(result).isEqualTo(testJwtUsername);
    }

    
    @Test
    public void correctlyFormattedJWTIsSuccessfullyValidated() throws Exception {
        boolean valid = jwtUtils.validateJwtToken(validJwt);
        assertThat(valid).isTrue();
    }


    @Test
    public void invalidFormattedJWTCorrectlyFailsValidation() throws Exception {
        String testJWT = "testing.this.isnt.a.jwt";
        boolean valid = jwtUtils.validateJwtToken(testJWT);
        assertThat(valid).isFalse();
    }

    @Test
    public void correctlyFormattedYetInvalidJWTIsCorrectlyIdentifiedAsExpired() throws Exception {
        String expiredJwt = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0VXNlciIsImlhdCI6MTYxNDg3ODE5OCwiZXhwIjoxNjE0OTY0NTk4fQ.1-z4_u5uJ-KdrutUV0pB_86LjUTZTTxY86BFe7UTVD4ZAQjWCWZLBK-kaNJ5sUqwuBppOD9tXreQ561FtbCICQ";
        boolean valid = jwtUtils.validateJwtToken(expiredJwt);
        assertThat(valid).isFalse();
    }
}

package com.cmplxsoftsys.team3.financeapplication.controller;

import com.cmplxsoftsys.team3.financeapplication.model.User;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoginRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.SignUpRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.UserRepository;
import com.cmplxsoftsys.team3.financeapplication.security.service.UserDetailsImpl;
import com.cmplxsoftsys.team3.financeapplication.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

/**
 * This class is used as an authorization mechanism to verify current and future users.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthService authService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }

    @GetMapping("/current/username")
    public ResponseEntity<?> getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
            logger.info("Principal={}",principal.getUsername());
            return new ResponseEntity<>(principal.getUsername() + " " + principal.getId(), HttpStatus.OK);
        } catch (ClassCastException ex) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/current/id")
    public ResponseEntity<?> getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        logger.info("User={}",userRepository.findByUsername(principal.getUsername()));

        Optional<User> user = userRepository.findByUsername(principal.getUsername());
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid user details", HttpStatus.UNAUTHORIZED);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
        return authService.handleValidationException(exception);
    }
}

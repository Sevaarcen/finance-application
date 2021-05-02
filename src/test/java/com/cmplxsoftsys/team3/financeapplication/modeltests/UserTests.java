package com.cmplxsoftsys.team3.financeapplication.modeltests;

import static org.assertj.core.api.Assertions.assertThat;

import com.cmplxsoftsys.team3.financeapplication.model.User;

import org.junit.jupiter.api.Test;

public class UserTests {
    
    private String username = "tester";
    private String password = "fakepass";
    private String email = "fakemail@test.example.com";
    private String firstName = "Tommy";
    private String lastName = "Tester";
    private String address = "123 Fake Street, Gotham, NY 10001";


    @Test
    public void objectCanBeInstantiated() {
        User testInstance = new User(username, password, email, firstName, lastName, address);
        assertThat(testInstance).isNotNull();
    }


    @Test
    public void userObjectCorrectlyReturnsFieldValues() {
        User testInstance = new User(username, password, email, firstName, lastName, address);

        assertThat(testInstance.getUsername()).isEqualTo(username);
        assertThat(testInstance.getPassword()).isEqualTo(password);
        assertThat(testInstance.getEmail()).isEqualTo(email);
        assertThat(testInstance.getFirstName()).isEqualTo(firstName);
        assertThat(testInstance.getLastName()).isEqualTo(lastName);
        assertThat(testInstance.getAddress()).isEqualTo(address);
    }

    
    @Test
    public void userObjectAttributedCanSuccessfullyBeChangedViaSets() {
        User testInstance = new User(username, password, email, firstName, lastName, address);

        testInstance.setUsername("newusername");
        assertThat(testInstance.getUsername()).isNotEqualTo(username);
        testInstance.setPassword("newpassword");
        assertThat(testInstance.getPassword()).isNotEqualTo(password);
        testInstance.setEmail("newemail@example.com");
        assertThat(testInstance.getEmail()).isNotEqualTo(email);
        testInstance.setFirstName("newFirst");
        assertThat(testInstance.getFirstName()).isNotEqualTo(firstName);
        testInstance.setLastName("newLast");
        assertThat(testInstance.getLastName()).isNotEqualTo(lastName);
        testInstance.setAddress("newStreet");
        assertThat(testInstance.getAddress()).isNotEqualTo(address);
    }
}

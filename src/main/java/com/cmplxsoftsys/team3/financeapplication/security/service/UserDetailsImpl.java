package com.cmplxsoftsys.team3.financeapplication.security.service;

import com.cmplxsoftsys.team3.financeapplication.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This is an interface that gets and builds a user from provided user details, including allocated authorities.
 */
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String email;

    private String fName;

    private String lName;

    private String address;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    /**
     * This is the Full Constructor for the User Details implementation within security
     *
     * @param id user id
     * @param username user display name
     * @param email user email
     * @param password user password
     * @param fName user first name
     * @param lName user last name
     * @param address user address
     * @param authorities user privileges
     */
    public UserDetailsImpl(String id, String username, String email, String password, String fName, String lName, String address,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.authorities = authorities;
    }

    /**
     * Builds a UserDetailsImpl object from our custom User object
     *
     * @param user User object to be built
     * @return UserDetailsImpl object based on the existing User object
     */
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                authorities);
    }

    /**
     * Gets a collection of granted authorities of a user
     * @return A collection of authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the user id within the security context associated with their application account
     * @return a User id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the email address correlated with a user's financial account
     * @return a user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user's password of their corresponding application account
     * @return a user's account password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the user's username associated with their application id
     * @return a user's username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the user's first name associated with their application account
     * @return a user's first name
     */
    public String getFName() {
        return fName;
    }

    /**
     * Returns the user's last name associated with their application account
     * @return a user's last name
     */
    public String getLName() {
        return lName;
    }

    /**
     * Returns the user's address associated with their application account
     * @return a user's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Check if the user's account is expired
     * @return a boolean: true if it's not expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Check if the user's account is locked
     * @return a boolean: true if account is not locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Check if the user's credentials are expired
     * @return a boolean: true if the credentials are not expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Check if a user's account is enabled
     * @return a boolean: true if the user is enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Checks to see whether the given user object is equal to an existing user id
     * @param o
     * @return Boolean for whether the current user id matches a given user's id within security implementation
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}

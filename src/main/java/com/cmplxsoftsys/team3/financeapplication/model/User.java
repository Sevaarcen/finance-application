package com.cmplxsoftsys.team3.financeapplication.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
  @Id
  private String id;
  private String username;
  private String email;
  private String password;

  @DBRef
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  //Constructor
  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  //Returns UserID
  public String getId() {
    return id;
  }

  //Sets userID
  public void setId(String id) {
    this.id = id;
  }

  //Returns userName
  public String getUsername() {
    return username;
  }

  //Sets userName
  public void setUsername(String username) {
    this.username = username;
  }

  //Returns user Email
  public String getEmail() {
    return email;
  }

  //Sets user Email
  public void setEmail(String email) {
    this.email = email;
  }

  //Returns user password
  public String getPassword() {
    return password;
  }

  //Sets user password
  public void setPassword(String password) {
    this.password = password;
  }

  //Returns the roles of the user
  public Set<Role> getRoles() {
    return roles;
  }

  //Sets roles for a user
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}

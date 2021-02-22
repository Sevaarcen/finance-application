package com.cmplxsoftsys.team3.financeapplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
/**
 This class determines what permissions a specific user has and whether they are a user, moderator, or admin
 */
public class Role {
  public enum ERole {
    ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN
  }

  @Id
  private String id;
  
  private ERole name;

  
  public Role() {
  }

  /**Constructor*/
  public Role(ERole name) {
    this.name = name;
  }

  /**Returns userID*/
  public String getId() {
    return id;
  }

  /**Sets ID of user to specified ID*/
  public void setId(String id) {
    this.id = id;
  }

  /**Returns userName*/
  public ERole getName() {
    return name;
  }

  /**Sets userName*/
  public void setName(ERole name) {
    this.name = name;
  }
}

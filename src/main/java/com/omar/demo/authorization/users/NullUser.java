package com.omar.demo.authorization.users;

public class NullUser {
  public String getUsername() {
    return "";
  }

  public String getPassword() {
    return "";
  }

  public boolean isAdmin() {
    return false;
  }
}

package com.omar.demo.authorization.users;

public class NullUser {
  public long getId() {
    return 0L;
  }

  public String getPassword() {
    return "";
  }

  public boolean isAdmin() {
    return false;
  }
}

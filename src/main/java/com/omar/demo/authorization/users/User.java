package com.omar.demo.authorization.users;

import com.omar.demo.objects.DataRecord;

class User implements DataRecord  {
  private String password;
  private boolean isAdmin = false;
  long id;


  @Override
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

}

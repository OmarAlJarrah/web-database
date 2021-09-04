package com.omar.demo.authorization.users;

import com.omar.demo.objects.DataRecord;

public class NullUser implements DataRecord {

  @Override
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

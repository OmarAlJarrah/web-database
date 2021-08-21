package com.omar.demo.objects;


public class NullStudio implements DataRecord {
  @Override
  public long getId() {
    return 0L;
  }

  public String getName() {
    return "";
  }

  public String getLocation() {
    return "";
  }


  public long getStartYear() {
    return 0L;
  }
}

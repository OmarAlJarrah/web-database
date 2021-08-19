package com.omar.demo.data;

public class NullSingletonObject {
  private static NullSingletonObject object;

  private NullSingletonObject() {}

  public static NullSingletonObject getObject() {
    if (object == null) object = new NullSingletonObject();
    return object;
  }
}

package com.omar.demo.cache;

public interface Cache {
  Object getObject(long id);

  void update(long id, Object object, double overall);
}

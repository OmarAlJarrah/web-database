package com.omar.demo.data;

import java.util.Set;

public interface Resource {
  Object access(long id);

  void add(long id, String reference);

  Class<?> getOutputClass();

  Set<Long> getKeySet();

}

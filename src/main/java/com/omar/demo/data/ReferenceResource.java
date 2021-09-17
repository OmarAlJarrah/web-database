package com.omar.demo.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ReferenceResource implements Resource {
  private final Map<Long, String> resources = new HashMap<>();
  private final Class<?> objectClass;

  public ReferenceResource(Class<?> objectClass) {
    this.objectClass = objectClass;
  }

  @Override
  public Object access(long id) {
    synchronized (resources) {
      if (resources.get(id) == null) {
        return "";
      } else {
        return resources.get(id);
      }
    }
  }

  @Override
  public void add(long id, String reference) {
    synchronized (resources) {
      resources.putIfAbsent(id, reference);
    }
  }

  @Override
  public Class<?> getOutputClass() {
    return objectClass;
  }

  @Override
  public Set<Long> getKeySet() {
    synchronized (resources) {
      return resources.keySet();
    }
  }
}

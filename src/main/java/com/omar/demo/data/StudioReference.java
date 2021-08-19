package com.omar.demo.data;

import com.omar.demo.objects.Studio;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class StudioReference implements Resource {
  private static final Map<Long, String> resources = new HashMap<>();
  private static final Class<?> outputClass = Studio.class;


  public Class<?> getOutputClass() {
    return outputClass;
  }

  @Override
  public Object access(long id) {
    synchronized (resources) {
      if (resources.get(id) == null) {
        return NullSingletonObject.getObject();
      } else {
        return resources.get(id);
      }
    }
  }

  public void add(long id, String reference) {
    synchronized (resources) {
      resources.put(id, reference);
    }
  }

  public Set<Long> getKeySet() {
    synchronized (resources) {
      return resources.keySet();
    }
  }
}


package com.omar.demo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


public class Cache {
  private final ConcurrentHashMap<Long, Object> data = new ConcurrentHashMap<>();
  private final Random random = new Random();

  public Object getObject(long id) {
    if (data.get(id) != null) {
      return data.get(id);
    } else {
      return NullSingletonObject.getObject();
    }
  }

  public void update(long id, Object object, double overall) {
    double size = (double) data.size();
    if ((size/overall)*100 > 10 && overall > 1e3) {
      List<Object> keys = new ArrayList<>(data.keySet());
      Object randomKey = keys.get(random.nextInt(keys.size()));
      data.remove(randomKey);
    }
    data.putIfAbsent(id, object);
  }
}

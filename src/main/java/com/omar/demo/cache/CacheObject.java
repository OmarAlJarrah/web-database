package com.omar.demo.cache;

import com.omar.demo.data.DAO;
import com.omar.demo.data.NullSingletonObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Component("CacheObject")
@Scope("prototype")
public class CacheObject implements Cache {
  private final ConcurrentHashMap<Long, Object> data = new ConcurrentHashMap<>();
  private final Random random = new Random();

  @Autowired
  DAO dao;

  private CacheObject() {}

  @Override
  public Object getObject(long id) {
    if (data.get(id) != null) {
      return data.get(id);
    } else {
      return NullSingletonObject.getInstance();
    }
  }

  @Override
  public void update(long id, @NotNull Object dataRecord, double overall) {
    clearSpace(overall);
    if (!(dataRecord instanceof NullSingletonObject)){
      data.putIfAbsent(id, dataRecord);
    }
  }

  private void clearSpace(double overall) {
    double size = data.size();
    if (((size/overall)*100 > 10) && (overall >= 10)) {
      List<Object> keys = new ArrayList<>(data.keySet());
      Long randomKey = (Long) keys.get(random.nextInt(keys.size()));
      data.remove(randomKey);
    }
  }

  public static CacheObject getNewInstance() {
    return new CacheObject();
  }
}

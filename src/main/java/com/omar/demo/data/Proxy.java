package com.omar.demo.data;

import com.omar.demo.cache.Cache;

public interface Proxy extends Resource {
  Cache getCache();

  double getOverallRecordsCount();

  Class<?> getObjectClass();
}

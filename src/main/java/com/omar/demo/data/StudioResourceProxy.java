package com.omar.demo.data;

import com.omar.demo.cache.Cache;
import com.omar.demo.cache.CacheObject;
import com.omar.demo.objects.Studio;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class StudioResourceProxy implements Resource {
  private static final Resource resource = new ResourceObject(Studio.class);
  private static final Cache cacheObject = CacheObject.getNewInstance();

  @Override
  public Class<?> getOutputClass() {
    return resource.getOutputClass();
  }

  @Override
  public Object access(long id) {
    if (cacheObject.getObject(id) instanceof NullSingletonObject) {
      Object object = resource.access(id);
      cacheObject.update(id, object, resource.getKeySet().size());
      return object;
    } else {
      return cacheObject.getObject(id);
    }
  }

  @Override
  public void add(long id, String reference) {
    resource.add(id, reference);
  }

  @Override
  public Set<Long> getKeySet() {
    return resource.getKeySet();
  }
}


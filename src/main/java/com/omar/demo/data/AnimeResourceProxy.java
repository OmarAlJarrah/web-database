package com.omar.demo.data;

import com.omar.demo.cache.Cache;
import com.omar.demo.cache.CacheObject;
import com.omar.demo.objects.Anime;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class AnimeResourceProxy implements Proxy {
  private final Resource referenceResource = new ReferenceResource(Anime.class);
  private final Cache cacheObject = CacheObject.getNewInstance();

  @Override
  public Class<?> getOutputClass() {
    return referenceResource.getOutputClass();
  }

  @Override
  public Object access(long id) {
    return referenceResource.access(id);
  }

  @Override
  public void add(long id, String reference) {
    referenceResource.add(id, reference);
  }

  @Override
  public Set<Long> getKeySet() {
    return referenceResource.getKeySet();
  }

  @Override
  public Cache getCache() {
    return cacheObject;
  }
}

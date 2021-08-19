package com.omar.demo.service;

import com.omar.demo.data.NullSingletonObject;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import com.omar.demo.objects.NullAnime;
import com.omar.demo.objects.NullStudio;
import org.springframework.stereotype.Service;

@Service
public class ValidateService {
  public boolean validateCreate(DataRecord dataRecord, Resource resource) {
    return (resource.access(dataRecord.getId()) instanceof NullSingletonObject);
  }

  public boolean validateId(long id, Resource resource) {
    return !(resource.access(id) instanceof NullSingletonObject);
  }
}

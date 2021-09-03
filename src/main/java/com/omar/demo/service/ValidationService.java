package com.omar.demo.service;

import com.omar.demo.data.NullSingletonObject;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
  public synchronized boolean validateCreate(DataRecord dataRecord, Resource resource) {
    return (resource.access(dataRecord.getId()) instanceof NullSingletonObject);
  }

  public synchronized boolean validateId(long id, Resource resource) {
    return !(resource.access(id) instanceof NullSingletonObject);
  }

  public synchronized boolean validatePassword(String password) {
    return password.length() >= 6;
  }
}

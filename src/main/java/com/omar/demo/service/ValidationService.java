package com.omar.demo.service;

import com.omar.demo.data.NullSingletonObject;
import com.omar.demo.data.Proxy;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
  public boolean validateCreate(DataRecord dataRecord, Proxy proxy) {
    return (proxy.access(dataRecord.getId()).equals(""));
  }

  public boolean validateDataRecordId(long id, Resource resource) {
    return (!resource.access(id).equals(""));
  }

  public boolean validatePassword(String password) {
    return password.length() >= 6;
  }
}

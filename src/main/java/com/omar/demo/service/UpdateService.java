package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
  public void delete(DataRecord dataRecord, Resource resource) {
    new DAO().update(resource, dataRecord);
  }
}

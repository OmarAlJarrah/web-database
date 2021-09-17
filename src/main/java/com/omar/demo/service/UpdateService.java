package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class UpdateService {
  @Autowired
  DAO dao;

  public void update(DataRecord dataRecord, Resource resource) {
    dao.update(resource, dataRecord);
  }
}

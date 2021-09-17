package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateService {
  @Autowired
  DAO dao;

  public void create(DataRecord dataRecord, Resource resource) {
    dao.create(resource, dataRecord);
  }

}

package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import org.springframework.stereotype.Service;

@Service
public class CreateService {


  public synchronized void create(DataRecord dataRecord, Resource resource) {
    DAO.getDao().create(resource, dataRecord);
  }

}

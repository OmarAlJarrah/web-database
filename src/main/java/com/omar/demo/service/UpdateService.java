package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import com.omar.demo.objects.DataRecord;
import org.springframework.stereotype.Service;

@Service
public final class UpdateService {
  public void update(DataRecord dataRecord, Resource resource) {
    DAO.getInstance().update(resource, dataRecord);
  }
}

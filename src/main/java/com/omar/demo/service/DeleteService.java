package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
  public synchronized void delete(long id, Resource resource) {
    DAO.getDao().delete(id, resource);
  }
}

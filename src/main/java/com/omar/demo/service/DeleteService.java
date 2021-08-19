package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
  public void delete(long id, Resource resource) {
    new DAO().delete(id, resource);
  }
}

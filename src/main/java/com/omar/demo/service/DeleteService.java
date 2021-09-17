package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
  @Autowired
  DAO dao;
  public void delete(long id, Resource resource) {
    dao.delete(id, resource);
  }
}

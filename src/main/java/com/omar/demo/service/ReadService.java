package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadService {
  public synchronized List<Object> read(long id, Resource resource) {
    return DAO.getDao().read(id, resource);
  }

  public synchronized List<Object> readAll(Resource resource) {
    return new DAO().readAll(resource);
  }
}

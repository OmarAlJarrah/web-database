package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class DeleteService {
  @Autowired
  DAO dao;
  public void delete(long id, Proxy proxy) {
    dao.delete(id, proxy);
  }
}

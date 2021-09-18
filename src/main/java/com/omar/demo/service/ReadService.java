package com.omar.demo.service;

import com.omar.demo.data.DAO;
import com.omar.demo.data.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class ReadService {

  @Autowired
  DAO dao;

  public List<Object> read(long id, Proxy proxy) {
    return dao.read(id, proxy);
  }

  public List<Object> readAll(Proxy proxy) {
    return dao.readAll(proxy);
  }
}

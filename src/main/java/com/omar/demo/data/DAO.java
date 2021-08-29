package com.omar.demo.data;

import com.omar.demo.objects.DataRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DAO {

  private static DAO dao;

  public List<Object> read(long id, Resource resource) {
    List<Object> list = new ArrayList<>();
    synchronized (resource.access(id)){
      Crud readOperation = Read.factory(id);
      Operation operation = Operation.factory(readOperation, resource);
      list.add(operation.doAction());
      return list;
    }
  }

  public List<Object> readAll(Resource resource) {
    List<Object> list = new ArrayList<>();
    synchronized (resource){
      Set<Long> keys = resource.getKeySet();
      for (long id: keys){
        Crud readOperation = Read.factory(id);
        Operation operation = Operation.factory(readOperation, resource);
        list.add(operation.doAction());
      }
    }
    return list;
  }

  public void delete(long id, Resource resource) {
    synchronized (resource.access(id)){
      Crud deleteOperation = Delete.factory(id);
      Operation operation = Operation.factory(deleteOperation, resource);
      operation.doAction();
    }
  }

  public void create(Resource resource, DataRecord dataRecord) {
    Crud createOperation = Create.factory(dataRecord.getId(), dataRecord);
    Operation operation = Operation.factory(createOperation, resource);
    operation.doAction();
  }

  public void update(Resource resource, DataRecord dataRecord) {
    delete(dataRecord.getId(), resource);
    create(resource, dataRecord);
  }

  public static DAO getDao() {
    if (dao == null) {
      dao = new DAO();
    }
    return dao;
  }
}

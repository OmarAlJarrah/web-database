package com.omar.demo.data;

import com.omar.demo.cache.Cache;
import com.omar.demo.log.Log;
import com.omar.demo.objects.DataRecord;
import com.omar.demo.serialization.SerializationMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class DAO  {

  @Autowired
  Log logger;

  public List<Object> read(long id, Proxy proxy) {
    List<Object> list = new ArrayList<>();
    Cache cache = proxy.getCache();
    Object dataRecord = cache.getObject(id);

    if (dataRecord instanceof NullSingletonObject) {
      synchronized (proxy.access(id)) {
        Crud readOperation = ReadOperationObject.getNewInstance(id);
        OperationMediator operationMediator = OperationMediator.getOperationMediator(readOperation, proxy);
        dataRecord = operationMediator.doAction();
      }
    }

    list.add(dataRecord);
    return list;
  }

  public List<Object> readAll(Proxy proxy) {
    List<Object> list = new ArrayList<>();
    Set<Long> keys = proxy.getKeySet();
    for (long id: keys) {
      Object object = proxy.access(id);
      if (object == null || object instanceof NullSingletonObject) {
        continue; // In case it was deleted at some other thread.
      }
      synchronized (object) {
        Crud readOperation = ReadOperationObject.getNewInstance(id);
        OperationMediator operationMediator = OperationMediator.getOperationMediator(readOperation, proxy);
        list.add(operationMediator.doAction());
      }
    }
    return list;
  }

  public void delete(long id, Resource resource) {
    synchronized (resource.access(id)){
      Crud deleteOperation = DeleteOperationObject.getNewInstance(id);
      OperationMediator operationMediator = OperationMediator.getOperationMediator(deleteOperation, resource);
      operationMediator.doAction();
      String transaction = new StringBuilder()
                      .append("delete ")
                      .append(new Date().getTime())
                      .append(id)
                      .toString();
      logger.logTransaction(transaction);
    }
  }

  public void create(Resource resource, DataRecord dataRecord) {
    Crud createOperation = CreateOperationObject.getNewInstance(dataRecord.getId(), dataRecord);
    OperationMediator operationMediator = OperationMediator.getOperationMediator(createOperation, resource);
    operationMediator.doAction();

    String transaction = new StringBuilder()
            .append("create ")
            .append(new Date().getTime())
            .append(SerializationMediator.getSerializedString(dataRecord, operationMediator.resource.getOutputClass()))
            .toString();

    logger.logTransaction(transaction);
  }

  public void update(Resource resource, DataRecord dataRecord) {
    delete(dataRecord.getId(), resource);
    create(resource, dataRecord);
  }
}

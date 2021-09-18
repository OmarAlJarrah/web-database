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

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
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
        cache.update(id, dataRecord, proxy.getOverallRecordsCount());
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
      synchronized (proxy.access(id)) {
        Crud readOperation = ReadOperationObject.getNewInstance(id);
        OperationMediator operationMediator = OperationMediator.getOperationMediator(readOperation, proxy);
        list.add(operationMediator.doAction());
      }
    }
    return list;
  }

  public void delete(long id, Proxy proxy) {
    synchronized (proxy.access(id)){
      Crud deleteOperation = DeleteOperationObject.getNewInstance(id);
      OperationMediator operationMediator = OperationMediator.getOperationMediator(deleteOperation, proxy);
      operationMediator.doAction();
      String transaction = new StringBuilder()
                      .append("delete ")
                      .append(new Date().getTime())
                      .append(id)
                      .toString();
      logger.logTransaction(transaction);
    }
  }

  public void create(Proxy proxy, DataRecord dataRecord) {
    Crud createOperation = CreateOperationObject.getNewInstance(dataRecord.getId(), dataRecord);
    OperationMediator operationMediator = OperationMediator.getOperationMediator(createOperation, proxy);
    operationMediator.doAction();

    String transaction = new StringBuilder()
            .append("create ")
            .append(new Date().getTime())
            .append(SerializationMediator.getSerializedString(dataRecord, operationMediator.proxy.getOutputClass()))
            .toString();

    logger.logTransaction(transaction);
  }

  public void update(Proxy proxy, DataRecord dataRecord) {
    delete(dataRecord.getId(), proxy);
    create(proxy, dataRecord);
    proxy.getCache().update(dataRecord.getId(), dataRecord, proxy.getOverallRecordsCount());
  }
}

package com.omar.demo.data;


import com.omar.demo.serialization.SerializationMediator;

class ReadOperationObject implements Crud {
  private final long id;

  private ReadOperationObject(long id) {
    this.id = id;
  }


  @Override
  public Object doAction(Proxy proxy) {
    Object object = proxy.getCache().getObject(id);
    if (object instanceof NullSingletonObject) {
      object = SerializationMediator.deserialize(id, proxy);
      proxy.getCache().update(id, object, proxy.getOverallRecordsCount());
    }
    return object;
  }

  public static ReadOperationObject getNewInstance(long id) {
    return new ReadOperationObject(id);
  }
}

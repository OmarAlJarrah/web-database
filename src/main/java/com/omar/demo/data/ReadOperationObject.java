package com.omar.demo.data;


import com.omar.demo.serialization.SerializationMediator;

class ReadOperationObject implements Crud {
  private final long id;

  private ReadOperationObject(long id) {
    this.id = id;
  }


  @Override
  public Object doAction(Resource resource) {
    return SerializationMediator.deserialize(id, resource.getOutputClass());
  }

  public static ReadOperationObject factory(long id) {
    return new ReadOperationObject(id);
  }
}

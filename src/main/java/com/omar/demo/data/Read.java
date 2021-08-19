package com.omar.demo.data;


import com.omar.demo.serialization.SerializationMediator;

class Read implements Crud {
  private long id;

  private Read(long id) {
    this.id = id;
  }


  @Override
  public Object doAction(Resource resource) {
    return SerializationMediator.deserialize(id, resource.getOutputClass());
  }

  public static Read factory(long id) {
    return new Read(id);
  }
}

package com.omar.demo.data;

import com.omar.demo.objects.DataRecord;
import com.omar.demo.serialization.Reference;
import com.omar.demo.serialization.SerializationMediator;

public class Create implements Crud {
  private final long id;
  private final DataRecord dataRecord;

  private Create(long id, DataRecord dataRecord) {
    this.id = id;
    this.dataRecord = dataRecord;
  }

  public Object doAction(Resource resource) {
    SerializationMediator.serialize(dataRecord, resource.getOutputClass());
    resource.add(id, Reference.parseReference(id, resource.getOutputClass()));
    return null;
  }

  public static Create factory(long id, DataRecord dataRecord) {
    return new Create(id, dataRecord);
  }
}

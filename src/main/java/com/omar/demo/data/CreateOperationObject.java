package com.omar.demo.data;

import com.omar.demo.objects.DataRecord;
import com.omar.demo.serialization.Reference;
import com.omar.demo.serialization.SerializationMediator;

public class CreateOperationObject implements Crud {
  private final long id;
  private final DataRecord dataRecord;

  private CreateOperationObject(long id, DataRecord dataRecord) {
    this.id = id;
    this.dataRecord = dataRecord;
  }

  @Override
  public Object doAction(Resource resource) {
    SerializationMediator.serialize(dataRecord, resource.getOutputClass());
    resource.add(id, Reference.parseReference(id, resource.getOutputClass()));
    return null;
  }

  public static CreateOperationObject getNewInstance(long id, DataRecord dataRecord) {
    return new CreateOperationObject(id, dataRecord);
  }
}

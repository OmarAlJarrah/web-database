package com.omar.demo.serialization;

import com.omar.demo.objects.DataRecord;

public class SerializationMediator {
  public static synchronized void serialize(DataRecord dataRecord, Class<?> objectClass) {
    Serializer.serialize(dataRecord, objectClass);
  }

  public static synchronized Object deserialize(long id, Class<?> objectClass) {
    return Deserializer.deserialize(id, objectClass);
  }
}

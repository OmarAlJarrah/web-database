package com.omar.demo.serialization;

import com.google.gson.*;
import com.omar.demo.objects.DataRecord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class Serializer extends SerializationMediator {

  private static final Gson gson = new GsonBuilder()
          .serializeNulls()
          .enableComplexMapKeySerialization()
          .disableInnerClassSerialization()
          .create();

  private Serializer() {}

  public static synchronized void serialize(DataRecord dataRecord, Class<?> objectClass) {

    File file = new File(
            Reference.parseReference(dataRecord.getId(), objectClass)
    );

    try (FileWriter writer = new FileWriter(file)) {
      gson.toJson(objectClass.cast(dataRecord), objectClass, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static synchronized String getForm(DataRecord dataRecord, Class<?> objectClass) {
    return gson.toJson(objectClass.cast(dataRecord));
  }
}

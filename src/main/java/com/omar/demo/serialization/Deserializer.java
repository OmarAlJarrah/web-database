package com.omar.demo.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.omar.demo.objects.NullAnime;

import java.io.*;

class Deserializer extends SerializationMediator {

  private static final Gson gson = new GsonBuilder().create();

  private Deserializer() {}

  public static synchronized Object deserialize(long id, Class<?> objectClass) {
    String path = Reference.parseReference(id, objectClass);

    try (BufferedReader in = new BufferedReader(new FileReader(path))) {
      String obj = in.readLine();
      return gson.fromJson(obj, objectClass);
    } catch (Exception e) {
      e.printStackTrace();
    } return new NullAnime();
  }
}

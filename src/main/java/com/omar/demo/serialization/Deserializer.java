package com.omar.demo.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.omar.demo.data.Proxy;

import java.io.*;

class Deserializer  {

  private static final Gson gson = new GsonBuilder().create();

  private Deserializer() {}

  public static synchronized Object deserialize(long id, Proxy proxy) {
    String obj = readJsonFile((String) proxy.access(id));
    return gson.fromJson(obj, proxy.getObjectClass());
  }

  public static synchronized Object deserialize(long id, Class<?> objectClass) {
    String path = Reference.parseReference(id, objectClass);
    String obj = readJsonFile(path);
    return gson.fromJson(obj, objectClass);
  }

  private static String readJsonFile(String path) {
    try (BufferedReader in = new BufferedReader(new FileReader(path))) {
      return in.readLine();
    } catch (FileNotFoundException e) {
      // Expected in case the required record does not exist
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }
}

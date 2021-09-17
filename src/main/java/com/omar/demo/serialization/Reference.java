package com.omar.demo.serialization;

public class Reference {
  String referenceText;

  private Reference(String referenceText) {
    this.referenceText = referenceText;
  }

  public static Reference factory(long id, Class<?> objectClass) {
    return new Reference(parseReference(id, objectClass));
  }

  public static String parseReference(long id, Class<?> objectClass) {
    return new StringBuilder()
            .append(id)
            .append(objectClass.getName())
            .append(".json")
            .toString();
  }

  public static long parseId(String reference) {
    int indexOfFirstDot = reference.indexOf('c');
    return Long.parseLong(reference.substring(0, indexOfFirstDot));
  }

  public String getReferenceText() {
    return referenceText;
  }
}

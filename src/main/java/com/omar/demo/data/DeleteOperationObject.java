package com.omar.demo.data;

import java.io.File;

public class DeleteOperationObject implements Crud {
  private final long id;

  private DeleteOperationObject(long id) {
    this.id = id;
  }

  @Override
  public Object doAction(Proxy proxy) {
    return new File((String) proxy.access(id)).delete();
  }

  public static DeleteOperationObject getNewInstance(long id) {
    return new DeleteOperationObject(id);
  }
}

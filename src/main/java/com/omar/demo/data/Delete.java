package com.omar.demo.data;

import java.io.File;

public class Delete implements Crud {
  private final long id;

  private Delete(long id) {
    this.id = id;
  }

  @Override
  public Object doAction(Resource resource) {
    return new File((String) resource.access(id)).delete();
  }

  public static Delete factory(long id) {
    return new Delete(id);
  }
}

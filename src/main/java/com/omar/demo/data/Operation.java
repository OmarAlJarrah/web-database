package com.omar.demo.data;

class Operation {
  Crud crudOperation;
  Resource resource;

  private Operation(Crud crudOperation, Resource resource) {
    this.crudOperation = crudOperation;
    this.resource = resource;
  }

  public Object doAction() {
    return crudOperation.doAction(resource);
  }


  public static Operation factory(Crud crudOperation, Resource resource) {
    return new Operation(crudOperation, resource);
  }
}

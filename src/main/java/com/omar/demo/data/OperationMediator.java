package com.omar.demo.data;

class OperationMediator {
  Crud crudOperation;
  Resource resource;

  private OperationMediator(Crud crudOperation, Resource resource) {
    this.crudOperation = crudOperation;
    this.resource = resource;
  }

  public Object doAction() {
    return crudOperation.doAction(resource);
  }


  public static OperationMediator factory(Crud crudOperation, Resource resource) {
    return new OperationMediator(crudOperation, resource);
  }
}

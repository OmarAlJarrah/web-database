package com.omar.demo.data;

class OperationMediator {
  Crud crudOperation;
  Proxy proxy;

  private OperationMediator(Crud crudOperation, Proxy proxy) {
    this.crudOperation = crudOperation;
    this.proxy = proxy;
  }

  public Object doAction() {
    return crudOperation.doAction(proxy);
  }


  public static OperationMediator getOperationMediator(Crud crudOperation, Proxy proxy) {
    return new OperationMediator(crudOperation, proxy);
  }
}

package com.omar.demo.authorization.users;

public class UserBuilder {
  User user;

  Object create() {
    if (validate()) {
      return user;
    } else {
      return new NullUser();
    }
  }

  public UserBuilder userId(long id) {
    this.user.setId(id);
    return this;
  }


  public UserBuilder password(String password) {
    this.user.setPassword(password);
    return this;
  }

  public UserBuilder isAdmin(boolean isAdmin) {
    this.user.setAdmin(isAdmin);
    return this;
  }

  private boolean validateId() {
    return  !AuthorizationManager.userExists(user.getId());
  }

  private boolean validatePassword() {
    String password = this.user.getPassword();
    return  (password == null || password.equals(""));
  }

  private boolean validate() {
    return validateId() && validatePassword();
  }

}

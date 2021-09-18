package com.omar.demo.authorization.users;


import com.omar.demo.serialization.Reference;
import com.omar.demo.serialization.SerializationMediator;

import java.io.File;

public class AuthorizationManager {

  private AuthorizationManager() {}

  public static synchronized boolean addUser(Object user) {
    try {
      User userObject = (User) user;
      SerializationMediator.serialize(userObject, User.class);
      return true;
    } catch (ClassCastException e) {
      // expected in case the user is invalid, mostly it's impossible for this exception to be thrown.
    }
    return false;
  }

  private static synchronized User getUser(long id) {
    return (User) SerializationMediator.deserialize(id, User.class);
  }

  public static synchronized boolean getAccess(long id, String password, boolean isAdmin) {
    if (userNotExists(id)) return false;

    User user = getUser(id);
    return (password.equals(user.getPassword()))
            && (user.isAdmin() == isAdmin);
  }

  protected static synchronized boolean userNotExists(long id) {
    return (!new File(Reference.parseReference(id, User.class)).exists());
  }


}

package com.omar.demo.authorization.users;


import com.omar.demo.serialization.Reference;
import com.omar.demo.serialization.SerializationMediator;

import java.io.File;

public class AuthorizationManager {
  private AuthorizationManager() {}

  public static void addUser(Object user) {
    try {
      User userObject = (User) user;
      SerializationMediator.serialize(userObject, User.class);
    } catch (ClassCastException e) {
      // expected in case the user is invalid
    }
  }

  private static User getUser(long id) {
    return (User) SerializationMediator.deserialize(id, User.class);
  }

  public static boolean getAccess(long id, String password, boolean isAdmin) {
    if (!userExists(id)) return false;

    User user = getUser(id);
    return (password.equals(user.getPassword()))
            && (user.isAdmin() == isAdmin);
  }

  protected static boolean userExists(long id) {
    return (new File(Reference.parseReference(id, User.class)).exists());
  }


}

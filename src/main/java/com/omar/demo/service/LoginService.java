package com.omar.demo.service;

import com.omar.demo.authorization.users.AuthorizationManager;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
  public boolean validate(long id, String password, boolean isAdmin) {
    return AuthorizationManager.getAccess(id, password, isAdmin);
  }
}

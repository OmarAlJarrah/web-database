package com.omar.demo.service;

import com.omar.demo.authorization.users.AuthorizationManager;
import com.omar.demo.authorization.users.UserBuilder;
import com.omar.demo.objects.DataRecord;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
  public boolean addUser(long id, String password, String userType) {
    Object user = new UserBuilder()
            .userId(id)
            .isAdmin(userType.equals("admin"))
            .password(password);
    return AuthorizationManager.addUser(user);
  }
}

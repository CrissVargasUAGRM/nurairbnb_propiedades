package com.nur.factories.users;

import com.nur.model.User;
import core.BusinessRuleValidationException;
import java.util.UUID;

public class UserFactoryImpl implements IUserFactory {
  @Override
  public User createUser(
      UUID id, String username, String email, String password, String accountType, UUID personId)
      throws BusinessRuleValidationException {
    return new User(id, username, email, password, accountType, personId);
  }
}

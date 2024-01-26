package com.nur.repositories;

import com.nur.model.User;
import core.BusinessRuleValidationException;
import java.util.UUID;

public interface IUserRepository {
  UUID update(User user) throws BusinessRuleValidationException;

  User getById(UUID id);

  User getByUsername(String username) throws BusinessRuleValidationException;
}

package com.nur.factories.users;

import com.nur.model.User;
import core.BusinessRuleValidationException;

import java.util.UUID;

public interface IUserFactory {
	User createUser(UUID id, String username, String email, String accountType, String password, UUID personId) throws BusinessRuleValidationException;
}

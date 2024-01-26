package com.nur.factories.users;

import com.nur.model.User;
import core.BusinessRuleValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryImplTest {
	private IUserFactory userFactory;

	@BeforeEach
	void setUp() {
		userFactory = new UserFactoryImpl();
	}

	@Test
	void testUserFactory() throws BusinessRuleValidationException {
		User user = userFactory.createUser(
				UUID.randomUUID(),
				"Cristhian",
				"cristhia@gmail.com",
				"H",
				"123456",
				UUID.randomUUID()
		);
		assertNotNull(user.getId());
		assertNotNull( user.getUsername());
		assertNotNull( user.getEmail());
		assertNotNull( user.getAccountType());
		assertNotNull(user.getPass());
		assertNotNull(user.getPersonId());
	}
}
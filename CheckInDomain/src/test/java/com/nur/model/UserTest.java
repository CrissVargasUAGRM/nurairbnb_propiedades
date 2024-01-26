package com.nur.model;

import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
	@Test
	void testToCheckUser1() throws BusinessRuleValidationException {
		UUID personId = UUID.randomUUID();
		User user =
				new User(personId, "Cristhian", "cristhian_086@gmail.com", "1234567", "Huesped", personId);
		assertEquals("Cristhian", user.getUsername());
		assertEquals("cristhian_086@gmail.com", user.getEmail());
		assertEquals("1234567", user.getPass());
		assertEquals("Huesped", user.getAccountType());
		assertEquals(personId, user.getPersonId());
		assertNotNull(user.getPass());
		assertNotNull(user.getAccountType());
	}

	@Test
	void testToCheckUser2() throws BusinessRuleValidationException {
		UUID personId = UUID.randomUUID();
		User user =
				new User("Cristhian", "cristhian_086@gmail.com", "1234567", "Huesped", personId);
		assertEquals("Cristhian", user.getUsername());
		assertEquals("cristhian_086@gmail.com", user.getEmail());
		assertEquals("1234567", user.getPass());
		assertEquals("Huesped", user.getAccountType());
		assertNotNull(user.getPass());
		assertNotNull(user.getAccountType());
	}

}
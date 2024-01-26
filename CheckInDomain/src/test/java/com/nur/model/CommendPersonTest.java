package com.nur.model;

import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPersonTest {
	@Test
	void testCheckCreateCommend() throws BusinessRuleValidationException {
		UUID userId = UUID.randomUUID();
		CommendPerson commend =
				new CommendPerson(
						UUID.randomUUID(),
						userId, "6", 7, "Bueno", UUID.randomUUID()
				);
		assertEquals("6", commend.getValoration());
		assertEquals("Bueno", commend.getCommend());
		assertEquals(7, commend.getPoints());
		assertNotNull(commend.getUserId());
		assertNotNull(commend.getId());
		assertNotNull(commend.getPersonId());
	}
}
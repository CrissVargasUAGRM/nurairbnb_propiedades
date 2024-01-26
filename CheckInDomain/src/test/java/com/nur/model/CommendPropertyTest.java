package com.nur.model;

import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPropertyTest {
	@Test
	void testCheckCreateCommend() throws BusinessRuleValidationException {
		UUID userId = UUID.randomUUID();
		CommendProperty commend =
				new CommendProperty(
						UUID.randomUUID(),
						userId,
						"6",
						"Buen lugar",
						7,
						UUID.randomUUID()
				);
		assertEquals("Buen lugar", commend.getCommend());
		assertEquals("6", commend.getValoration());
		assertEquals(7, commend.getPoints());
		assertNotNull(commend.getPropertyId());
		assertNotNull(commend.getUserId());
		assertNotNull(commend.getId());
	}
}
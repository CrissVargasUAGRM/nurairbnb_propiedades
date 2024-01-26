package com.nur.factories.commendsPerson;

import com.nur.model.CommendPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPersonFactoryImplTest {
	private ICommendPersonFactory commendPersonFactory;

	@BeforeEach
	void setUp() {
		commendPersonFactory = new CommendPersonFactoryImpl();
	}

	@Test
	void testCommendPersonFactory() {
		CommendPerson commend = commendPersonFactory.createCommend(
				UUID.randomUUID(),
				UUID.randomUUID(),
				"6",
				7,
				"Bueno",
				UUID.randomUUID()
		);
		assertNotNull(commend.getId());
		assertNotNull(commend.getUserId());
		assertNotNull(commend.getValoration());
		assertNotNull(commend.getPoints());
		assertNotNull(commend.getCommend());
		assertNotNull(commend.getPersonId());
	}
}
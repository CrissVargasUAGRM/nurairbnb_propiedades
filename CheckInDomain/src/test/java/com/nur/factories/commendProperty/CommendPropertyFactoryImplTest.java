package com.nur.factories.commendProperty;

import com.nur.model.CommendProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPropertyFactoryImplTest {
	private ICommendPropertyFactory propertyFactory;

	@BeforeEach
	void setUp() {
		propertyFactory = new CommendPropertyFactoryImpl();
	}

	@Test
	void testCommendPropertyFactory() {
		CommendProperty commend = propertyFactory.createCommend(UUID.randomUUID(), UUID.randomUUID(), "7", "Bueno", 8, UUID.randomUUID());
		assertNotNull(commend.getId());
		assertNotNull(commend.getUserId());
		assertNotNull(commend.getValoration());
		assertNotNull(commend.getCommend());
		assertNotNull(commend.getPoints());
		assertNotNull(commend.getPropertyId());
	}
}
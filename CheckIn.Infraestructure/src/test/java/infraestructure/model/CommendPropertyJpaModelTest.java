package infraestructure.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPropertyJpaModelTest {

	@Test
	void testCommendPropertyJpaModel() {
		CommendPropertyJpaModel commend = new CommendPropertyJpaModel();
		commend.setId(UUID.randomUUID());
		commend.setUserId(UUID.randomUUID());
		commend.setValoration("6");
		commend.setCommend("Bueno");
		commend.setPoints(8);
		commend.setPropertyId(UUID.randomUUID());
		assertNotNull(commend.getId());
		assertNotNull(commend.getUserId());
		assertEquals("6", commend.getValoration());
		assertEquals("Bueno", commend.getCommend());
		assertEquals(8, commend.getPoints());
		assertNotNull(commend.getPropertyId());
	}

}
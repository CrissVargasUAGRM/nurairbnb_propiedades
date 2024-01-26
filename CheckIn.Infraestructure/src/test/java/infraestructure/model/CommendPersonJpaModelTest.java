package infraestructure.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPersonJpaModelTest {
	@Test
	void testCommendPersonJpaModel() {
		CommendPersonJpaModel commend = new CommendPersonJpaModel();
		commend.setId(UUID.randomUUID());
		commend.setUserId(UUID.randomUUID());
		commend.setValoration("6");
		commend.setPoints(8);
		commend.setCommend("Bueno");
		commend.setPersonId(UUID.randomUUID());
		assertNotNull(commend.getId());
		assertNotNull(commend.getUserId());
		assertEquals("6", commend.getValoration());
		assertEquals(8, commend.getPoints());
		assertEquals("Bueno", commend.getCommend());
		assertNotNull(commend.getPersonId());
	}
}
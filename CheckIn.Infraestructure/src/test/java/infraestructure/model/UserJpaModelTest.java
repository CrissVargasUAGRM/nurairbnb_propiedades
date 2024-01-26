package infraestructure.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserJpaModelTest {
	@Test
	void testUserJpaModel() {
		UserJpaModel user = new UserJpaModel();
		user.setId(UUID.randomUUID());
		user.setUsername("cristhian");
		user.setPassword("123456");
		user.setEmail("cristhian@gmail.com");
		user.setAccountType("H");
		user.setPersonId(UUID.randomUUID());
		assertNotNull(user.getId());
		assertEquals("cristhian", user.getUsername());
		assertEquals("123456", user.getPassword());
		assertEquals("cristhian@gmail.com", user.getEmail());
		assertEquals("H", user.getAccountType());
		assertNotNull(user.getPersonId());
	}
}
package infraestructure.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonJpaModelTest {
	@Test
	void testPersonJpaModel() {
		PersonJpaModel person = new PersonJpaModel();
		person.setId(UUID.randomUUID());
		person.setName("ejemplo");
		person.setCi("1234567");
		assertNotNull(person.getId());
		assertEquals("ejemplo", person.getName());
		assertEquals("1234567", person.getCi());
	}
}
package infraestructure.utils;

import com.nur.model.User;
import core.BusinessRuleValidationException;
import infraestructure.model.PersonJpaModel;
import infraestructure.model.UserJpaModel;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsersUtilsTest {
	@Test
	void testMethodUSerToJpa() throws BusinessRuleValidationException {
		User user = new User(UUID.randomUUID(), "cristhian", "cristhian@gmail.com", "123456", "H", UUID.randomUUID());
		UserJpaModel userJpaModel = UsersUtils.userToJpaEntity(user);
		assertNotNull(userJpaModel);
	}

	@Test
	void testMethodUserPersonJpa() throws BusinessRuleValidationException {
		User user = new User(UUID.randomUUID(), "cristhian", "cristhian@gmail.com", "123456", "H", UUID.randomUUID());
		PersonJpaModel personJpaModel = UsersUtils.personUserToJpaEntity(user);
		assertNotNull(personJpaModel);
	}

	@Test
	void testJpaUser() throws BusinessRuleValidationException {
		UserJpaModel user = new UserJpaModel();
		user.setId(UUID.randomUUID());
		user.setUsername("cristhian");
		user.setPassword("123456");
		user.setEmail("cristhian@gmail.com");
		user.setAccountType("H");
		user.setPersonId(UUID.randomUUID());
		User userModel = UsersUtils.jpaToUser(user);
		assertNotNull(userModel);
	}
}
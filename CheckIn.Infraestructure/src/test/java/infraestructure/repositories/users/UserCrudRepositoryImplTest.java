package infraestructure.repositories.users;

import com.nur.model.User;
import core.BusinessRuleValidationException;
import infraestructure.model.PersonJpaModel;
import infraestructure.model.UserJpaModel;
import infraestructure.repositories.persons.IPersonCrudRepository;
import infraestructure.utils.UsersUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserCrudRepositoryImplTest {
	@InjectMocks
	private UserCrudRepositoryImpl userCrudRepositoryImpl;
	@Mock
	private IUserCrudRepository userCrudRepository;
	@Mock
	private IPersonCrudRepository personCrudRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testMethodUpdateUser() throws BusinessRuleValidationException {
		UUID userId = UUID.randomUUID();
		UUID personId = UUID.randomUUID();
		User user = new User(userId, "Cristhian", "cristhian@gmail.com", "123456", "H", personId);
		UserJpaModel userJpa = UsersUtils.userToJpaEntity(user);
		PersonJpaModel personJpa = UsersUtils.personUserToJpaEntity(user);
		when(userCrudRepository.save(any(UserJpaModel.class))).thenReturn(userJpa);

		UUID response = userCrudRepositoryImpl.update(user);
		Assert.assertNotNull(response);
		verify(userCrudRepository).save(any(UserJpaModel.class));
		verify(personCrudRepository).save(any(PersonJpaModel.class));
	}

	@Test
	void testGetById() throws BusinessRuleValidationException {
		UUID userId = UUID.randomUUID();
		User user = new User(userId, "Cristhian", "cristhian@gmail.com", "123456", "H", userId);
		UserJpaModel userJpa = UsersUtils.userToJpaEntity(user);
		when(userCrudRepository.findById(any(UUID.class))).thenReturn(Optional.of(userJpa));
		User response = userCrudRepositoryImpl.getById(userId);
		Assert.assertNotNull(response);
		verify(userCrudRepository).findById(any(UUID.class));
	}

	@Test
	void testGetByIdException() {
		UUID userId = UUID.randomUUID();
		when(userCrudRepository.findById(any(UUID.class))).thenThrow(new RuntimeException("Error"));
		RuntimeException actual = Assert.assertThrows(RuntimeException.class, () -> userCrudRepositoryImpl.getById(userId));
		Assert.assertEquals("java.lang.RuntimeException: Error", actual.getMessage());
		verify(userCrudRepository).findById(any(UUID.class));
	}

	@Test
	void testGetByUsername() throws BusinessRuleValidationException {
		User user = new User(UUID.randomUUID(), "Cristhian", "cristhian@gmail.com", "123456", "H", UUID.randomUUID());
		UserJpaModel userJpa = UsersUtils.userToJpaEntity(user);
		when(userCrudRepository.findByUsername(anyString())).thenReturn(userJpa);
		User response = userCrudRepositoryImpl.getByUsername("Cristhian");
		Assert.assertNotNull(response);
		verify(userCrudRepository).findByUsername(anyString());
	}
}
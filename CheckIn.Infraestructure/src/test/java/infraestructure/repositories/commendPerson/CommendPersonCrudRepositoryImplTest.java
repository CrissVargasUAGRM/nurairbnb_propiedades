package infraestructure.repositories.commendPerson;

import com.nur.model.CommendPerson;
import com.nur.repositories.ICommendPersonRepository;
import infraestructure.model.CommendPersonJpaModel;
import infraestructure.utils.CommendPersonUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CommendPersonCrudRepositoryImplTest {
	@Mock
	private ICommendPersonCrudRepository commendPersonRepository;
	@InjectMocks
	private CommendPersonCrudRepositoryImpl commendPersonCrudRepositoryImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCreateCommend() {
		CommendPerson commend = new CommendPerson(UUID.randomUUID(), UUID.randomUUID(), "6", 8, "Bueno", UUID.randomUUID());
		CommendPersonJpaModel model = CommendPersonUtils.commendToJpaEntity(commend);
		when(commendPersonRepository.save(any(CommendPersonJpaModel.class))).thenReturn(model);
		UUID response = commendPersonCrudRepositoryImpl.createCommend(commend);
		assertNotNull(response);
		verify(commendPersonRepository).save(any(CommendPersonJpaModel.class));
	}

	@Test
	void testGetById() {
		CommendPerson commend = new CommendPerson(UUID.randomUUID(), UUID.randomUUID(), "6", 8, "Bueno", UUID.randomUUID());
		CommendPersonJpaModel model = CommendPersonUtils.commendToJpaEntity(commend);
		when(commendPersonRepository.findById(any(UUID.class))).thenReturn(Optional.of(model));
		CommendPerson response = commendPersonCrudRepositoryImpl.getById(UUID.randomUUID());
		assertNotNull(response);
		verify(commendPersonRepository).findById(any(UUID.class));
	}

	@Test
	void testGetByIdException() {
		UUID commendId = UUID.randomUUID();
		when(commendPersonRepository.findById(any(UUID.class))).thenThrow(new RuntimeException("Error"));
		RuntimeException actual = Assert.assertThrows(RuntimeException.class, () -> commendPersonCrudRepositoryImpl.getById(commendId));
		Assert.assertEquals("java.lang.RuntimeException: Error", actual.getMessage());
		verify(commendPersonRepository).findById(any(UUID.class));
	}
}
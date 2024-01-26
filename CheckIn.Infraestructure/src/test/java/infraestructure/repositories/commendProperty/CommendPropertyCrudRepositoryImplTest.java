package infraestructure.repositories.commendProperty;

import com.nur.model.CommendProperty;
import core.BusinessRuleValidationException;
import infraestructure.model.CommendPropertyJpaModel;
import infraestructure.utils.CommendPropertyUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CommendPropertyCrudRepositoryImplTest {
	@Mock
	private ICommendPropertyCrudRepository commendPropertyCrudRepository;
	@InjectMocks
	private CommendPropertyCrudRepositoryImpl commendPropertyCrudRepositoryImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCreateCommendProperty() {
		CommendProperty commend = new CommendProperty(UUID.randomUUID(), UUID.randomUUID(), "6", "Bueno", 8, UUID.randomUUID());
		CommendPropertyJpaModel model = CommendPropertyUtils.commendPropertyJpaModel(commend);
		when(commendPropertyCrudRepository.save(any(CommendPropertyJpaModel.class))).thenReturn(model);
		UUID response = commendPropertyCrudRepositoryImpl.createCommendProperty(commend);
		assertNotNull(response);
		verify(commendPropertyCrudRepository).save(any(CommendPropertyJpaModel.class));
	}

	@Test
	void testGetById() {
		CommendProperty commend = commendPropertyCrudRepositoryImpl.getById(UUID.randomUUID());
		assertEquals(null, commend);
	}

	@Test
	void testGetByProperty() throws BusinessRuleValidationException {
		CommendProperty commend = new CommendProperty(UUID.randomUUID(), UUID.randomUUID(), "6", "Bueno", 8, UUID.randomUUID());
		CommendPropertyJpaModel model = CommendPropertyUtils.commendPropertyJpaModel(commend);
		List<CommendPropertyJpaModel> list = new ArrayList<>();
		list.add(model);
		when(commendPropertyCrudRepository.findByPropertyId(any(UUID.class))).thenReturn(list);
		List<CommendProperty> response = commendPropertyCrudRepositoryImpl.getByPropiedadId(UUID.randomUUID());
		assertNotNull(response);
		assertEquals(1, response.size());
		verify(commendPropertyCrudRepository).findByPropertyId(any(UUID.class));
	}

	@Test
	void testGetByPropertyIsEmpty() throws BusinessRuleValidationException {
		List<CommendPropertyJpaModel> list = new ArrayList<>();
		when(commendPropertyCrudRepository.findByPropertyId(any(UUID.class))).thenReturn(list);
		List<CommendProperty> response = commendPropertyCrudRepositoryImpl.getByPropiedadId(UUID.randomUUID());
		assertEquals(0, response.size());
		verify(commendPropertyCrudRepository).findByPropertyId(any(UUID.class));
	}
}
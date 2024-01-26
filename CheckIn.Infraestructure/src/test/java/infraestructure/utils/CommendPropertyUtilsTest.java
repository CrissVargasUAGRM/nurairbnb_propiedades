package infraestructure.utils;

import com.nur.model.CommendProperty;
import infraestructure.model.CommendPropertyJpaModel;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPropertyUtilsTest {
	@Test
	void testCommendPropertyJpa() {
		CommendProperty commend = new CommendProperty(
				UUID.randomUUID(),
				UUID.randomUUID(),
				"6",
				"Bueno",
				8,
				UUID.randomUUID()
		);
		CommendPropertyJpaModel commendJpa = CommendPropertyUtils.commendPropertyJpaModel(commend);
		assertNotNull(commendJpa);
	}

	@Test
	void testJpaCommendProperty() {
		CommendPropertyJpaModel commend = new CommendPropertyJpaModel();
		commend.setId(UUID.randomUUID());
		commend.setUserId(UUID.randomUUID());
		commend.setValoration("6");
		commend.setCommend("Bueno");
		commend.setPoints(8);
		commend.setPropertyId(UUID.randomUUID());
		CommendProperty commendModel = CommendPropertyUtils.jpaToCommendProperty(commend);
		assertNotNull(commendModel);
	}
}
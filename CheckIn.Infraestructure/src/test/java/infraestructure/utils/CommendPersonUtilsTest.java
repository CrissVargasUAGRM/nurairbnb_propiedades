package infraestructure.utils;

import com.nur.model.CommendPerson;
import infraestructure.model.CommendPersonJpaModel;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendPersonUtilsTest {
	@Test
	void testCommendPersonJpa() {
		CommendPerson commend = new CommendPerson(
				UUID.randomUUID(),
				UUID.randomUUID(),
				"6",
				8,
				"Bueno",
				UUID.randomUUID()
		);
		CommendPersonJpaModel commendModel = CommendPersonUtils.commendToJpaEntity(commend);
		assertNotNull(commendModel);
	}

	@Test
	void testJpaCommendPerson() {
		CommendPersonJpaModel commend = new CommendPersonJpaModel();
		commend.setId(UUID.randomUUID());
		commend.setUserId(UUID.randomUUID());
		commend.setValoration("6");
		commend.setCommend("bueno");
		commend.setPoints(8);
		commend.setPersonId(UUID.randomUUID());
		CommendPerson commendModel = CommendPersonUtils.jpaToCommendPerson(commend);
		assertNotNull(commendModel);
	}
}
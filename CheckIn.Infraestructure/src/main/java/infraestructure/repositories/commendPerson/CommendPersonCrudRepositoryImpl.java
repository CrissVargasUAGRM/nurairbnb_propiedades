package infraestructure.repositories.commendPerson;

import com.nur.model.CommendPerson;
import com.nur.repositories.ICommendPersonRepository;
import infraestructure.model.CommendPersonJpaModel;
import infraestructure.utils.CommendPersonUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CommendPersonCrudRepositoryImpl implements ICommendPersonRepository {
	@Autowired
	private ICommendPersonCrudRepository commendPersonRepository;

	@Override
	public UUID createCommend(CommendPerson commend) {
		CommendPerson commendPerson = new CommendPerson(
				commend.getId(),
				commend.getUserId(),
				commend.getValoration(),
				commend.getPoints(),
				commend.getCommend(),
				commend.getPersonId()
		);
		CommendPersonJpaModel model = CommendPersonUtils.commendToJpaEntity(commendPerson);
		return commendPersonRepository.save(model).getId();
	}

	@Override
	public CommendPerson getById(UUID commendId) {
		try {
			CommendPersonJpaModel jpaModel = commendPersonRepository.findById(commendId).orElse(null);
			return CommendPersonUtils.jpaToCommendPerson(jpaModel);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

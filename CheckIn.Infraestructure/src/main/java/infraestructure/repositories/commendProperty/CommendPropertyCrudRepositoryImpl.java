package infraestructure.repositories.commendProperty;

import com.nur.model.CommendProperty;
import com.nur.repositories.ICommendPropertyRepository;
import infraestructure.model.CommendPropertyJpaModel;
import infraestructure.utils.CommendPersonUtils;
import infraestructure.utils.CommendPropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CommendPropertyCrudRepositoryImpl implements ICommendPropertyRepository {
	@Autowired
	public ICommendPropertyCrudRepository commendPropertyCrudRepository;

	@Override
	public UUID createCommendProperty(CommendProperty commend) {
		CommendProperty commendProperty = new CommendProperty(
				commend.getId(),
				commend.getUserId(),
				commend.getValoration(),
				commend.getCommend(),
				commend.getPoints(),
				commend.getPropertyId()
		);
		CommendPropertyJpaModel model = CommendPropertyUtils.commendPropertyJpaModel(commendProperty);
		return commendPropertyCrudRepository.save(model).getId();
	}

	@Override
	public CommendProperty getById(UUID id) {
		return null;
	}
}

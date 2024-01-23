package infraestructure.repositories.commendProperty;

import com.nur.model.CommendProperty;
import com.nur.repositories.ICommendPropertyRepository;
import infraestructure.model.CommendPropertyJpaModel;
import infraestructure.utils.CommendPropertyUtils;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

public class CommendPropertyCrudRepositoryImpl implements ICommendPropertyRepository {
  @Autowired public ICommendPropertyCrudRepository commendPropertyCrudRepository;

  @Override
  public UUID createCommendProperty(CommendProperty commend) {
    CommendProperty commendProperty =
        new CommendProperty(
            commend.getId(),
            commend.getUserId(),
            commend.getValoration(),
            commend.getCommend(),
            commend.getPoints(),
            commend.getPropertyId());
    CommendPropertyJpaModel model = CommendPropertyUtils.commendPropertyJpaModel(commendProperty);
    return commendPropertyCrudRepository.save(model).getId();
  }

  @Override
  public CommendProperty getById(UUID id) {
    return null;
  }
}

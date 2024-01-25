package infraestructure.repositories.commendProperty;

import com.nur.model.CommendProperty;
import com.nur.repositories.ICommendPropertyRepository;
import core.BusinessRuleValidationException;
import infraestructure.model.CommendPropertyJpaModel;
import infraestructure.utils.CommendPropertyUtils;

import java.util.*;

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

	@Override
	public List<CommendProperty> getByPropiedadId(UUID idPropiedad) throws BusinessRuleValidationException {
		List<CommendPropertyJpaModel> jpaModels = commendPropertyCrudRepository.findByPropertyId(idPropiedad);
		List<CommendProperty> comentarioslist = new ArrayList<>();
		if (jpaModels.isEmpty() ) {
			return  comentarioslist;
		}


		for (CommendPropertyJpaModel jpaModel : jpaModels) {
			comentarioslist.add(CommendPropertyUtils.jpaToCommendProperty(jpaModel));
		}
		return comentarioslist;
	}


}

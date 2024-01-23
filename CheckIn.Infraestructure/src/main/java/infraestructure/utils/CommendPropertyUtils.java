package infraestructure.utils;

import com.nur.model.CommendProperty;
import infraestructure.model.CommendPropertyJpaModel;

public class CommendPropertyUtils {
	public static CommendPropertyJpaModel commendPropertyJpaModel(CommendProperty commendProperty){
		CommendPropertyJpaModel model = new CommendPropertyJpaModel();
		model.setId(commendProperty.getId());
		model.setUserId(commendProperty.getUserId());
		model.setValoration(commendProperty.getValoration());
		model.setCommend(commendProperty.getCommend());
		model.setPoints(commendProperty.getPoints());
		model.setPropertyId(commendProperty.getPropertyId());
		return model;
	}

	public static CommendProperty jpaToCommendProperty(CommendPropertyJpaModel jpaModel){
		return new CommendProperty(
				jpaModel.getId(),
				jpaModel.getUserId(),
				jpaModel.getValoration(),
				jpaModel.getCommend(),
				jpaModel.getPoints(),
				jpaModel.getPropertyId()
		);
	}
}

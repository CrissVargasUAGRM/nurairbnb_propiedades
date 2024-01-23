package infraestructure.utils;

import com.nur.model.CommendPerson;
import infraestructure.model.CommendPersonJpaModel;

public class CommendPersonUtils {
	public static CommendPersonJpaModel commendToJpaEntity(CommendPerson commendPerson){
		CommendPersonJpaModel model = new CommendPersonJpaModel();
		model.setId(commendPerson.getId());
		model.setValoration(commendPerson.getValoration());
		model.setCommend(commendPerson.getCommend());
		model.setPersonId(commendPerson.getPersonId());
		model.setUserId(commendPerson.getUserId());
		model.setPoints(commendPerson.getPoints());
		return model;
	}

	public static CommendPerson jpaToCommendPerson(CommendPersonJpaModel jpaModel){
		return new CommendPerson(
				jpaModel.getId(),
				jpaModel.getUserId(),
				jpaModel.getValoration(),
				jpaModel.getPoints(),
				jpaModel.getCommend(),
				jpaModel.getPersonId()
		);
	}
}

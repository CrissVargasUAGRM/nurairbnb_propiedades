package use.cases.command.commenPerson.create;

import an.awesome.pipelinr.Command;
import com.nur.factories.commendsPerson.CommendPersonFactoryImpl;
import com.nur.factories.commendsPerson.ICommendPersonFactory;
import com.nur.model.CommendPerson;
import com.nur.repositories.ICommendPersonRepository;
import dtos.CommendPersonDTO;
import org.springframework.stereotype.Component;
import utils.CommendPersonMapper;

import java.util.UUID;

@Component
public class CreateCommendPersonHandler implements Command.Handler<CreateCommendPersonCommand, CommendPersonDTO> {
	private final ICommendPersonRepository commendPersonRepository;
	private final ICommendPersonFactory commendPersonFactory;

	public CreateCommendPersonHandler(ICommendPersonRepository commendPersonRepository) {
		this.commendPersonRepository = commendPersonRepository;
		this.commendPersonFactory = new CommendPersonFactoryImpl();
	}

	@Override
	public CommendPersonDTO handle(CreateCommendPersonCommand command) {
		CommendPerson commendPerson = null;
		try {
			commendPerson = commendPersonFactory.createCommend(
					UUID.fromString(command.commendPersonDTO.getId()),
					UUID.fromString(command.commendPersonDTO.getUserId()),
					command.commendPersonDTO.getValoration(),
					command.commendPersonDTO.getPoints(),
					command.commendPersonDTO.getCommend(),
					UUID.fromString(command.commendPersonDTO.getPersonId()));
			if(commendPerson == null) return null;
			commendPersonRepository.createCommend(commendPerson);
			return CommendPersonMapper.from(commendPerson);
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}

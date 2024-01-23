package use.cases.command.commenPerson.create;

import an.awesome.pipelinr.Command;
import dtos.CommendPersonDTO;

public class CreateCommendPersonCommand implements Command<CommendPersonDTO> {
	CommendPersonDTO commendPersonDTO;

	public CreateCommendPersonCommand(CommendPersonDTO commendPersonDTO) {
		this.commendPersonDTO = commendPersonDTO;
	}
}

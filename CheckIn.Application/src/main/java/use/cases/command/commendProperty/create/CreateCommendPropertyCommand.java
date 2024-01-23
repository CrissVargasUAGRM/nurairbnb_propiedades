package use.cases.command.commendProperty.create;

import an.awesome.pipelinr.Command;
import dtos.CommendPropertyDTO;

public class CreateCommendPropertyCommand implements Command<CommendPropertyDTO> {
	CommendPropertyDTO commendPropertyDTO;

	public CreateCommendPropertyCommand(CommendPropertyDTO commendPropertyDTO) {
		this.commendPropertyDTO = commendPropertyDTO;
	}
}

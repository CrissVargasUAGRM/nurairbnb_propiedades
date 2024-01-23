package use.cases.command.users.get;

import an.awesome.pipelinr.Command;
import dtos.UsersDTO;

import java.util.UUID;

public class GetUserQuery implements Command<UsersDTO> {
	UUID userId;

	public GetUserQuery(UUID userId) {
		this.userId = userId;
	}
}

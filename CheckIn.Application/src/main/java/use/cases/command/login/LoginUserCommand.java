package use.cases.command.login;

import an.awesome.pipelinr.Command;
import dtos.LoginResponseDTO;
import dtos.LoginUserDTO;

public class LoginUserCommand implements Command<LoginResponseDTO> {
	LoginUserDTO credentials;

	public LoginUserCommand(LoginUserDTO credentials) {
		this.credentials = credentials;
	}
}

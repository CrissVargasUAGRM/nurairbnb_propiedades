package use.cases.command.users.create;

import an.awesome.pipelinr.Command;
import dtos.UsersDTO;

public class CreateUserCommand implements Command<UsersDTO> {
  UsersDTO usersDTO;

  public CreateUserCommand(UsersDTO userDTO) {
    this.usersDTO = userDTO;
  }
}

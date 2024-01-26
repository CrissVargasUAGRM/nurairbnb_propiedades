package use.cases.command.login;

import an.awesome.pipelinr.Command;
import com.nur.model.User;
import com.nur.repositories.IUserRepository;
import core.BusinessRuleValidationException;
import dtos.LoginResponseDTO;
import dtos.UsersDTO;
import org.springframework.stereotype.Component;
import utils.UserMapper;

@Component
public class LoginUserHandler implements Command.Handler<LoginUserCommand, LoginResponseDTO> {
  private final IUserRepository userRepository;

  public LoginUserHandler(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public LoginResponseDTO handle(LoginUserCommand command) {
    try {
      User user = userRepository.getByUsername(command.credentials.getUsername());
      UsersDTO userMapeado = UserMapper.from(user);
      if (!userMapeado.getSecretPass().equals(command.credentials.getPassword())) {
        return new LoginResponseDTO(
            "user invalid", command.credentials.getUsername(), "Invalid account", "Invalid");
      }
      return new LoginResponseDTO(
          userMapeado.getId(),
          userMapeado.getUserName(),
          userMapeado.getAccountType(),
          userMapeado.getPersonId());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}

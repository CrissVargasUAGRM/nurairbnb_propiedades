package use.cases.command.users.create;

import an.awesome.pipelinr.Command;
import com.nur.factories.users.IUserFactory;
import com.nur.factories.users.UserFactoryImpl;
import com.nur.model.User;
import com.nur.repositories.IUserRepository;
import dtos.UsersDTO;
import java.util.UUID;
import org.springframework.stereotype.Component;
import utils.UserMapper;

@Component
public class CreateUserHandler implements Command.Handler<CreateUserCommand, UsersDTO> {
  private final IUserRepository userRepository;
  private final IUserFactory userFactory;

  public CreateUserHandler(IUserRepository userRepository) {
    this.userRepository = userRepository;
    this.userFactory = new UserFactoryImpl();
  }

  @Override
  public UsersDTO handle(CreateUserCommand command) {
    User user = null;
    try {
      user =
          userFactory.createUser(
              UUID.fromString(command.usersDTO.getId()),
              command.usersDTO.getUserName(),
              command.usersDTO.getEmail(),
              command.usersDTO.getSecretPass(),
              command.usersDTO.getAccountType(),
              UUID.fromString(command.usersDTO.getPersonId()));
      if (user == null) return null;
      userRepository.update(user);
      return UserMapper.from(user);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }
}

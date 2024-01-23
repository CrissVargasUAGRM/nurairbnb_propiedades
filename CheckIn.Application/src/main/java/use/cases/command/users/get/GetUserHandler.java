package use.cases.command.users.get;

import an.awesome.pipelinr.Command;
import com.nur.model.User;
import com.nur.repositories.IUserRepository;
import dtos.UsersDTO;
import org.springframework.stereotype.Component;
import utils.UserMapper;

@Component
public class GetUserHandler implements Command.Handler<GetUserQuery, UsersDTO> {
	private final IUserRepository userRepository;

	public GetUserHandler(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UsersDTO handle(GetUserQuery command) {
		User user = userRepository.getById(command.userId);
		return UserMapper.from(user);
	}
}

package infraestructure.repositories.users;

import com.nur.model.User;
import com.nur.repositories.IUserRepository;
import core.BusinessRuleValidationException;
import infraestructure.model.UserJpaModel;
import infraestructure.utils.UsersUtils;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {
  @Autowired private IUserCrudRepository userRepository;

  @Override
  public UUID update(User user) throws BusinessRuleValidationException {
    User users =
        new User(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getPass(),
            user.getAccountType(),
            user.getPersonId());
    UserJpaModel model = UsersUtils.userToJpaEntity(users);
    return userRepository.save(model).getId();
  }

  @Override
  public User getById(UUID id) {
    try {
      UserJpaModel jpaModel = userRepository.findById(id).orElse(null);
      if (jpaModel == null) throw new BusinessRuleValidationException("Error");
      return UsersUtils.jpaToUser(jpaModel);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void setUserRepository(IUserCrudRepository userRepository) {
    this.userRepository = userRepository;
  }
}

package infraestructure.repositories.users;

import com.nur.model.User;
import com.nur.repositories.IUserRepository;
import core.BusinessRuleValidationException;
import infraestructure.model.PersonJpaModel;
import infraestructure.model.UserJpaModel;
import infraestructure.repositories.persons.IPersonCrudRepository;
import infraestructure.utils.UsersUtils;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {
  @Autowired private IUserCrudRepository userRepository;
  @Autowired private IPersonCrudRepository personCrudRepository;

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
    PersonJpaModel modelPerson = UsersUtils.personUserToJpaEntity(users);
    personCrudRepository.save(modelPerson);
    return userRepository.save(model).getId();
  }

  @Override
  public User getById(UUID id) {
    try {
      UserJpaModel jpaModel = userRepository.findById(id).orElse(null);
      return UsersUtils.jpaToUser(jpaModel);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public User getByUsername(String username) throws BusinessRuleValidationException {
    UserJpaModel userJpaModel = userRepository.findByUsername(username);
    return UsersUtils.jpaToUser(userJpaModel);
  }

  public void setUserRepository(IUserCrudRepository userRepository) {
    this.userRepository = userRepository;
  }
}

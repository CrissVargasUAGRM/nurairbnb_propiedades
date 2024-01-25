package infraestructure.utils;

import com.nur.model.User;
import core.BusinessRuleValidationException;
import infraestructure.model.UserJpaModel;

public class UsersUtils {
  public static UserJpaModel userToJpaEntity(User users) {
    UserJpaModel model = new UserJpaModel();
    model.setId(users.getId());
    model.setUsername(users.getUsername());
    model.setEmail(users.getEmail());
    model.setPassword(users.getPass());
    model.setAccountType(users.getAccountType());
    model.setPersonId(users.getPersonId());
    return model;
  }

  public static User jpaToUser(UserJpaModel jpaModel) throws BusinessRuleValidationException {
    return new User(
        jpaModel.getId(),
        jpaModel.getUsername(),
        jpaModel.getEmail(),
        jpaModel.getPassword(),
        jpaModel.getAccountType(),
        jpaModel.getPersonId());
  }
}

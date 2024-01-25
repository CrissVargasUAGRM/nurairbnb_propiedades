package infraestructure.repositories.users;

import infraestructure.model.UserJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserCrudRepository extends JpaRepository<UserJpaModel, UUID> {}

package infraestructure.repositories.users;

import infraestructure.model.UserJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserCrudRepository extends JpaRepository<UserJpaModel, UUID> {
}

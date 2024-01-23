package infraestructure.repositories.commendProperty;

import infraestructure.model.CommendPropertyJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICommendPropertyCrudRepository extends JpaRepository<CommendPropertyJpaModel, UUID> {
}

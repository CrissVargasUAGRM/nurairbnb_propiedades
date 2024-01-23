package infraestructure.repositories.commendPerson;

import infraestructure.model.CommendPersonJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICommendPersonCrudRepository extends JpaRepository<CommendPersonJpaModel, UUID> {

}

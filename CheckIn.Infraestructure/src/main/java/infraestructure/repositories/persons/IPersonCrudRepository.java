package infraestructure.repositories.persons;

import infraestructure.model.PersonJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonCrudRepository extends JpaRepository<PersonJpaModel, UUID> {}

package infraestructure.repositories.persons;

import infraestructure.model.PersonJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPersonCrudRepository extends JpaRepository<PersonJpaModel, UUID> {
}

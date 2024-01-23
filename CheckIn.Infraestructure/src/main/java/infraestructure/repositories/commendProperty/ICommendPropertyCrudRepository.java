package infraestructure.repositories.commendProperty;

import infraestructure.model.CommendPropertyJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommendPropertyCrudRepository
    extends JpaRepository<CommendPropertyJpaModel, UUID> {}

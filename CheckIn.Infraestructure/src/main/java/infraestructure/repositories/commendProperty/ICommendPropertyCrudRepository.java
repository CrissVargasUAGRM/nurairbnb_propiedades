package infraestructure.repositories.commendProperty;

import infraestructure.model.CommendPropertyJpaModel;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommendPropertyCrudRepository
    extends JpaRepository<CommendPropertyJpaModel, String> {

	List<CommendPropertyJpaModel> findByPropertyId(UUID propertyId);
}

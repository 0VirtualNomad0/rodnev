package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.ApplicationRoutesEntity;

@Repository
public interface ApplicationRoutesRepository extends CrudRepository<ApplicationRoutesEntity,Integer> {
}

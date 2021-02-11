package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserApplicationEntity;

@Repository
public interface UserApplicationRepository extends CrudRepository<UserApplicationEntity,Integer> {
}

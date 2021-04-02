package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserPermissionsEntity;

@Repository
public interface UserPermissionsRepository extends CrudRepository<UserPermissionsEntity,Integer> {
}

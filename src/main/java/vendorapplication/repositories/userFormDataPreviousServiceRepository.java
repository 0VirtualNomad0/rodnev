package vendorapplication.repositories;

import vendorapplication.entities.userFormDataPreviousServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userFormDataPreviousServiceRepository extends CrudRepository<userFormDataPreviousServiceEntity,Integer> {

}

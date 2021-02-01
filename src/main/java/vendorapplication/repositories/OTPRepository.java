package vendorapplication.repositories;

import vendorapplication.entities.OTPEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends CrudRepository<OTPEntity,Integer> {

}

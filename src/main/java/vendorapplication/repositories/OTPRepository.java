package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.OTPEntity;

@Repository
public interface OTPRepository extends CrudRepository<OTPEntity,Integer> {

}
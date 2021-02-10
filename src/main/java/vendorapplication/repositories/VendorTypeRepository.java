package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.VendorTypeEntity;

@Repository
public interface VendorTypeRepository extends CrudRepository<VendorTypeEntity,Integer> {

}

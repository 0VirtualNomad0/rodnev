package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.VendorEntity;

@Repository
public interface VendorRepository extends CrudRepository<VendorEntity,Integer> {
}

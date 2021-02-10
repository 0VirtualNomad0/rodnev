package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.GenderEntity;
import vendorapplication.entities.NationalityEntity;

@Repository
public interface NationalityRepository  extends CrudRepository<NationalityEntity,Integer> {
}

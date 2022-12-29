package vendorapplication.repositories.croptype;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.CropTypeEntity;

import javax.persistence.Entity;

@Repository
public interface CropTypeRepository extends CrudRepository<CropTypeEntity,Integer>,CropTypeRepositoryCustom {
}

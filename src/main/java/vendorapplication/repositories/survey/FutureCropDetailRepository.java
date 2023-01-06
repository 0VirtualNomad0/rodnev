package vendorapplication.repositories.survey;

import org.springframework.data.repository.CrudRepository;
import vendorapplication.entities.CropDetailEntity;
import vendorapplication.entities.FutureCropDetailEntity;

public interface FutureCropDetailRepository extends CrudRepository<FutureCropDetailEntity, Long> {
}

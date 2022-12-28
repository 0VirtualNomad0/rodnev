package vendorapplication.repositories.qualification;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.QualificationEntity;

@Repository
public interface QualificationRepository extends CrudRepository<QualificationEntity,Integer> , QualificationRepositoryCustom{
}

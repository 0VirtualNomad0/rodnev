package vendorapplication.repositories.qualification;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.QualificationEntity;
import vendorapplication.modal.CategoryModal;
import vendorapplication.modal.QualificationModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "qualification")
public interface QualificationRepositoryCustom  {

    // @Query(value = "SELECT category_id, category_name from mst_category where active = true", nativeQuery = true)
    @Cacheable
    List<QualificationModal> getQualifications();
}

package vendorapplication.repositories.categorycaste;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.CastCategoryEntity;

@Repository
@CacheConfig(cacheNames = "category_caste")
public interface CasteCategoryRepository extends CrudRepository<CastCategoryEntity,Integer>, CasteCategoryRepositoryCustom {
}

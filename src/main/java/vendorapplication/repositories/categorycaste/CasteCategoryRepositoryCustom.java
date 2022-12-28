package vendorapplication.repositories.categorycaste;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.CategoryModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "castecategory_")
public interface CasteCategoryRepositoryCustom {

    // @Query(value = "SELECT category_id, category_name from mst_category where active = true", nativeQuery = true)
    @Cacheable
    List<CategoryModal> getCategories();


}

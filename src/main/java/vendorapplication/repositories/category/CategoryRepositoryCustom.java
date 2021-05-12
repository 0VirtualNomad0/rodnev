package vendorapplication.repositories.category;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.CategoryEntity;
import vendorapplication.modal.CategoryModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "category_")
public interface CategoryRepositoryCustom {

   // @Query(value = "SELECT category_id, category_name from mst_category where active = true", nativeQuery = true)
    @Cacheable
    List<CategoryModal> getCategories();

   // @Query(value = "SELECT * from mst_category where active = true AND category_name =:role_name_" , nativeQuery = true)
    CategoryEntity checkCategory(@Param("role_name_") String rolenmae);
}

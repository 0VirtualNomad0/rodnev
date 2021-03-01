package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.CategoryEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "category")
public interface CategoryRepository extends CrudRepository<CategoryEntity,Integer> {

    @Query(value = "SELECT category_id, category_name from mst_category where active = true", nativeQuery = true)
    @Cacheable
    List<Object[]> getCategories();

    @Query(value = "SELECT * from mst_category where active = true AND category_name =:role_name_" , nativeQuery = true)
    CategoryEntity checkCategory(@Param("role_name_") String rolenmae);
}

package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.CategoryEntity;
import vendorapplication.entities.SubCategoryEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "subCategory")
public interface SubCategoryRepository extends CrudRepository<SubCategoryEntity,Integer> {

        @Query(value = "SELECT subcategory_id, subcategory_name from mst_subcategory where active = true AND category_id =:id", nativeQuery = true)
        @Cacheable
        List<Object[]> getSubCategories(@Param("id") Integer mobile);



        @Query(value = "SELECT * from mst_subcategory where active = true AND subcategory_name =:role_name_" , nativeQuery = true)
        SubCategoryEntity checkSubCategory(@Param("role_name_") String rolenmae);



}

package vendorapplication.repositories.subcategory;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.SubCategoryEntity;
import vendorapplication.modal.SubCategoryModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "subCategory_")
public interface SubCategoryRepositoryCustom {

    @Cacheable
    List<SubCategoryModal> getSubCategories(Integer categoryId);

   // @Query(value = "SELECT * from mst_subcategory where active = true AND subcategory_name =:role_name_" , nativeQuery = true)
    SubCategoryEntity checkSubCategory( String subCategory);
}

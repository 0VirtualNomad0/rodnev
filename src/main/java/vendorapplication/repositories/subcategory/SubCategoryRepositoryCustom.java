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

    Boolean checkSubCategory( String subCategory);
}

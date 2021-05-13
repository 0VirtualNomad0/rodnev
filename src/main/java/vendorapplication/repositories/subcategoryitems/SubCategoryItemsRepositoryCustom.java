package vendorapplication.repositories.subcategoryitems;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.Items;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "subCategoryItems_")
public interface SubCategoryItemsRepositoryCustom {

    @Cacheable
    List<Items> getItemsSubCategory(Integer landType , Integer category , Integer subCategory );

    @Cacheable
    List<Items> getItemsSubCategoryNR( Integer landType , Integer category ,  Integer regional , Integer subCategory );

    @Cacheable
    List<Items> getItemsSubCategoryOthers( Integer landType , Integer category ,  Integer subCategory );
}

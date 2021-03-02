package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.SubCategoryEntity;
import vendorapplication.entities.SubCategoryItemsEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "subCategoryItems")
public interface SubCategoryItemsRepository extends CrudRepository<SubCategoryItemsEntity,Integer> {

    @Query(value = "SELECT items_id, items_name, fee, securityamount from mst_subcategoryitems where active = true AND subcategory_id =:subCategory AND category_id =:category AND landtype_id =:landType AND nationality_id =:nationality AND nationalregional_id =:regional", nativeQuery = true)
    @Cacheable
    List<Object[]> getItemsSubCategory(
            @Param("nationality") Integer nationality ,
            @Param("landType") Integer landType ,
            @Param("regional") Integer regional ,
            @Param("category") Integer category ,
            @Param("subCategory") Integer subCategory );





}

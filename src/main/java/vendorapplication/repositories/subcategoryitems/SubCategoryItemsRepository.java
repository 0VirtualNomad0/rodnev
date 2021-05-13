package vendorapplication.repositories.subcategoryitems;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.SubCategoryItemsEntity;

@Repository
@CacheConfig(cacheNames = "subCategoryItems")
public interface SubCategoryItemsRepository extends CrudRepository<SubCategoryItemsEntity,Integer>, SubCategoryItemsRepositoryCustom {

}

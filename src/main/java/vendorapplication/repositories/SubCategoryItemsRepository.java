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





}

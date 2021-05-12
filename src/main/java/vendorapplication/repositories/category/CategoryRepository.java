package vendorapplication.repositories.category;

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
public interface CategoryRepository extends CrudRepository<CategoryEntity,Integer>, CategoryRepositoryCustom {

}

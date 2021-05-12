package vendorapplication.repositories.landtype;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.LandTypeEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "landType")
public interface LandTypeRepository extends CrudRepository<LandTypeEntity,Integer>, LandTypeRepositoryCustom {

}

package vendorapplication.repositories.district;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.DistrictEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "districts")
public interface DistrictRepository extends CrudRepository<DistrictEntity,Integer> , DistrictRepositoryCustom {


}

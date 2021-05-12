package vendorapplication.repositories.nationalregional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.NationalRegionalEntity;
import vendorapplication.repositories.nationality.NationalityRepositoryCustom;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "national_regional")
public interface NationalRegionalRepository extends CrudRepository<NationalRegionalEntity, Integer>, NationalRegionalRepositoryCustom {


}

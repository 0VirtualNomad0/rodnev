package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.NationalRegionalEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "national_regional")
public interface NationalRegionalRepository extends CrudRepository<NationalRegionalEntity, Integer> {

    @Query(value = "SELECT nationalRegional_id, nationalRegional_name from mst_nationalRegional where active = true", nativeQuery = true)
    @Cacheable
    List<Object[]> getNationalRegional();
}

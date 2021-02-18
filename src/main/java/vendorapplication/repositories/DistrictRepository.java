package vendorapplication.repositories;

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
public interface DistrictRepository extends CrudRepository<DistrictEntity,Integer> {

    @Query(value = "SELECT district_id, district_name from mst_district where is_active = true", nativeQuery = true)
    @Cacheable
    List<Object[]> getDistricts();

    @Query(value = "SELECT district_id, district_name from mst_district where is_active = true AND state_id =:id", nativeQuery = true)
    @Cacheable
    List<Object[]> getDistrictsViaId(@Param("id") Integer stringId);

}

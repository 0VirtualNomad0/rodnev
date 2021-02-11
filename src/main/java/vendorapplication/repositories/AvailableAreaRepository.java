package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.AvailableAreaEntity;

import java.util.List;


@Repository
@CacheConfig(cacheNames = "availablearea")
public interface AvailableAreaRepository extends CrudRepository<AvailableAreaEntity,Integer> {

    @Query(value = "SELECT area_id, area_name from mst_areaavailable where active = true AND district_id =:id", nativeQuery = true)
    @Cacheable
    List<Object[]> getAvailableAreaDistrict(@Param("id") Integer districtId);


}

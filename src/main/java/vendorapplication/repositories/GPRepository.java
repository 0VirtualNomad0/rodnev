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
@CacheConfig(cacheNames = "gram_panchayat")
public interface GPRepository extends CrudRepository<DistrictEntity,Integer> {



    @Query(value = "SELECT panchayat_id, panchayat_name from mst_gram_panchyat where is_active = true AND block_id =:id", nativeQuery = true)
    @Cacheable
    List<Object[]> getgpViaId(@Param("id") Integer stringId);

}

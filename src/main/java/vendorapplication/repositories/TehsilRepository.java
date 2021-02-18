package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.BlocksEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "tehsil")
public interface TehsilRepository extends CrudRepository<BlocksEntity,Integer> {

    @Query(value = "SELECT tehsil_id, tehsil_name from mst_tehsil where is_active = true AND district_id =:id", nativeQuery = true)
    @Cacheable
    List<Object[]> getTehsilViaDistrict(@Param("id") Integer stringId);

}

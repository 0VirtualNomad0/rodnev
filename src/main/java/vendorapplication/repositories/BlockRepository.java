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
@CacheConfig(cacheNames = "blocks")
public interface BlockRepository extends CrudRepository<BlocksEntity,Integer> {

    @Query(value = "SELECT block_id, block_name from mst_block where is_active = true AND district_id =:id", nativeQuery = true)
    @Cacheable
    List<Object[]> getBlocksViaDistrict(@Param("id") Integer stringId);

}

package vendorapplication.repositories.blocks;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.BlocksEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "blocks_")
public interface BlockRepositoryCustom {

   // @Cacheable(value = "getActiveBlocks", key = "activeBlocks")
    List<BlocksEntity> getAllActiveBlocks(Boolean active, Boolean deleted);

    @Cacheable
    List<BlocksEntity> getBlocksViaDitricts(Integer districtId);
}

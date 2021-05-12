package vendorapplication.repositories.blocks;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.BlockModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "blocks_")
public interface BlockRepositoryCustom {

    List<BlockModal> getAllActiveBlocks(Boolean active, Boolean deleted);

    @Cacheable
    List<BlockModal> getBlocksViaDitricts(Integer districtId,Boolean active, Boolean deleted);
}

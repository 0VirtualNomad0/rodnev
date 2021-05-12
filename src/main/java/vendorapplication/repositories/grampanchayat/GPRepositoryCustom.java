package vendorapplication.repositories.grampanchayat;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.GramPanchayatModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "gram_panchayat_")
public interface GPRepositoryCustom {


    @Cacheable
    List<GramPanchayatModal> getgpViaId(Integer blockId);
}

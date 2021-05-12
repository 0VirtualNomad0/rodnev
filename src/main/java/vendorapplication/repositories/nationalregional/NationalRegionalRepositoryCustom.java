package vendorapplication.repositories.nationalregional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.NationalRegionalModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "national_regional_")
public interface NationalRegionalRepositoryCustom {

   // @Query(value = "SELECT nationalRegional_id, nationalRegional_name from mst_nationalRegional where active = true ORDER BY nationalRegional_id ASC", nativeQuery = true)
    @Cacheable
    List<NationalRegionalModal> getNationalRegional();
}

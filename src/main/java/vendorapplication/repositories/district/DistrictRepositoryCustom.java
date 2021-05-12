package vendorapplication.repositories.district;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.DistrictEntity;
import vendorapplication.modal.DistrictModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "districts_")
public interface DistrictRepositoryCustom {

    @Cacheable
    List<DistrictModal> getDistricts(Boolean isDeleted, Boolean isActive);

    @Cacheable
    List<DistrictModal> getDistrictsViaId(Integer stringId, Boolean isDeleted, Boolean isActive);



}

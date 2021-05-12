package vendorapplication.repositories.landtype;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.LandTypeModal;
import vendorapplication.services.LandTypeService;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "landType_")
public interface LandTypeRepositoryCustom {

    //@Query(value = "SELECT landtype_id, landTye_name from mst_landType where active = true", nativeQuery = true)
    @Cacheable
    List<LandTypeModal> getLandType();
}

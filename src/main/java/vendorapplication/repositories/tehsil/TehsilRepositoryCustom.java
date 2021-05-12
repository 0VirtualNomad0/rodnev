package vendorapplication.repositories.tehsil;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.TehsilModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "tehsil_")
public interface TehsilRepositoryCustom {

    @Cacheable
    List<TehsilModal> getTehsils(Integer districtId);


}

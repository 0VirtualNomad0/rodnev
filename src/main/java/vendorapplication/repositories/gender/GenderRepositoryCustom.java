package vendorapplication.repositories.gender;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.GenderEntity;
import vendorapplication.modal.GenderModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "gender_")
public interface GenderRepositoryCustom {

    @Cacheable
    List<GenderModal> getAllGender();

    @Cacheable
    List<GenderModal> getGender();
}

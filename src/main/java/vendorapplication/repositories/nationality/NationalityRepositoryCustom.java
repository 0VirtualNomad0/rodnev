package vendorapplication.repositories.nationality;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.NationalityModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "nationality_")
public interface NationalityRepositoryCustom {

    @Cacheable
    List<NationalityModal> getNationalality();
}

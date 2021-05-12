package vendorapplication.repositories.states;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.StateModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "states_")
public interface StateRepositoryCustom {

    @Cacheable
    List<StateModal> getStates();


}

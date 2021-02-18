package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.StateEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "states")
public interface StateRepository extends CrudRepository<StateEntity,Integer> {


    @Query(value = "SELECT state_id, state_name from mst_state where is_active = true", nativeQuery = true)
    @Cacheable
    List<Object[]> getStates();
}

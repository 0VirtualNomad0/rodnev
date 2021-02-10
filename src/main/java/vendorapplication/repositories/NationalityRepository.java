package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.GenderEntity;
import vendorapplication.entities.NationalityEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "nationality")
public interface NationalityRepository  extends CrudRepository<NationalityEntity,Integer> {

    @Query(value = "SELECT nationality_id, nationality_name from mst_nationality where active = true", nativeQuery = true)
    @Cacheable
    List<Object[]> getNationalality();


}

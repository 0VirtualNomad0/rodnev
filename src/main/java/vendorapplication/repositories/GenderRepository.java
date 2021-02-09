package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.GenderEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "genders")
public interface GenderRepository extends CrudRepository<GenderEntity,Integer> {

    @Query(value = "SELECT * from gender where active = true", nativeQuery = true)
    @Cacheable
    List<GenderEntity> getAllGender();

    @Query(value = "SELECT gender_id, gender_name from gender where active = true", nativeQuery = true)
    @Cacheable
    List<Object[]> getGender();


}

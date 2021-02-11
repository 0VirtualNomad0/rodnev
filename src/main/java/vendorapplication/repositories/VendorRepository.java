package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.VendorEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "vendor")
public interface VendorRepository extends CrudRepository<VendorEntity,Integer> {

    @Query(value = "SELECT ventype_id, ventype_name from mst_vendor where active = true", nativeQuery = true)
    @Cacheable
    List<Object[]> getVendors();
}

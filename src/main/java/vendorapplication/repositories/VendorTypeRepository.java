package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.NationalityEntity;
import vendorapplication.entities.VendorTypeEntity;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "vendorCategory")
public interface VendorTypeRepository extends CrudRepository<VendorTypeEntity,Integer> {



        @Query(value = "SELECT vendortype_id, vendortype_name from mst_vendorType where active = true AND ventype_id =:id", nativeQuery = true)
        @Cacheable
        List<Object[]> getVendorCategory(@Param("id") Integer mobile);



}

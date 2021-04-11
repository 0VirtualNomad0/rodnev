package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import vendorapplication.entities.RolesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
@CacheConfig(cacheNames = "roles")
public interface RolesRepository extends CrudRepository<RolesEntity, Long> {

    @Query(value = "SELECT role_id, role_name from roles where active = true", nativeQuery = true)
   // @Cacheable
    List<Object[]> getRoles();

    @Query(value = "SELECT * from roles where active = true AND role_name =:role_name_" , nativeQuery = true)
    RolesEntity checkRole(@Param("role_name_") String rolenmae);

    @Query(value = "SELECT role_id, role_name from roles where active = true AND role_name='Vendor'", nativeQuery = true)
    @Cacheable
    List<Object[]> getRoleVendor();

}
package vendorapplication.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserPermissionsEntity;

import java.util.List;

@Repository
public interface UserPermissionsRepository extends CrudRepository<UserPermissionsEntity,Integer> {


    @Query(value = "SELECT * from userapplication_permissions where active = true AND app_id = :appId AND applicatnt_mobile =:mobileNumber ", nativeQuery = true)
    @Cacheable
    List<UserPermissionsEntity> getAllPermissionsByAppIDandMobile(@Param("appId") Integer appID, @Param("mobileNumber") Long mobileNumber);
}

package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import vendorapplication.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    @Query(value="SELECT * FROM users WHERE mobile_number =:mobile AND active = true AND isdeleted = false ", nativeQuery = true)
    UserEntity getUserDetails(@Param("mobile") Long mobile );

    UserEntity findByUsername(String username);

    @Query(value="SELECT * FROM users WHERE mobile_number =:mobile AND active = true AND isdeleted = false ", nativeQuery = true)
    UserEntity findByMobileNumber(@Param("mobile") Long mobile);

    @Query(value="SELECT user_id FROM users WHERE username =:username_ AND active = true AND isdeleted = false ", nativeQuery = true)
    List<Object[]> getUserID(@Param("username_") String username_);

    @Query(value="SELECT state_id,district_id,block_id,tehsil_id,panchayat_id,user_id FROM users WHERE username =:username_ AND active = true AND isdeleted = false ", nativeQuery = true)
    List<Object[]> getUserGeoData(@Param("username_") String username_);
}

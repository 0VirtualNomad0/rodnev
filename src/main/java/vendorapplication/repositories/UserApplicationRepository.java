package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserApplicationEntity;

import java.util.List;

@Repository

public interface UserApplicationRepository extends CrudRepository<UserApplicationEntity,Integer> {

    @Query(value = "SELECT *  from public.user_application where active = true  order by createddate desc", nativeQuery = true)
    List<UserApplicationEntity> getUserApplications(Long userId);



}

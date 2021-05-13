package vendorapplication.repositories.user;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import vendorapplication.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> , UserRepositoryCustom{

    UserEntity findByUsername(String username);


}

package vendorapplication.repositories.roles;

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
public interface RolesRepository extends CrudRepository<RolesEntity, Long>,RolesRepositoryCustom {



}
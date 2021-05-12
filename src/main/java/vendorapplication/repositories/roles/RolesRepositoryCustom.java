package vendorapplication.repositories.roles;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.RolesEntity;
import vendorapplication.modal.RolesModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "roles_")
public interface RolesRepositoryCustom {


    List<RolesModal> getRoles();

    RolesEntity checkRole(String rolenmae);

     @Cacheable
    List<RolesModal> getRoleVendor();
}

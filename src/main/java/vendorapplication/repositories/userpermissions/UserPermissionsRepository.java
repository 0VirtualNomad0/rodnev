package vendorapplication.repositories.userpermissions;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserPermissionsEntity;

import java.util.List;

@Repository
public interface UserPermissionsRepository extends CrudRepository<UserPermissionsEntity,Integer>, UserPermissionsRepositoryCustom {

}

package vendorapplication.repositories;

import vendorapplication.entities.RolesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, Long> {

    @Query(value = "SELECT role_id, role_name from roles where active = true", nativeQuery = true)
    List<Object[]> getRoles();

    @Query(value = "SELECT * from roles where active = true AND role_name =:role_name_" , nativeQuery = true)
    RolesEntity checkRole(@Param("role_name_") String rolenmae);

}
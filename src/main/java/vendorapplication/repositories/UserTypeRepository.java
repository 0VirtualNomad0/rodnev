package vendorapplication.repositories;

import vendorapplication.entities.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeRepository  extends CrudRepository<UserType,Integer> {

    @Query(value="select * from mst_typeuser where active=true", nativeQuery = true)
    List<UserType> getActiveTypeUser() throws Exception;

}

package vendorapplication.repositories.userappitems;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserAppItemsEntity;

@Repository
public interface UserAppItemsRepository extends CrudRepository<UserAppItemsEntity,Integer> {


}

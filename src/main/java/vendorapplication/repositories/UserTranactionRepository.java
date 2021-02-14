package vendorapplication.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserTranactionEntity;

@Repository
public interface UserTranactionRepository extends CrudRepository<UserTranactionEntity,Integer> {

    @Query(value = "select * from user_transaction where app_id=:id AND active = true ", nativeQuery = true)
    UserTranactionEntity getUserTransactions(int id);

}
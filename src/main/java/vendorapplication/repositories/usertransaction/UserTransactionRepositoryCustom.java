package vendorapplication.repositories.usertransaction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserTranactionEntity;

@Repository
public interface UserTransactionRepositoryCustom {

   // @Query(value = "select * from user_transaction where app_id=:id AND active = true ", nativeQuery = true)
    UserTranactionEntity getUserTransactions(Integer appId);
}

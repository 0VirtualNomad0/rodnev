package vendorapplication.repositories.usertransaction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserTranactionEntity;

@Repository
public interface UserTranactionRepository extends CrudRepository<UserTranactionEntity,Integer>, UserTransactionRepositoryCustom {



}
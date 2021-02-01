package vendorapplication.services;


import vendorapplication.entities.UserTranactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.UserTranactionRepository;

@Service
public class UserTransactionService {

    @Autowired
    UserTranactionRepository userTranactionRepository;

    public UserTranactionRepository getUserTranactionRepository() {
        return userTranactionRepository;
    }

    public void setUserTranactionRepository(UserTranactionRepository userTranactionRepository) {
        this.userTranactionRepository = userTranactionRepository;
    }

    public UserTranactionEntity saveTransaction(UserTranactionEntity data){
        return userTranactionRepository.save(data);
    }

    public UserTranactionEntity getUserTransaction(int user_id){
        return userTranactionRepository.getUserTransactions(user_id);
    }
}

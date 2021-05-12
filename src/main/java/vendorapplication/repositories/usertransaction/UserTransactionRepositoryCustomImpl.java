package vendorapplication.repositories.usertransaction;

import jdk.jfr.Percentage;
import org.springframework.stereotype.Service;
import vendorapplication.entities.TehsilEntity;
import vendorapplication.entities.UserTranactionEntity;
import vendorapplication.modal.TehsilModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class UserTransactionRepositoryCustomImpl implements UserTransactionRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public UserTranactionEntity getUserTransactions(Integer appId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserTranactionEntity> cq = cb.createQuery(UserTranactionEntity.class);
        Root<UserTranactionEntity> book = cq.from(UserTranactionEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate appID_ = cb.equal(book.get("appId"), appId);
        cq.where(isActive_,appID_);
        TypedQuery<UserTranactionEntity> query =  entityManager.createQuery(cq);
        return  query.getSingleResult();
    }
}

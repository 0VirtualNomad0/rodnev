package vendorapplication.repositories.user;

import org.springframework.stereotype.Service;
import vendorapplication.entities.TehsilEntity;
import vendorapplication.entities.UserEntity;
import vendorapplication.modal.LoggedInUserLocationSession;
import vendorapplication.modal.TehsilModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<LoggedInUserLocationSession> getUserGeoData(String username_) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LoggedInUserLocationSession> cq = cb.createQuery(LoggedInUserLocationSession.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate username = cb.equal(book.get("username"), username_);
        cq.where(isActive_,isDeleted_,username);
        cq.multiselect(book.get("state").<Integer> get("stateID"),
                book.get("district").<Integer>get("districtId"),
                book.get("block").<Integer>get("districtId"),
                book.get("tehsil").<Integer>get("districtId"),
                book.get("grampanchayat").<Integer>get("panchayatId"),
                book.get("userId")).distinct(true);
        TypedQuery<LoggedInUserLocationSession> query =  entityManager.createQuery(cq);
        return query.getResultList();

    }

    @Override
    public UserEntity findByMobileNumber(Long mobile) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate mobile_ = cb.equal(book.get("mobileNumber"), mobile);
        cq.where(isActive_,isDeleted_,mobile_);
        TypedQuery<UserEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public UserEntity getUserDetails(Long mobile) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate mobile_ = cb.equal(book.get("mobileNumber"), mobile);
        cq.where(isActive_,isDeleted_,mobile_);
        TypedQuery<UserEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

}

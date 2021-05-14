package vendorapplication.repositories.userapplication;

import org.springframework.stereotype.Service;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.entities.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Service
public class UserApplicationRepositoryCustomImpl implements UserApplicationRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<UserApplicationEntity> getUserApplications(Long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserApplicationEntity> cq = cb.createQuery(UserApplicationEntity.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate user_id = cb.equal(book.get("userId").<Long>get("userId"), userId);
        cq.where(isActive_,isDeleted_,user_id).orderBy(cb.desc(book.get("createdDate")));
        TypedQuery<UserApplicationEntity> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public UserApplicationEntity getUserApplication(Integer appID) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserApplicationEntity> cq = cb.createQuery(UserApplicationEntity.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate app_id = cb.equal(book.get("appId"), appID);
        cq.where(isActive_,app_id);
        TypedQuery<UserApplicationEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public UserApplicationEntity getUserApplicationviaAppIdUserID(Integer appID, Integer userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserApplicationEntity> cq = cb.createQuery(UserApplicationEntity.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate app_id = cb.equal(book.get("appId"), appID);
        Predicate user_id = cb.equal(book.get("userId").<Long>get("userId"), userId);
        cq.where(isActive_,app_id,user_id);
        TypedQuery<UserApplicationEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public Integer getApplicationsCount() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.select(cb.count(book)).where(isActive_);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getApprovedApplicationsRole(Integer stateId, Integer districtId, String appStatus) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate state_id = cb.equal(book.get("state").<Integer>get("stateID"), stateId);
        Predicate district_id = cb.equal(book.get("district").<Integer>get("districtId"), districtId);
        Predicate app_status = cb.equal(book.get("applicationStatus"), appStatus);
        cq.select(cb.count(book)).where(isActive_,state_id,district_id,app_status);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getApplicationsCountRole(Integer stateId, Integer districtId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate state_id = cb.equal(book.get("state").<Integer>get("stateID"), stateId);
        Predicate district_id = cb.equal(book.get("district").<Integer>get("districtId"), districtId);
        cq.select(cb.count(book)).where(isActive_,state_id,district_id);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getApplicationsCountRolePCB(Integer stateId, Integer districtId, Integer appId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate state_id = cb.equal(book.get("state").<Integer>get("stateID"), stateId);
        Predicate district_id = cb.equal(book.get("district").<Integer>get("districtId"), districtId);
        Predicate app_id = cb.equal(book.get("appId"), appId);
        cq.select(cb.count(book)).where(isActive_,state_id,district_id,app_id);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getApprovedApplicationsRolePCB(Integer stateId, Integer districtId, String appStatus, Integer appId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate state_id = cb.equal(book.get("state").<Integer>get("stateID"), stateId);
        Predicate district_id = cb.equal(book.get("district").<Integer>get("districtId"), districtId);
        Predicate app_status = cb.equal(book.get("applicationStatus"), appStatus);
        Predicate app_id = cb.equal(book.get("appId"), appId);
        cq.select(cb.count(book)).where(isActive_,state_id,district_id,app_status,app_id);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getApprovedApplications(String appStatus) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate app_status = cb.equal(book.get("applicationStatus"), appStatus);
        cq.select(cb.count(book)).where(isActive_,app_status);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Date getApplicationCreatedDate(Integer appID) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Date> cq = cb.createQuery(Date.class);
        Root<UserApplicationEntity> book = cq.from(UserApplicationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate app_id = cb.equal(book.get("appId"), appID);
        cq.where(isActive_,app_id);
        cq.select(book.get("createdDate"));
        TypedQuery<Date> query =  entityManager.createQuery(cq);
        return query.getSingleResult();




    }





}

package vendorapplication.repositories.userpermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.SubCategoryEntity;
import vendorapplication.entities.UserPermissionsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UserPermissionsRepositoryCustomImpl implements UserPermissionsRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<UserPermissionsEntity> getAllPermissionsByAppIDandMobile(Integer appID, String mobileNumber) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserPermissionsEntity> cq = cb.createQuery(UserPermissionsEntity.class);
        Root<UserPermissionsEntity> book = cq.from(UserPermissionsEntity.class);
        Predicate active_ = cb.equal(book.get("active"), true);
        Predicate appId_ = cb.equal(book.get("appId"), appID);
        Predicate mobile_ = cb.equal(book.get("applicantMobile"), mobileNumber);
        cq.where(active_,appId_,mobile_);
        TypedQuery<UserPermissionsEntity> query =  entityManager.createQuery(cq);
        return query.getResultList();

    }
}

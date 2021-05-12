package vendorapplication.repositories.roles;

import org.springframework.stereotype.Service;
import vendorapplication.entities.NationalRegionalEntity;
import vendorapplication.entities.RolesEntity;
import vendorapplication.modal.NationalRegionalModal;
import vendorapplication.modal.RolesModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class RolesRepositoryCustomImpl implements RolesRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<RolesModal> getRoles() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolesModal> cq = cb.createQuery(RolesModal.class);
        Root<RolesEntity> book = cq.from(RolesEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect( book.get("roleId"), book.get("roleName")).distinct(true);
        TypedQuery<RolesModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public RolesEntity checkRole(String rolenmae) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolesEntity> cq = cb.createQuery(RolesEntity.class);
        Root<RolesEntity> book = cq.from(RolesEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate role_name = cb.equal(book.get("roleName"), rolenmae);
        cq.where(isActive_,role_name);
        cq.multiselect(book.get("roleId"), book.get("roleName")).distinct(true);
        TypedQuery<RolesEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public List<RolesModal> getRoleVendor() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolesModal> cq = cb.createQuery(RolesModal.class);
        Root<RolesEntity> book = cq.from(RolesEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate role_name = cb.equal(book.get("roleName"), "Vendor");
        cq.where(isActive_,role_name);
        cq.multiselect(book.get("roleId"), book.get("roleName")).distinct(true);
        TypedQuery<RolesModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

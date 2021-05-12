package vendorapplication.repositories.gender;

import org.springframework.stereotype.Service;
import vendorapplication.entities.DistrictEntity;
import vendorapplication.entities.GenderEntity;
import vendorapplication.modal.GenderModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GenderRepositoryCustomImpl implements GenderRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GenderModal> getAllGender() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GenderModal> cq = cb.createQuery(GenderModal.class);
        Root<GenderEntity> book = cq.from(GenderEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("genderId"), book.get("genderName")).distinct(true);
        TypedQuery<GenderModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<GenderModal> getGender() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GenderModal> cq = cb.createQuery(GenderModal.class);
        Root<GenderEntity> book = cq.from(GenderEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("genderId"), book.get("genderName")).distinct(true);
        TypedQuery<GenderModal> query =  entityManager.createQuery(cq);
        return query.getResultList();

    }
}

package vendorapplication.repositories.qualification;

import vendorapplication.entities.CastCategoryEntity;
import vendorapplication.entities.QualificationEntity;
import vendorapplication.modal.CategoryModal;
import vendorapplication.modal.QualificationModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class QualificationRepositoryCustomImpl implements QualificationRepositoryCustom{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<QualificationModal> getQualifications() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<QualificationModal> cq = cb.createQuery(QualificationModal.class);
        Root<QualificationEntity> book = cq.from(QualificationEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("qualificationId"), book.get("qualificationName")).distinct(true);
        TypedQuery<QualificationModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

package vendorapplication.repositories.landtype;

import org.springframework.stereotype.Service;
import vendorapplication.entities.LandTypeEntity;
import vendorapplication.entities.StateEntity;
import vendorapplication.modal.LandTypeModal;
import vendorapplication.modal.StateModal;
import vendorapplication.utilities.Constants;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class LandTypeRepositoryCustomImpl implements LandTypeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<LandTypeModal> getLandType() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LandTypeModal> cq = cb.createQuery(LandTypeModal.class);
        Root<LandTypeEntity> book = cq.from(LandTypeEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("landTypeId"), book.get("landTypeName")).distinct(true);
        TypedQuery<LandTypeModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

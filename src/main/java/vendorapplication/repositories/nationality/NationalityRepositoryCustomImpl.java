package vendorapplication.repositories.nationality;

import org.springframework.stereotype.Service;
import vendorapplication.entities.LandTypeEntity;
import vendorapplication.entities.NationalityEntity;
import vendorapplication.modal.LandTypeModal;
import vendorapplication.modal.NationalityModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class NationalityRepositoryCustomImpl implements NationalityRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<NationalityModal> getNationalality() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<NationalityModal> cq = cb.createQuery(NationalityModal.class);
        Root<NationalityEntity> book = cq.from(NationalityEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("nationalityId"), book.get("nationalityName")).distinct(true);
        TypedQuery<NationalityModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

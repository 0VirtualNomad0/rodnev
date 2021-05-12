package vendorapplication.repositories.nationalregional;

import org.springframework.stereotype.Service;
import vendorapplication.entities.NationalRegionalEntity;
import vendorapplication.entities.NationalityEntity;
import vendorapplication.modal.NationalRegionalModal;
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
public class NationalRegionalRepositoryCustomImpl implements NationalRegionalRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<NationalRegionalModal> getNationalRegional() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<NationalRegionalModal> cq = cb.createQuery(NationalRegionalModal.class);
        Root<NationalRegionalEntity> book = cq.from(NationalRegionalEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("nationalRegionalId"), book.get("nationalRegionalName")).distinct(true)
        .orderBy(cb.asc(book.get("nationalRegionalId")));
        TypedQuery<NationalRegionalModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

package vendorapplication.repositories.states;

import org.springframework.stereotype.Service;
import vendorapplication.entities.StateEntity;
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
public class StateRepositoryCustomImpl implements StateRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StateModal> getStates() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StateModal> cq = cb.createQuery(StateModal.class);
        Root<StateEntity> book = cq.from(StateEntity.class);
        Predicate isActive_ = cb.equal(book.get("isActive"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate stateId = cb.equal(book.get("stateID"), Constants.stateID);
        cq.where(isActive_,isDeleted_,stateId);
        cq.multiselect(book.get("stateID"), book.get("stateName")).distinct(true);
        TypedQuery<StateModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

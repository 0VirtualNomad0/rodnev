package vendorapplication.repositories.tehsil;

import org.springframework.stereotype.Service;
import vendorapplication.entities.TehsilEntity;
import vendorapplication.modal.TehsilModal;
import vendorapplication.repositories.blocks.BlockRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TehsilRepositoryCustomImpl implements TehsilRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TehsilModal> getTehsils(Integer stringId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TehsilModal> cq = cb.createQuery(TehsilModal.class);
        Root<TehsilEntity> book = cq.from(TehsilEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("deleted"), false);
        Predicate districtId = cb.equal(book.get("district"), stringId);
        cq.where(isActive_,isDeleted_,districtId);
        cq.multiselect(book.get("districtId"), book.get("districtName")).distinct(true);
        TypedQuery<TehsilModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

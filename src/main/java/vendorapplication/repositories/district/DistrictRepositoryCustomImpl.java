package vendorapplication.repositories.district;

import org.springframework.stereotype.Service;
import vendorapplication.entities.DistrictEntity;
import vendorapplication.modal.BlockModal;
import vendorapplication.modal.DistrictModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DistrictRepositoryCustomImpl implements DistrictRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DistrictModal> getDistricts(Boolean isDeleted, Boolean isActive) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DistrictModal> cq = cb.createQuery(DistrictModal.class);
        Root<DistrictEntity> book = cq.from(DistrictEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), isActive);
        Predicate isDeleated_ = cb.equal(book.get("deleted"), isDeleted);
        cq.where(isActive_,isDeleated_);
        cq.multiselect(book.get("districtId"), book.get("districtName")).distinct(true);
        TypedQuery<DistrictModal> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<DistrictModal> getDistrictsViaId(Integer stringId, Boolean isDeleted, Boolean isActive) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DistrictModal> cq = cb.createQuery(DistrictModal.class);
        Root<DistrictEntity> book = cq.from(DistrictEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), isActive);
        Predicate isDeleated_ = cb.equal(book.get("deleted"), isDeleted);
        Predicate stateId = cb.equal(book.get("stateID"), stringId);
        cq.where(isActive_,isDeleated_, stateId);
        cq.multiselect(book.get("districtId"), book.get("districtName")).distinct(true);
        TypedQuery<DistrictModal> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}

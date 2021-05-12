package vendorapplication.repositories.grampanchayat;

import org.springframework.stereotype.Service;
import vendorapplication.entities.GPEntity;
import vendorapplication.entities.TehsilEntity;
import vendorapplication.modal.GramPanchayatModal;
import vendorapplication.modal.TehsilModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GPRepositoryCustomImpl implements GPRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GramPanchayatModal> getgpViaId(Integer blockId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GramPanchayatModal> cq = cb.createQuery(GramPanchayatModal.class);
        Root<GPEntity> book = cq.from(GPEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("deleted"), false);
        Predicate districtId = cb.equal(book.get("blockId"), blockId);
        cq.where(isActive_,isDeleted_,districtId);
        cq.multiselect(book.get("panchayatId"), book.get("panchayatName")).distinct(true);
        TypedQuery<GramPanchayatModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

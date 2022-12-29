package vendorapplication.repositories.croptype;

import org.springframework.stereotype.Service;
import vendorapplication.entities.CastCategoryEntity;
import vendorapplication.entities.CropTypeEntity;
import vendorapplication.modal.CategoryModal;
import vendorapplication.modal.CropTypeModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CropTypeRepositoryCustomImpl implements CropTypeRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<CropTypeModal> getCropType() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CropTypeModal> cq = cb.createQuery(CropTypeModal.class);
        Root<CropTypeEntity> book = cq.from(CropTypeEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("cropTypeId"), book.get("cropTypeName")).distinct(true);
        TypedQuery<CropTypeModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

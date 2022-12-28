package vendorapplication.repositories.categorycaste;

import org.springframework.stereotype.Service;
import vendorapplication.entities.CastCategoryEntity;
import vendorapplication.entities.CategoryEntity;
import vendorapplication.modal.CategoryModal;
import vendorapplication.repositories.category.CategoryRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CasteCategoryRepositoryCustomImpl implements CasteCategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CategoryModal> getCategories() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoryModal> cq = cb.createQuery(CategoryModal.class);
        Root<CastCategoryEntity> book = cq.from(CastCategoryEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("categoryID"), book.get("categoryName")).distinct(true);
        TypedQuery<CategoryModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

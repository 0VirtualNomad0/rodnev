package vendorapplication.repositories.category;

import org.springframework.stereotype.Service;
import vendorapplication.entities.CategoryEntity;
import vendorapplication.entities.GenderEntity;
import vendorapplication.modal.CategoryModal;
import vendorapplication.modal.GenderModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CategoryModal> getCategories() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoryModal> cq = cb.createQuery(CategoryModal.class);
        Root<CategoryEntity> book = cq.from(CategoryEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect(book.get("categoryID"), book.get("categoryName")).distinct(true);
        TypedQuery<CategoryModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public CategoryEntity checkCategory(String rolenmae) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoryEntity> cq = cb.createQuery(CategoryEntity.class);
        Root<CategoryEntity> book = cq.from(CategoryEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate category = cb.equal(book.get("categoryName"), rolenmae);
        cq.where(isActive_,category);
        TypedQuery<CategoryEntity> query =  entityManager.createQuery(cq);
        return (CategoryEntity) query.getResultList();
    }
}

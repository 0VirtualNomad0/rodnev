package vendorapplication.repositories.subcategory;

import org.springframework.stereotype.Service;
import vendorapplication.entities.GPEntity;
import vendorapplication.entities.SubCategoryEntity;
import vendorapplication.modal.GramPanchayatModal;
import vendorapplication.modal.SubCategoryModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class SubCategoryRepositoryCustomImpl implements SubCategoryRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<SubCategoryModal> getSubCategories(Integer categoryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SubCategoryModal> cq = cb.createQuery(SubCategoryModal.class);
        Root<SubCategoryEntity> book = cq.from(SubCategoryEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate categoryId_ = cb.equal(book.get("categoryId"), categoryId);
        cq.where(isActive_,categoryId_);
        cq.multiselect(book.get("subCategoryId"), book.get("subCategoryName")).distinct(true);
        TypedQuery<SubCategoryModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }


    @Override
    public SubCategoryEntity checkSubCategory(String subCategory) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SubCategoryEntity> cq = cb.createQuery(SubCategoryEntity.class);
        Root<SubCategoryEntity> book = cq.from(SubCategoryEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate categoryId_ = cb.equal(book.get("subCategoryName"), subCategory);
        cq.where(isActive_,categoryId_);
        cq.multiselect(book.get("subCategoryId"), book.get("subCategoryName")).distinct(true);
        TypedQuery<SubCategoryEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }


}

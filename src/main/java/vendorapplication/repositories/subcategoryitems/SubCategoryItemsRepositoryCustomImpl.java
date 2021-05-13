package vendorapplication.repositories.subcategoryitems;

import org.springframework.stereotype.Service;
import vendorapplication.entities.SubCategoryItemsEntity;
import vendorapplication.modal.Items;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class SubCategoryItemsRepositoryCustomImpl implements SubCategoryItemsRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Items> getItemsSubCategory(Integer landType, Integer category, Integer subCategory) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Items> cq = cb.createQuery(Items.class);
        Root<SubCategoryItemsEntity> book = cq.from(SubCategoryItemsEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate landType_ = cb.equal(book.get("landType"), landType);
        Predicate category_ = cb.equal(book.get("category"), category);
        Predicate subCategory_ = cb.equal(book.get("subCategory"), subCategory);
        cq.where(isActive_,landType_,category_,subCategory_);
        cq.multiselect(book.get("itemId"), book.get("itemName"), book.get("fee"), book.get("fee_bdo"), book.get("securityAmount"));
        TypedQuery<Items> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Items> getItemsSubCategoryNR(Integer landType, Integer category, Integer regional, Integer subCategory) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Items> cq = cb.createQuery(Items.class);
        Root<SubCategoryItemsEntity> book = cq.from(SubCategoryItemsEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate landType_ = cb.equal(book.get("landType"), landType);
        Predicate category_ = cb.equal(book.get("category"), category);
        Predicate regional_ = cb.equal(book.get("nationalRegional"), regional);
        Predicate subCategory_ = cb.equal(book.get("subCategory"), subCategory);
        cq.where(isActive_,landType_,category_,subCategory_,regional_);
        cq.multiselect(book.get("itemId"), book.get("itemName"), book.get("fee"), book.get("fee_bdo"), book.get("securityAmount"));
        TypedQuery<Items> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Items> getItemsSubCategoryOthers(Integer landType, Integer category, Integer subCategory) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Items> cq = cb.createQuery(Items.class);
        Root<SubCategoryItemsEntity> book = cq.from(SubCategoryItemsEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate landType_ = cb.equal(book.get("landType"), landType);
        Predicate category_ = cb.equal(book.get("category"), category);
        Predicate subCategory_ = cb.equal(book.get("subCategory"), subCategory);
        cq.where(isActive_,landType_,category_,subCategory_);
        cq.multiselect(book.get("itemId"), book.get("itemName"), book.get("fee"), book.get("fee_bdo"), book.get("securityAmount"));
        TypedQuery<Items> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }
}

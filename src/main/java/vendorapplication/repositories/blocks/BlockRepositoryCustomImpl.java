package vendorapplication.repositories.blocks;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import vendorapplication.entities.BlocksEntity;
import vendorapplication.entities.DistrictEntity;
import vendorapplication.modal.BlockModal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Service
public class BlockRepositoryCustomImpl implements BlockRepositoryCustom{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<BlockModal> getAllActiveBlocks(Boolean active, Boolean deleted) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BlockModal> cq = cb.createQuery(BlockModal.class);
        Root<BlocksEntity> book = cq.from(BlocksEntity.class);
        Predicate isActive = cb.equal(book.get("active"), active);
        Predicate isDeleated = cb.equal(book.get("deleted"), deleted);
        cq.where(isActive,isDeleated);
        cq.multiselect(book.get("districtId"), book.get("districtName")).distinct(true);
        TypedQuery<BlockModal> query = entityManager.createQuery(cq);
        return query.getResultList();
    }



    @Override
    public List<BlockModal> getBlocksViaDitricts(Integer districtId,Boolean active, Boolean deleted) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BlockModal> cq = cb.createQuery(BlockModal.class);
        Root book = cq.from(BlocksEntity.class);
        Predicate authorNamePredicate = cb.equal(book.get("districtid"), districtId);
        Predicate isActive = cb.equal(book.get("active"), active);
        Predicate isDeleated = cb.equal(book.get("deleted"), deleted);
        cq.where(authorNamePredicate,isActive,isDeleated);
        cq.multiselect(book.get("districtId"), book.get("districtName")).distinct(true);
        TypedQuery<BlockModal> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}

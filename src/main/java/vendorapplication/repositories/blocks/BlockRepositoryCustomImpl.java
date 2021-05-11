package vendorapplication.repositories.blocks;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import vendorapplication.entities.BlocksEntity;
import vendorapplication.entities.DistrictEntity;

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
    public List<BlocksEntity> getAllActiveBlocks(Boolean active, Boolean deleted) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BlocksEntity> cq = cb.createQuery(BlocksEntity.class);
        Root<BlocksEntity> book = cq.from(BlocksEntity.class);
        Predicate isActive = cb.equal(book.get("active"), active);
        Predicate isDeleated = cb.equal(book.get("deleted"), deleted);
        cq.where(isActive,isDeleated);
        TypedQuery<BlocksEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }



    @Override
    public List<BlocksEntity> getBlocksViaDitricts(Integer districtId) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BlocksEntity> cq = cb.createQuery(BlocksEntity.class);
        Root book = cq.from(BlocksEntity.class);
        Predicate authorNamePredicate = cb.equal(book.get("districtid"), districtId);
        cq.where(authorNamePredicate);
        TypedQuery<BlocksEntity> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}

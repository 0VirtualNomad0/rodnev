package vendorapplication.repositories.blocks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.BlocksEntity;



@Repository
public interface BlockRepository extends CrudRepository<BlocksEntity,Integer>, BlockRepositoryCustom {


}

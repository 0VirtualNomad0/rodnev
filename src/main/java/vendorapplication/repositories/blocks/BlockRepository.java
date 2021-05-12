package vendorapplication.repositories.blocks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.BlocksEntity;

import java.util.List;


@Repository
public interface BlockRepository extends CrudRepository<BlocksEntity,Integer>, BlockRepositoryCustom {


}

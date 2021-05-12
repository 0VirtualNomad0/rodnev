package vendorapplication.repositories.tehsil;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.BlocksEntity;
import vendorapplication.entities.TehsilEntity;

@Repository
@CacheConfig(cacheNames = "tehsils")
public interface TehsilRepository extends CrudRepository<TehsilEntity,Integer>, TehsilRepositoryCustom {


}

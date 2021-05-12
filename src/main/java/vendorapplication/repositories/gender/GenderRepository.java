package vendorapplication.repositories.gender;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.GenderEntity;

import java.util.List;

@Repository
public interface GenderRepository extends CrudRepository<GenderEntity,Integer> , GenderRepositoryCustom {


}

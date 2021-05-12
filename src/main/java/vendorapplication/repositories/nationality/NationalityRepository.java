package vendorapplication.repositories.nationality;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.GenderEntity;
import vendorapplication.entities.NationalityEntity;
import vendorapplication.modal.NationalityModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "nationality")
public interface NationalityRepository  extends CrudRepository<NationalityEntity,Integer>, NationalityRepositoryCustom {


}

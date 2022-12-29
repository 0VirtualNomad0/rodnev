package vendorapplication.repositories.croptype;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vendorapplication.modal.CropTypeModal;
import vendorapplication.modal.QualificationModal;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "cropType")
public interface CropTypeRepositoryCustom {

    @Cacheable
    List<CropTypeModal> getCropType();
}

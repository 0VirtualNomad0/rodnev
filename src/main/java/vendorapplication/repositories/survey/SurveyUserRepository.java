package vendorapplication.repositories.survey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vendorapplication.entities.SurveyUserEntity;

@Repository
public interface SurveyUserRepository extends CrudRepository<SurveyUserEntity,Long> {
    public SurveyUserEntity getByAadhaarNumber(long aadhaarNumber);
}

package vendorapplication.repositories.survey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.SurveyAgricultureEntity;
import vendorapplication.entities.SurveyAnimalHusbandryEntity;

@Repository
public interface SurveyAgricultureRepository extends CrudRepository<SurveyAgricultureEntity,Long> {


}
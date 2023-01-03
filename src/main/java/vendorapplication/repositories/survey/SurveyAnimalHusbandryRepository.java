package vendorapplication.repositories.survey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.SurveyAnimalHusbandryEntity;


@Repository
public interface SurveyAnimalHusbandryRepository extends CrudRepository<SurveyAnimalHusbandryEntity,Long> {


}
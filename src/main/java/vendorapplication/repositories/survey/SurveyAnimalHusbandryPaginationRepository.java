package vendorapplication.repositories.survey;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import vendorapplication.entities.SurveyAgricultureEntity;
import vendorapplication.entities.SurveyAnimalHusbandryEntity;

import javax.transaction.Transactional;

@Transactional
public interface SurveyAnimalHusbandryPaginationRepository  extends
        DataTablesRepository<SurveyAnimalHusbandryEntity, Long>{

}

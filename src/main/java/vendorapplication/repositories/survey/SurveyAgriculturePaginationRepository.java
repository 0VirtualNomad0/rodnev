package vendorapplication.repositories.survey;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import vendorapplication.entities.SurveyAgricultureEntity;

import javax.transaction.Transactional;

@Transactional
public interface SurveyAgriculturePaginationRepository extends
        DataTablesRepository<SurveyAgricultureEntity, Long> {

}

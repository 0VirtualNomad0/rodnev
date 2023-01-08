package vendorapplication.repositories.survey;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import vendorapplication.entities.SurveyAgricultureEntity;

public interface SurveyAgriculturePaginationRepository extends
        DataTablesRepository<SurveyAgricultureEntity, Long> {

}

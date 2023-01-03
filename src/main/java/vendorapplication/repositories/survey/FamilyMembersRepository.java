package vendorapplication.repositories.survey;

import org.springframework.data.repository.CrudRepository;
import vendorapplication.entities.FamilyMembersEntity;

import java.util.List;

public interface FamilyMembersRepository extends CrudRepository<FamilyMembersEntity, Long> {

    List<FamilyMembersEntity> findAllBySurveyUserId_surveyUserId(long surveyUserId);
}

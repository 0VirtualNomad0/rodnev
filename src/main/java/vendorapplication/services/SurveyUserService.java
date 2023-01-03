package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.SurveyAgricultureEntity;
import vendorapplication.entities.SurveyAnimalHusbandryEntity;
import vendorapplication.entities.SurveyUserEntity;
import vendorapplication.repositories.survey.SurveyAgricultureRepository;
import vendorapplication.repositories.survey.SurveyAnimalHusbandryRepository;
import vendorapplication.repositories.survey.SurveyUserRepository;

@Service
public class SurveyUserService {

    @Autowired
    private SurveyUserRepository surveyUserRepository;

    @Autowired
    private SurveyAnimalHusbandryRepository animalHusbandryRepository;

    @Autowired
    private SurveyAgricultureRepository agricultureRepository;

    public SurveyUserEntity saveSurveyUser(SurveyUserEntity entity) {
        return surveyUserRepository.save(entity);
    }

    public SurveyAnimalHusbandryEntity saveAnimalHusbandrySurvey(SurveyAnimalHusbandryEntity entity) {
        return animalHusbandryRepository.save(entity);
    }

    public SurveyAgricultureEntity saveAgricultureSurvey(SurveyAgricultureEntity entity) {
        return agricultureRepository.save(entity);
    }

    public SurveyUserEntity getSurveyUserByAadhaarNumber(long aadhaarNumber)
    {
        return surveyUserRepository.getByAadhaarNumber(aadhaarNumber);
    }
}

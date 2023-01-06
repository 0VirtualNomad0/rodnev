package vendorapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vendorapplication.entities.SurveyAgricultureEntity;
import vendorapplication.entities.SurveyAnimalHusbandryEntity;
import vendorapplication.entities.SurveyUserEntity;
import vendorapplication.modal.SurveyFormBasicModal;
import vendorapplication.modal.SurveyUserBasicModal;
import vendorapplication.repositories.survey.SurveyAgriculturePaginationRepository;
import vendorapplication.repositories.survey.SurveyAnimalHusbandryPaginationRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Join;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class SurveyPaginationController {
    @Autowired
    private SurveyAgriculturePaginationRepository surveyAgriculturePaginationRepository;

    @Autowired
    private SurveyAnimalHusbandryPaginationRepository surveyAnimalHusbandryPaginationRepository;

    @Autowired
    private EntityManager entityManager;


    @RequestMapping(value = "/agriculture-survey-users", method = RequestMethod.GET)
    public DataTablesOutput<SurveyFormBasicModal> listAgricultureSurveyUsers(@Valid DataTablesInput input) {
        List<SurveyFormBasicModal> surveyFormList = new ArrayList<>();

        DataTablesOutput<SurveyFormBasicModal> surveyUsersDatatable =
                new DataTablesOutput<SurveyFormBasicModal>();
        DataTablesOutput<SurveyAgricultureEntity> surveyAgricultureDatatable =
                surveyAgriculturePaginationRepository.findAll(input);
        surveyUsersDatatable.setDraw(surveyAgricultureDatatable.getDraw());
        surveyUsersDatatable.setRecordsTotal(surveyAgricultureDatatable.getRecordsTotal());
        surveyUsersDatatable.setRecordsFiltered(surveyAgricultureDatatable.getRecordsFiltered());
        surveyUsersDatatable.setSearchPanes(surveyAgricultureDatatable.getSearchPanes());
        surveyUsersDatatable.setError(surveyAgricultureDatatable.getError());

        for (SurveyAgricultureEntity surveyAgriculture : surveyAgricultureDatatable.getData()) {
            SurveyFormBasicModal surveyForm = new SurveyFormBasicModal();
            SurveyUserBasicModal surveyUser = new SurveyUserBasicModal();
            SurveyUserEntity surveyUserDao = surveyAgriculture.getSurveyUserId();
            if (surveyUserDao == null) continue;

            surveyUser.setSurveyUserId(surveyUserDao.getSurveyUserId());
            surveyUser.setAge(surveyUserDao.getAge());
            surveyUser.setMobileNumber(surveyUserDao.getMobileNumber());
            surveyUser.setAadhaarNumber(surveyUserDao.getAadhaarNumber());
            surveyUser.setFirstName(surveyUserDao.getFirstName());
            surveyUser.setLastName(surveyUserDao.getLastName());
            surveyUser.setPermanentAddress(surveyUserDao.getPermanentAddress());
            surveyUser.setCreatedDate(surveyUserDao.getCreatedDate());
            //surveyUser.setGender(surveyUserDao.getGenderId().getGenderName());
            surveyForm.setSurveyUserId(surveyUser);
            surveyFormList.add(surveyForm);
        }
        Collections.sort(surveyFormList, byDate);
        surveyUsersDatatable.setData(surveyFormList);

        return surveyUsersDatatable;
    }


    @RequestMapping(value = "/animal-husbandry-survey-users", method = RequestMethod.GET)
    public DataTablesOutput<SurveyFormBasicModal> listAnimalHusbandrySurveyUsers(
            @Valid DataTablesInput input) {
        List<SurveyFormBasicModal> surveyFormList = new ArrayList<>();

        DataTablesOutput<SurveyFormBasicModal> surveyUsersDatatable =
                new DataTablesOutput<>();
        DataTablesOutput<SurveyAnimalHusbandryEntity> surveyAnimalHusbandryDatatable =
                surveyAnimalHusbandryPaginationRepository.findAll(input);

        surveyUsersDatatable.setDraw(surveyAnimalHusbandryDatatable.getDraw());
        surveyUsersDatatable.setRecordsTotal(surveyAnimalHusbandryDatatable.getRecordsTotal());
        surveyUsersDatatable.setRecordsFiltered(surveyAnimalHusbandryDatatable.getRecordsFiltered());
        surveyUsersDatatable.setSearchPanes(surveyAnimalHusbandryDatatable.getSearchPanes());
        surveyUsersDatatable.setError(surveyAnimalHusbandryDatatable.getError());
        for (SurveyAnimalHusbandryEntity surveyAnimalHusbandry : surveyAnimalHusbandryDatatable.getData()) {
            SurveyFormBasicModal surveyForm = new SurveyFormBasicModal();
            SurveyUserBasicModal surveyUser = new SurveyUserBasicModal();
            SurveyUserEntity surveyUserDao = surveyAnimalHusbandry.getSurveyUserId();
            if (surveyUserDao == null) continue;

            surveyUser.setSurveyUserId(surveyUserDao.getSurveyUserId());
            surveyUser.setAge(surveyUserDao.getAge());
            surveyUser.setMobileNumber(surveyUserDao.getMobileNumber());
            surveyUser.setAadhaarNumber(surveyUserDao.getAadhaarNumber());
            surveyUser.setFirstName(surveyUserDao.getFirstName());
            surveyUser.setLastName(surveyUserDao.getLastName());
            surveyUser.setPermanentAddress(surveyUserDao.getPermanentAddress());
            surveyUser.setGender(surveyUserDao.getGenderId().getGenderName());
            surveyForm.setSurveyUserId(surveyUser);
            surveyFormList.add(surveyForm);
        }
        surveyUsersDatatable.setData(surveyFormList);
        return surveyUsersDatatable;
    }

    static final Comparator<SurveyFormBasicModal> byDate = new Comparator<SurveyFormBasicModal>() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");

        public int compare(SurveyFormBasicModal ord1, SurveyFormBasicModal ord2) {
            Date d1 = null;
            Date d2 = null;
            try {
                d1 = sdf.parse(sdf.format(ord1.getSurveyUserId().getCreatedDate()));
                d2 = sdf.parse(sdf.format(ord2.getSurveyUserId().getCreatedDate()));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return (d1.getTime() > d2.getTime() ? -1 : 1);     //descending
        }
    };


}

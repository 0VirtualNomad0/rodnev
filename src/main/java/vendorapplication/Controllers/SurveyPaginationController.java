package vendorapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.mapping.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vendorapplication.entities.SurveyAgricultureEntity;
import vendorapplication.entities.SurveyAnimalHusbandryEntity;
import vendorapplication.entities.SurveyUserEntity;
import vendorapplication.modal.BlockModal;
import vendorapplication.modal.DistrictModal;
import vendorapplication.modal.SurveyFormBasicModal;
import vendorapplication.modal.SurveyUserBasicModal;
import vendorapplication.repositories.survey.SurveyAgriculturePaginationRepository;
import vendorapplication.repositories.survey.SurveyAnimalHusbandryPaginationRepository;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.*;

import static java.util.Collections.singletonList;

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
        input.setOrder(singletonList(new Order(9, "desc")));

        List<SurveyFormBasicModal> surveyFormList = new ArrayList<>();

        DataTablesOutput<SurveyFormBasicModal> surveyUsersDatatable =
                new DataTablesOutput<>();
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

            DistrictModal district = new DistrictModal();
            BlockModal block = new BlockModal();
            district.setDistrictName(surveyUserDao.getDistrictId().getDistrictName());
            block.setBlockName(surveyUserDao.getBlockId().getBlockName());
            surveyUser.setSurveyUserId(surveyUserDao.getSurveyUserId());
            surveyUser.setAge(surveyUserDao.getAge());
            surveyUser.setMobileNumber(surveyUserDao.getMobileNumber());
            surveyUser.setAadhaarNumber(surveyUserDao.getAadhaarNumber());
            surveyUser.setFirstName(surveyUserDao.getFirstName());
            surveyUser.setLastName(surveyUserDao.getLastName());
            surveyUser.setPermanentAddress(surveyUserDao.getPermanentAddress());
            surveyUser.setCreatedDate(surveyUserDao.getCreatedDate());
            surveyUser.setDistrictId(district);
            surveyUser.setBlockId(block);
            surveyForm.setSurveyUserId(surveyUser);
            surveyFormList.add(surveyForm);
        }
        surveyUsersDatatable.setData(surveyFormList);

        return surveyUsersDatatable;
    }


    @RequestMapping(value = "/animal-husbandry-survey-users", method = RequestMethod.GET)
    public DataTablesOutput<SurveyFormBasicModal> listAnimalHusbandrySurveyUsers(
            @Valid DataTablesInput input) {
        input.setOrder(singletonList(new Order(9, "desc")));
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
            DistrictModal district = new DistrictModal();
            BlockModal block = new BlockModal();
            district.setDistrictName(surveyUserDao.getDistrictId().getDistrictName());
            block.setBlockName(surveyUserDao.getBlockId().getBlockName());
            surveyUser.setSurveyUserId(surveyUserDao.getSurveyUserId());
            surveyUser.setAge(surveyUserDao.getAge());
            surveyUser.setMobileNumber(surveyUserDao.getMobileNumber());
            surveyUser.setAadhaarNumber(surveyUserDao.getAadhaarNumber());
            surveyUser.setFirstName(surveyUserDao.getFirstName());
            surveyUser.setLastName(surveyUserDao.getLastName());
            surveyUser.setPermanentAddress(surveyUserDao.getPermanentAddress());
            surveyUser.setCreatedDate(surveyUserDao.getCreatedDate());
            surveyUser.setDistrictId(district);
            surveyUser.setBlockId(block);
            surveyForm.setSurveyUserId(surveyUser);
            surveyFormList.add(surveyForm);
        }
        surveyUsersDatatable.setData(surveyFormList);
        return surveyUsersDatatable;
    }

}

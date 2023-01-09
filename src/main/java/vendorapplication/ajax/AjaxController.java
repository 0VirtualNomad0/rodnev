package vendorapplication.ajax;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import vendorapplication.entities.*;
import vendorapplication.form.vendorAgriApplicationForm;
import vendorapplication.form.vendorApplicationForm;
import vendorapplication.modal.*;
import vendorapplication.repositories.blocks.BlockRepository;
import vendorapplication.repositories.category.CategoryRepository;
import vendorapplication.repositories.categorycaste.CasteCategoryRepository;
import vendorapplication.repositories.croptype.CropTypeRepository;
import vendorapplication.repositories.district.DistrictRepository;
import vendorapplication.repositories.gender.GenderRepository;
import vendorapplication.repositories.grampanchayat.GPRepository;
import vendorapplication.repositories.landtype.LandTypeRepository;
import vendorapplication.repositories.nationality.NationalityRepository;
import vendorapplication.repositories.nationalregional.NationalRegionalRepository;
import vendorapplication.repositories.qualification.QualificationRepository;
import vendorapplication.repositories.roles.RolesRepository;
import vendorapplication.repositories.states.StateRepository;
import vendorapplication.repositories.subcategory.SubCategoryRepository;
import vendorapplication.repositories.subcategoryitems.SubCategoryItemsRepository;
import vendorapplication.repositories.survey.SurveyAnimalHusbandryPaginationRepository;
import vendorapplication.repositories.survey.SurveyUserRepository;
import vendorapplication.repositories.tehsil.TehsilRepository;
import vendorapplication.utilities.Constants;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;
import java.util.*;

@RestController
public class AjaxController {

    private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

    final String uri = "https://himparivar.hp.gov.in/api/v1/get-himparivar-aadhaar-data";

    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    NationalityRepository nationalityRepository;
    @Autowired
    CategoryRepository vendorRepository;
    @Autowired
    CropTypeRepository cropTypeRepository;
    @Autowired
    CasteCategoryRepository casteCategoryRepository;
    @Autowired
    QualificationRepository qualificationRepository;
    @Autowired
    SubCategoryRepository vendorTypeRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    StateRepository stateRepository;
    @Autowired
    BlockRepository blockRepository;
    @Autowired
    TehsilRepository tehsilRepository;
    @Autowired
    GPRepository gpRepository;
    @Autowired
    LandTypeRepository landTypeRepository;
    @Autowired
    NationalRegionalRepository nationalRegionalRepository;
    @Autowired
    SubCategoryItemsRepository subCategoryItemsRepository;
    @Autowired
    SurveyUserRepository surveyUserRepository;
    @Autowired
    private SurveyAnimalHusbandryPaginationRepository surveyAnimalHusbandryPaginationRepository;


    @RequestMapping(value = Constants.getRoles, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody  //ResponseEntity<?>
    String getRoles() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<RolesModal> roles = rolesRepository.getRoles();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, roles);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    @RequestMapping(value = Constants.getGender, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody   //ResponseEntity<?>
    String getGender() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<GenderModal> gender = genderRepository.getGender();


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, gender);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;
    }

    @RequestMapping(value = Constants.getCropType, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody   //ResponseEntity<?>
    String getCropType() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<CropTypeModal> gender = cropTypeRepository.getCropType();


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, gender);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;
    }

    //Get State
    @RequestMapping(value = Constants.getState, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody  // ResponseEntity<?>
    String getState() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<StateModal> states = stateRepository.getStates();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, states);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //Get Districs
    @RequestMapping(value = Constants.getDistrictsViaState, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody  //ResponseEntity<?>
    String getDistrictsViaState(@RequestParam(value = Constants.requestParam, required = true) String id) throws Exception {

        Map<String, Object> map = null;

        try {
            Integer id_ = Integer.parseInt(id);
            List<DistrictModal> districtsObject = districtRepository.getDistrictsViaId(id_, false, true);


            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, districtsObject);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;

        } catch (Exception ex) {
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }


    }

    //getSurveyUserAnimalHusbandryDetails
    @RequestMapping(value = Constants.getSurveyUserAnimalHusbandryData, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getSurveyUserAnimalHusbandryData(@RequestParam(value = Constants.userDetailRequestParam, required = true) String aadhaarNumber) throws Exception {
        Map<String, Object> map = null;

        try {
            Long aadhaar = Long.valueOf(aadhaarNumber);


            SurveyUserEntity surveyUser =
                    surveyUserRepository.getByAadhaarNumber(Long.valueOf(aadhaarNumber));
            map = new HashMap<String, Object>();
            if (surveyUser == null) {
                Optional<AadhaarApiResponse> apiResponse = getAadhaarData(aadhaar);
                if (apiResponse == null || !apiResponse.isPresent()
                        || (apiResponse.isPresent() && apiResponse.get().getStatus() == 404)
                        || (apiResponse.isPresent() && apiResponse.get().getRecords().isEmpty())) {
                    map.put(Constants.keyResponse, "SurveyUserNotFound");
                    map.put(Constants.keyMessage, "AadhaarDataNotFound");
                } else {
                    map.put(Constants.keyMessage, "AadhaarDataFound");
                    AadhaarData data = apiResponse.get().getRecords().get(0);
                    map.put(Constants.keyResponse, data);
                }
            } else {
                vendorApplicationForm formData = populateSurveyUserAnimalHusbandryFormData(surveyUser);
                map.put(Constants.keyResponse, formData);
                map.put(Constants.keyMessage, Constants.valueMessage);
            }
            map.put(Constants.keyStatus, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    private vendorApplicationForm populateSurveyUserAnimalHusbandryFormData(SurveyUserEntity surveyUser) {
        vendorApplicationForm formData = new vendorApplicationForm();
        formData.setAadhaarNumber(String.valueOf(surveyUser.getAadhaarNumber()));
        formData.setFirstname(surveyUser.getFirstName());
        formData.setLastname(surveyUser.getLastName());
        if (surveyUser.getGenderId() != null) {
            formData.setGender(String.valueOf(surveyUser.getGenderId().getGenderId()));
        } else {
            formData.setGender("0");
        }

        formData.setMobileNumber(String.valueOf(surveyUser.getMobileNumber()));
        formData.setAge(String.valueOf(surveyUser.getAge()));
        if (surveyUser.getCategoryId() != null) {
            formData.setCategory(String.valueOf(surveyUser.getCategoryId().getCategoryID()));
        } else {
            formData.setCategory("0");

        }

        formData.setFamilyHead(surveyUser.getFamilyHeadName());

        if (surveyUser.getCategoryId() != null) {
            formData.setCategory(String.valueOf(surveyUser.getCategoryId().getCategoryID()));
        } else {
            formData.setCategory("0");

        }

        if (surveyUser.getQualificationId() != null) {
            formData.setEducationalQualification(
                    String.valueOf(surveyUser.getQualificationId().getQualificationId()));
        } else {
            formData.setEducationalQualification("0");
        }

        if (surveyUser.getStateId() != null) {
            formData.setState(String.valueOf(surveyUser.getStateId().getStateID()));
        } else {
            formData.setState("0");
        }

        if (surveyUser.getDistrictId() != null) {
            formData.setLocalDistrict(String.valueOf(surveyUser.getDistrictId().getDistrictId()));
        } else {
            formData.setLocalDistrict("0");
        }

        if (surveyUser.getBlockId() != null) {
            formData.setLocalBlock(String.valueOf(surveyUser.getBlockId().getBlockId()));
        } else {
            formData.setLocalBlock("0");
        }

        if (surveyUser.getPanchayatId() != null) {
            formData.setLocalgp(String.valueOf(surveyUser.getPanchayatId().getPanchayatId()));
        } else {
            formData.setLocalgp("0");
        }

        formData.setVillageName(surveyUser.getVillageName());
        formData.setP_address(surveyUser.getPermanentAddress());
        List<FamilyMemberList> formFamilyData = new ArrayList<>();
        for (FamilyMembersEntity familyMember : surveyUser.getFamilyMembers()) {
            FamilyMemberList familyMemberForm = new FamilyMemberList();
            familyMemberForm.setName(familyMember.getName());
            familyMemberForm.setAge(familyMember.getAge() == 0 ? null
                    : String.valueOf(familyMember.getAge()));
            familyMemberForm.setGender(familyMember.getGenderId() == null ? "0"
                    : String.valueOf(familyMember.getGenderId().getGenderId()));
            familyMemberForm.setQualification(familyMember.getQualificationId() == null ? "0"
                    : String.valueOf(familyMember.getQualificationId().getQualificationId()));
            formFamilyData.add(familyMemberForm);
        }
        formData.setItemsForm(formFamilyData);

        SurveyAnimalHusbandryEntity animalHusbandryData = surveyUser.getSurveyAnimalHusbandryId();
        if (animalHusbandryData == null)
            return formData;

        formData.setGovernmentEmp(String.valueOf(animalHusbandryData.getGovtEmplFamilyNumber()));
        formData.setSelfEmp(String.valueOf(animalHusbandryData.getSelfEmplFamilyNumber()));
        formData.setOutsourcedEmp(String.valueOf(animalHusbandryData.getOutsourcedEmplFamilyNumber()));
        formData.setPmuEmp(String.valueOf(animalHusbandryData.getPmuEmplFamilyNumber()));
        formData.setPrivateEmp(String.valueOf(animalHusbandryData.getPrivateEmplFamilyNumber()));
        formData.setCowNum(String.valueOf(animalHusbandryData.getCows()));
        formData.setBuffaloNum(String.valueOf(animalHusbandryData.getBuffaloes()));
        formData.setOtherNum(String.valueOf(animalHusbandryData.getOtherAnimals()));
        formData.setTotalNum(String.valueOf(animalHusbandryData.getTotalAnimals()));
        formData.setCowMilkProduction(String.valueOf(animalHusbandryData.getCowMilkQuantity()));
        formData.setBuffaloMilkProduction(String.valueOf(animalHusbandryData.getBuffaloMilkQuantity()));
        formData.setHouseMilkProduction(String.valueOf(animalHusbandryData.getPersonalUseMilkQuantity()));
        formData.setMilkquantitySold(String.valueOf(animalHusbandryData.getMilkSoldQuantity()));
        formData.setMilkwheresold(animalHusbandryData.getMilkSoldTo());
        formData.setMilksellingprice(String.valueOf(animalHusbandryData.getSellingPrice()));
        formData.setWillingsellmilk(animalHusbandryData.isWillingToSell() ? "1" : "2");
        formData.setQyantitytosell(animalHusbandryData.isWillingToSell() ?
                String.valueOf(animalHusbandryData.getQuantityToSell()) : "");
        formData.setWillingtosell(animalHusbandryData.isCanIncreaseAnimal() ? "1" : "2");

        return formData;
    }

    //getSurveyUserAgricultureDetails
    @RequestMapping(value = Constants.getSurveyUserAgricultureData, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getSurveyUserAgricultureData(@RequestParam(value = Constants.userDetailRequestParam, required = true) String aadhaarNumber) throws Exception {
        Map<String, Object> map = null;

        try {
            Long aadhaar = Long.valueOf(aadhaarNumber);
            SurveyUserEntity surveyUser =
                    surveyUserRepository.getByAadhaarNumber(Long.valueOf(aadhaarNumber));

            map = new HashMap<String, Object>();
            if (surveyUser == null) {
                Optional<AadhaarApiResponse> apiResponse = getAadhaarData(aadhaar);
                if (apiResponse == null || !apiResponse.isPresent()
                        || (apiResponse.isPresent() && apiResponse.get().getStatus() == 404)
                        || (apiResponse.isPresent() && apiResponse.get().getRecords().isEmpty())) {
                    map.put(Constants.keyResponse, "SurveyUserNotFound");
                    map.put(Constants.keyMessage, "AadhaarDataNotFound");
                } else {
                    map.put(Constants.keyMessage, "AadhaarDataFound");
                    AadhaarData data = apiResponse.get().getRecords().get(0);
                    map.put(Constants.keyResponse, data);
                }
            } else {
                vendorAgriApplicationForm formData = populateSurveyUserAgricultureFormData(surveyUser);
                map.put(Constants.keyResponse, formData);
                map.put(Constants.keyMessage, Constants.valueMessage);
            }
            map.put(Constants.keyStatus, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    private vendorAgriApplicationForm populateSurveyUserAgricultureFormData(SurveyUserEntity surveyUser) {
        vendorAgriApplicationForm formData = new vendorAgriApplicationForm();
        formData.setAadhaarNumber(String.valueOf(surveyUser.getAadhaarNumber()));
        formData.setFirstname(surveyUser.getFirstName());
        formData.setLastname(surveyUser.getLastName());
        if (surveyUser.getGenderId() != null) {
            formData.setGender(String.valueOf(surveyUser.getGenderId().getGenderId()));
        } else {
            formData.setGender("0");
        }

        formData.setMobileNumber(String.valueOf(surveyUser.getMobileNumber()));
        formData.setAge(String.valueOf(surveyUser.getAge()));
        if (surveyUser.getCategoryId() != null) {
            formData.setCategory(String.valueOf(surveyUser.getCategoryId().getCategoryID()));
        } else {
            formData.setCategory("0");

        }

        formData.setFamilyHead(surveyUser.getFamilyHeadName());

        if (surveyUser.getCategoryId() != null) {
            formData.setCategory(String.valueOf(surveyUser.getCategoryId().getCategoryID()));
        } else {
            formData.setCategory("0");

        }

        if (surveyUser.getQualificationId() != null) {
            formData.setEducationalQualification(
                    String.valueOf(surveyUser.getQualificationId().getQualificationId()));
        } else {
            formData.setEducationalQualification("0");
        }

        if (surveyUser.getStateId() != null) {
            formData.setState(String.valueOf(surveyUser.getStateId().getStateID()));
        } else {
            formData.setState("0");
        }

        if (surveyUser.getDistrictId() != null) {
            formData.setLocalDistrict(String.valueOf(surveyUser.getDistrictId().getDistrictId()));
        } else {
            formData.setLocalDistrict("0");
        }

        if (surveyUser.getBlockId() != null) {
            formData.setLocalBlock(String.valueOf(surveyUser.getBlockId().getBlockId()));
        } else {
            formData.setLocalBlock("0");
        }

        if (surveyUser.getPanchayatId() != null) {
            formData.setLocalgp(String.valueOf(surveyUser.getPanchayatId().getPanchayatId()));
        } else {
            formData.setLocalgp("0");
        }

        formData.setVillageName(surveyUser.getVillageName());
        formData.setP_address(surveyUser.getPermanentAddress());
        List<FamilyMemberList> formFamilyData = new ArrayList<>();
        for (FamilyMembersEntity familyMember : surveyUser.getFamilyMembers()) {
            FamilyMemberList familyMemberForm = new FamilyMemberList();
            familyMemberForm.setName(familyMember.getName());
            familyMemberForm.setAge(familyMember.getAge() == 0 ? null
                    : String.valueOf(familyMember.getAge()));
            familyMemberForm.setGender(familyMember.getGenderId() == null ? "0"
                    : String.valueOf(familyMember.getGenderId().getGenderId()));
            familyMemberForm.setQualification(familyMember.getQualificationId() == null ? "0"
                    : String.valueOf(familyMember.getQualificationId().getQualificationId()));
            formFamilyData.add(familyMemberForm);
        }
        formData.setItemsForm(formFamilyData);


        SurveyAgricultureEntity surveyAgricultureData = surveyUser.getSurveyAgricultureId();
        if (surveyAgricultureData == null)
            return formData;
        List<CropDetails> cropdetailsForm = new ArrayList<>();
//Check if there are family members added and if added then add to surveyUser
        for (CropDetailEntity cropDetailEntity : surveyAgricultureData.getCropDetails()) {
            CropDetails cropDetail = new CropDetails();
            cropDetail.setCropArea(String.valueOf(cropDetailEntity.getCropArea()));
            cropDetail.setCropName(cropDetailEntity.getCropName());
            cropDetail.setCropMarketing(String.valueOf(cropDetailEntity.getCropMarketing()));
            cropDetail.setCropProduction(String.valueOf(cropDetailEntity.getCropProduction()));
            cropDetail.setCropType(cropDetailEntity.getCropTypeId() == null ? "0"
                    : String.valueOf(cropDetailEntity.getCropTypeId().getCropTypeId()));
            cropdetailsForm.add(cropDetail);
        }
        formData.setCropdetailsForm(cropdetailsForm);

        List<FutureCropDetails> formCropDetails = new ArrayList<>();
        for (FutureCropDetailEntity futureCropDetailEntity : surveyAgricultureData.getFutureCropDetails()) {
            FutureCropDetails futureCropDetail = new FutureCropDetails();
            futureCropDetail.setCropArea(String.valueOf(futureCropDetailEntity.getCropArea()));
            futureCropDetail.setCropName(futureCropDetailEntity.getCropName());
            futureCropDetail.setCropType(futureCropDetailEntity.getCropTypeId() == null ? "0"
                    : String.valueOf(futureCropDetailEntity.getCropTypeId().getCropTypeId()));
            formCropDetails.add(futureCropDetail);
        }
        formData.setFutureCropDetailsForm(formCropDetails);

        formData.setTotalLand(String.valueOf(surveyAgricultureData.getTotalLand()));
        formData.setCultivatedLand(String.valueOf(surveyAgricultureData.getCultivatedLand()));
        formData.setIrrigatedLand(String.valueOf(surveyAgricultureData.getIrrigatedLand()));
        formData.setNonIrrigatedLand(String.valueOf(surveyAgricultureData.getNonIrrigatedLand()));
        formData.setPresentIncome(String.valueOf(surveyAgricultureData.getPresentIncome()));
        formData.setMarketableSystem(surveyAgricultureData.getMarketableIncome());
        formData.setInfrareq(surveyAgricultureData.getInfraRequirements());
        formData.setTrainingAgri(surveyAgricultureData.getTrainingAgri());
        formData.setNaturalFarming(surveyAgricultureData.isNaturalFarming() ? "1" : "2");
        formData.setPmkisanbenifit(surveyAgricultureData.isPmkisanBenifit() ? "1" : "2");
        if (!surveyAgricultureData.isNaturalFarming())
            formData.setFullPartial("0");
        else if (surveyAgricultureData.isPartial())
            formData.setFullPartial("2");
        else
            formData.setFullPartial("1");
        return formData;
    }

    private Optional<AadhaarApiResponse> getAadhaarData(Long aadhaar) {
        try {
            TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

            SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();

            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLSocketFactory(csf)
                    .build();

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory();

            requestFactory.setHttpClient(httpClient);

            RestTemplate restTemplate = new RestTemplate(requestFactory);

            restTemplate.getInterceptors().add(
                    new BasicAuthenticationInterceptor("HIMPARIVAR@908@nT", "JovpQy2Cez6545sKDRvhX3p")
            );
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            LinkedMultiValueMap<String, Object> apiMap = new LinkedMultiValueMap<>();
            apiMap.add("aadhaar_no", aadhaar);
            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(apiMap, headers);


            ResponseEntity<AadhaarApiResponse> responseEntity =
                    restTemplate.postForEntity(uri, requestEntity, AadhaarApiResponse.class);
            HttpStatus statusCode = responseEntity.getStatusCode();
            if (statusCode != HttpStatus.OK)
                return null;
            AadhaarApiResponse apiResponse = responseEntity.getBody();
            return Optional.of(apiResponse);
        } catch (Exception ex) {
            return null;
        }

    }

    @RequestMapping(value = Constants.getAnimalHusbandryData, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getAnimalHusbandryData(@RequestParam(value = Constants.surveyDetailRequestParam, required = true) String aadhaarNumber) throws Exception {
        Map<String, Object> map = null;

        try {
            String data;
            map = new HashMap<String, Object>();
            SurveyUserEntity surveyUser =
                    surveyUserRepository.findById(Long.valueOf(aadhaarNumber)).orElse(null);
            if (surveyUser == null) {
                data = "<div>Invalid user id</div>";
                map.put(Constants.keyResponse, data);
            } else {

                StringBuilder userDataSB = populateUserData(surveyUser);
                StringBuilder animalHusbandrySB = populateAnimalHusbandryData(surveyUser);
                data = userDataSB.append(animalHusbandrySB).toString();
            }
            map.put(Constants.keyResponse, data);

            map.put(Constants.keyStatus, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    @RequestMapping(value = Constants.getAgricultureData, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getAgricultureData(@RequestParam(value = Constants.surveyDetailRequestParam, required = true) String aadhaarNumber) throws Exception {
        Map<String, Object> map = null;

        try {
            String data;
            map = new HashMap<String, Object>();
            SurveyUserEntity surveyUser =
                    surveyUserRepository.findById(Long.valueOf(aadhaarNumber)).orElse(null);
            if (surveyUser == null) {
                data = "<div>Invalid user id</div>";
                map.put(Constants.keyResponse, data);
            } else {
                StringBuilder userDataSB = populateUserData(surveyUser);
                StringBuilder agricultureDataSB = populateAgricultureData(surveyUser);
                data = userDataSB.append(agricultureDataSB).toString();
            }
            map.put(Constants.keyResponse, data);

            map.put(Constants.keyStatus, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    private StringBuilder populateUserData(SurveyUserEntity surveyUser) {
        StringBuilder sb = new StringBuilder();

        String data =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Survey User Details</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-4\">" +
                        "<label> Aadhaar Number: </label>\n" +
                        "<label>" + surveyUser.getAadhaarNumber() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-4\">" +
                        "<label> Full Name: </label>\n" +
                        "<label>" + surveyUser.getFirstName() + " " + surveyUser.getLastName() + "</label>\n" +
                        "</div>\n";
        sb.append(data);
        if (surveyUser.getGenderId() != null) {
            String genderData =
                    "<div class=\"col-lg-4\">\n" +
                            "<label> Gender: </label>\n" +
                            "<label>" + surveyUser.getGenderId().getGenderName() + "</label>\n" +
                            "</div>\n" +
                            "</div>\n";
            sb.append(genderData);
        }
        String data2 =
                "<div class=\"row\">\n" +
                        "<div class=\"col-lg-4\">\n" +
                        "<label> Mobile Number: </label>\n" +
                        "<label>" + surveyUser.getMobileNumber() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-4\">\n" +
                        "<label> Age: </label>\n" +
                        "<label>" + surveyUser.getAge() + "</label>\n" +
                        "</div>\n";
        sb.append(data2);

        if (surveyUser.getCategoryId() != null) {
            String categoryData =
                    "<div class=\"col-lg-4\">\n" +
                            "<label> Category: </label>\n" +
                            "<label>" + surveyUser.getCategoryId().getCategoryName() + "</label>\n" +
                            "</div>\n" +
                            "</div>\n";
            sb.append(categoryData);
        }

        String data3 =
                "<div class=\"row\">\n" +
                        "<div class=\"clearfix\"></div>\n" +
                        "<div class=\"col-md-6\">\n" +
                        "<label> Family Head Name: </label>\n" +
                        "<label>" + surveyUser.getFamilyHeadName() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"clearfix\"></div>\n";
        sb.append(data3);
        if (surveyUser.getQualificationId() != null) {
            String qualificationData =
                    "<div class=\"col-lg-6\">\n" +
                            "<label> Education Qualification: </label>\n" +
                            "<label>" + surveyUser.getQualificationId().getQualificationName() + "</label>\n" +
                            "</div>\n" +
                            "</div>\n";
            sb.append(qualificationData);
        }

        String userDataClose =
                "</div>\n" +
                        "<br><br>";
        sb.append(userDataClose);

        String addressData =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Survey User Address</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-4\">" +
                        "<label> State: </label>\n" +
                        "<label>" + surveyUser.getStateId().getStateName() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-4\">" +
                        "<label> District: </label>\n" +
                        "<label>" + surveyUser.getDistrictId().getDistrictName() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-4\">" +
                        "<label> Block: </label>\n" +
                        "<label>" + surveyUser.getBlockId().getBlockName() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-4\">" +
                        "<label> Panchayat/Ward: </label>\n" +
                        "<label>" + surveyUser.getPanchayatId().getPanchayatName() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-4\">" +
                        "<label> Village Name: </label>\n" +
                        "<label>" + surveyUser.getVillageName() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Permanent Address: </label>\n" +
                        "<label>" + surveyUser.getPermanentAddress() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(addressData);

        if (surveyUser.getFamilyMembers() != null && surveyUser.getFamilyMembers().stream().count() > 0) {
            String familyDetailData =
                    "<div class=\"timeline-post\">\n" +
                            "<h4>Survey User Family Details</h4>\n" +
                            "<hr>\n" +
                            "<table class=\"table table-bordered table-striped\">\n" +
                            "<thead>\n" +
                            "<tr>\n" +
                            "<th>Gender</th>\n" +
                            "<th>Name</th>\n" +
                            "<th>Age</th>\n" +
                            "<th>Qualification</th>\n" +
                            "</tr>\n" +
                            "</thead>\n" +
                            "<tbody>";
            sb.append(familyDetailData);
            for (FamilyMembersEntity familyMember : surveyUser.getFamilyMembers()) {
                String familyRowData =
                        "<tr>" +
                                "<td>" + (familyMember.getGenderId() != null ?
                                familyMember.getGenderId().getGenderName() : "") + "</td>" +
                                "<td>" + familyMember.getName() + "</td>" +
                                "<td>" + familyMember.getAge() + "</td>" +
                                "<td>" + (familyMember.getQualificationId() != null ?
                                familyMember.getQualificationId().getQualificationName() : "") + "</td>" +
                                "</tr>";
                sb.append(familyRowData);
            }

            String familyDataClose =
                    "</tbody>" +
                            "</table>" +
                            "</div>"+
                            "<br><br>";
            sb.append(familyDataClose);

        }
        return sb;
    }

    private StringBuilder populateAnimalHusbandryData(SurveyUserEntity surveyUser) {
        StringBuilder sb = new StringBuilder();

        SurveyAnimalHusbandryEntity animalHusbandryData = surveyUser.getSurveyAnimalHusbandryId();
        if (animalHusbandryData == null)
            return sb;

        String familyMemberEmploymentData =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Family Members Employment Data</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Government Employed: </label>\n" +
                        "<label>" + animalHusbandryData.getGovtEmplFamilyNumber() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Self Employed: </label>\n" +
                        "<label>" + animalHusbandryData.getSelfEmplFamilyNumber() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-2\">" +
                        "<label> Outsourced: </label>\n" +
                        "<label>" + animalHusbandryData.getOutsourcedEmplFamilyNumber() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-2\">" +
                        "<label> PSU: </label>\n" +
                        "<label>" + animalHusbandryData.getPmuEmplFamilyNumber() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-2\">" +
                        "<label> Private: </label>\n" +
                        "<label>" + animalHusbandryData.getPmuEmplFamilyNumber() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(familyMemberEmploymentData);

        String farmAnimalData =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Number of Animals Being Reared (Species Wise)</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Cow: </label>\n" +
                        "<label>" + animalHusbandryData.getCows() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Buffalo: </label>\n" +
                        "<label>" + animalHusbandryData.getBuffaloes() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Other: </label>\n" +
                        "<label>" + animalHusbandryData.getOtherAnimals() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Total: </label>\n" +
                        "<label>" + animalHusbandryData.getTotalAnimals() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(farmAnimalData);

        String farmMilkData =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Quantity of Milk being produced per day (per litre)</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Cow: </label>\n" +
                        "<label>" + animalHusbandryData.getCowMilkQuantity() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Buffalo: </label>\n" +
                        "<label>" + animalHusbandryData.getBuffaloMilkQuantity() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-6\">" +
                        "<label> Milk kept for personal use per day: </label>\n" +
                        "<label>" + animalHusbandryData.getPersonalUseMilkQuantity() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(farmMilkData);

        String farmSoldData =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Details of Milk being sold per day</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Quantity Being Sold (in Litres): </label>\n" +
                        "<label>" + animalHusbandryData.getMilkSoldQuantity() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Where Sold Local Market/ Milk fed: </label>\n" +
                        "<label>" + animalHusbandryData.getMilkSoldTo() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Milk Selling price (Rs. Per litre): </label>\n" +
                        "<label>" + animalHusbandryData.getSellingPrice() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(farmSoldData);

        String otherInformation =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Other Information</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Is willing to sell milk to HP milk Fed (If option is given): </label>\n" +
                        "<label>" + (animalHusbandryData.isWillingToSell() ? "Yes" : "No") + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> If yes, quantity (in Litres) available for selling: </label>\n" +
                        "<label>" + (animalHusbandryData.isWillingToSell() ? animalHusbandryData.getQuantityToSell() : "") + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Is having capacity/willing to increase no. of cows/buffaloed, if any assistance is provided by the Govt.: </label>\n" +
                        "<label>" + (animalHusbandryData.isCanIncreaseAnimal() ? "Yes" : "No") + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(otherInformation);
        return sb;
    }

    private StringBuilder populateAgricultureData(SurveyUserEntity surveyUser) {
        StringBuilder sb = new StringBuilder();

        SurveyAgricultureEntity surveyAgricultureData = surveyUser.getSurveyAgricultureId();
        if (surveyAgricultureData == null)
            return sb;

        String landDetailData =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Farmer Land Details(in Bigha)</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Total Land: </label>\n" +
                        "<label>" + surveyAgricultureData.getTotalLand() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Cultivated Land: </label>\n" +
                        "<label>" + surveyAgricultureData.getCultivatedLand() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Irrigated Land: </label>\n" +
                        "<label>" + surveyAgricultureData.getIrrigatedLand() + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-3\">" +
                        "<label> Non Irrigated Land: </label>\n" +
                        "<label>" + surveyAgricultureData.getNonIrrigatedLand() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(landDetailData);

        if (surveyAgricultureData.getCropDetails() != null
                && surveyAgricultureData.getCropDetails().stream().count() > 0) {
            String cropDetailData =
                    "<div class=\"timeline-post\">\n" +
                            "<h4>Present Crops Grown</h4>\n" +
                            "<hr>\n" +
                            "<table class=\"table table-bordered table-striped\">\n" +
                            "<thead>\n" +
                            "<tr>\n" +
                            "<th>Crop Type</th>\n" +
                            "<th>Crop Name</th>\n" +
                            "<th>Crop Area(Bigha)</th>\n" +
                            "<th>Production(quintal)</th>\n" +
                            "<th>Quantity for Marketing(quintal)</th>\n" +
                            "</tr>\n" +
                            "</thead>\n" +
                            "<tbody>";
            sb.append(cropDetailData);
            for (CropDetailEntity cropDetail : surveyAgricultureData.getCropDetails()) {
                String cropData =
                        "<tr>" +
                                "<td>" + (cropDetail.getCropTypeId() != null ?
                                cropDetail.getCropTypeId().getCropTypeName() : "") + "</td>" +
                                "<td>" + cropDetail.getCropName() + "</td>" +
                                "<td>" + cropDetail.getCropArea() + "</td>" +
                                "<td>" + cropDetail.getCropProduction() + "</td>" +
                                "<td>" + cropDetail.getCropMarketing() + "</td>" +
                                "</tr>";
                sb.append(cropData);
            }

            String cropDetailDataClose =
                    "</tbody>" +
                            "</table>" +
                            "</div>" +
                            "<br><br>";
            sb.append(cropDetailDataClose);

        }

        if (surveyAgricultureData.getFutureCropDetails() != null
                && surveyAgricultureData.getFutureCropDetails().stream().count() > 0) {
            String cropDetailData =
                    "<div class=\"timeline-post\">\n" +
                            "<h4>Present Crops Grown</h4>\n" +
                            "<hr>\n" +
                            "<table class=\"table table-bordered table-striped\">\n" +
                            "<thead>\n" +
                            "<tr>\n" +
                            "<th>Crop Type</th>\n" +
                            "<th>Crop Name</th>\n" +
                            "<th>Crop Area(Bigha)</th>\n" +
                            "</tr>\n" +
                            "</thead>\n" +
                            "<tbody>";
            sb.append(cropDetailData);
            for (FutureCropDetailEntity cropDetail : surveyAgricultureData.getFutureCropDetails()) {
                String cropData =
                        "<tr>" +
                                "<td>" + (cropDetail.getCropTypeId() != null ?
                                cropDetail.getCropTypeId().getCropTypeName() : "") + "</td>" +
                                "<td>" + cropDetail.getCropName() + "</td>" +
                                "<td>" + cropDetail.getCropArea() + "</td>" +
                                "</tr>";
                sb.append(cropData);
            }

            String cropDetailDataClose =
                    "</tbody>" +
                            "</table>" +
                            "</div>" +
                            "<br><br>";
            sb.append(cropDetailDataClose);

        }

        String otherInformation =
                "<div class=\"timeline-post\">\n" +
                        "<h4>Other Information</h4>\n" +
                        "<hr>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Present Agriculture Income: </label>\n" +
                        "<label>" + surveyAgricultureData.getPresentIncome() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Present Marketing System: </label>\n" +
                        "<label>" + surveyAgricultureData.getMarketableIncome() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Infrastructure required to increase agriculture income: </label>\n" +
                        "<label>" + surveyAgricultureData.getInfraRequirements() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> Whether attended any agriculture related training programme? (Please use comma , for entering different programme): </label>\n" +
                        "<label>" + surveyAgricultureData.getTrainingAgri() + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-6\">" +
                        "<label>Are you doing natural Farming?: </label>\n" +
                        "<label>" + (surveyAgricultureData.isNaturalFarming() ? "Yes" : "No") + "</label>\n" +
                        "</div>\n" +
                        "<div class=\"col-lg-6\">" +
                        "<label> If Yes (Full/Partial): </label>\n" +
                        "<label>" + (surveyAgricultureData.isNaturalFarming() ?
                        (surveyAgricultureData.isPartial() ? "Partial" : "Full") : "") + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">" +
                        "<label> whether benefited with Pradhan Mantri Kisan Samman Nidhi Scheme: </label>\n" +
                        "<label>" + (surveyAgricultureData.isPmkisanBenifit() ? "Yes" : "No") + "</label>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<br><br>";
        sb.append(otherInformation);
        return sb;
    }

    //getBlocks
    @RequestMapping(value = Constants.getBlocks, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getBlocks(@RequestParam(value = Constants.requestParam, required = true) String id) throws Exception {
        Map<String, Object> map = null;

        try {
            List<BlockModal> blockObjects = blockRepository.getBlocksViaDitricts(Integer.parseInt(id), true, false);
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, blockObjects);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    // Get Blocks Two
//    @RequestMapping(value = Constants.getBlocks, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
//    public @ResponseBody
//    ResponseEntity<?> getBlocksTwo(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {
//        Map<String, Object> map = null;
//
//        try{
//            List<BlocksEntity> blockObjects = blockRepository.getBlocksViaDitricts(Integer.parseInt(id));
//
//            if(!blockObjects.isEmpty()){
//                map = new HashMap<String, Object>();
//                map.put(Constants.keyResponse, blockObjects);
//                map.put(Constants.keyMessage, Constants.valueMessage);
//                map.put(Constants.keyStatus, HttpStatus.OK);
//                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//            }else{
//                map = new HashMap<String, Object>();
//                map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
//                map.put(Constants.keyMessage, Constants.valueMessage);
//                map.put(Constants.keyStatus, HttpStatus.OK);
//                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//            }
//
//
//        }catch(Exception ex){
//
//            map = new HashMap<String, Object>();
//            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
//            map.put(Constants.keyMessage, Constants.valueMessage);
//            map.put(Constants.keyStatus, HttpStatus.OK);
//            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//        }
//
//    }

    //getTehsils
    @RequestMapping(value = Constants.getTehsils, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getTehsils(@RequestParam(value = Constants.requestParam, required = true) String id) throws Exception {
        Map<String, Object> map = null;

        try {

            List<TehsilModal> TehsilObjects = tehsilRepository.getTehsils(Integer.parseInt(id));

            map = new HashMap<>();
            map.put(Constants.keyResponse, TehsilObjects);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;

        } catch (Exception ex) {
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    //getWardPanchayat
    @RequestMapping(value = Constants.getWardPanchayat, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getWardPanchayat(@RequestParam(value = Constants.requestParam, required = true) String id) throws Exception {


        Map<String, Object> map = null;

        try {
            List<GramPanchayatModal> gpObjects = gpRepository.getgpViaId(Integer.parseInt(id));
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, gpObjects);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }


    }


    //getNationality
    @RequestMapping(value = Constants.getNationality, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getNationality() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<NationalityModal> nationality = nationalityRepository.getNationalality();


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, nationality);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }


    //getNationalRegional
    @RequestMapping(value = Constants.getNationalRegional, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getNationalRegional() throws JsonProcessingException {
        Map<String, Object> map;
        List<NationalRegionalModal> nationalRegional = nationalRegionalRepository.getNationalRegional();
        map = new HashMap<>();
        map.put(Constants.keyResponse, nationalRegional);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //LandType
    //getNationalRegional
    @RequestMapping(value = Constants.getLandType, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getLandType() throws JsonProcessingException {
        Map<String, Object> map;
        List<LandTypeModal> landType = landTypeRepository.getLandType();
        map = new HashMap<>();
        map.put(Constants.keyResponse, landType);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //  return new ResponseEntity<>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    @RequestMapping(value = Constants.getrolesVendor, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getrolesVendor() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<RolesModal> roles = rolesRepository.getRoleVendor();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, roles);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //getVendor
    @RequestMapping(value = Constants.getVendor, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getVendor() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<CategoryModal> categories = vendorRepository.getCategories();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, categories);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //getVendor
    @RequestMapping(value = Constants.getCasteCategories, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getCasteCategory() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<CategoryModal> categories = casteCategoryRepository.getCategories();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, categories);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //getQualifications
    @RequestMapping(value = Constants.getQualifications, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getQualifications() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<QualificationModal> categories = qualificationRepository.getQualifications();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, categories);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }


    //getVendorCategory
    @RequestMapping(value = Constants.getVendorCategory, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getVendorCategory(@RequestParam(value = Constants.requestParam, required = true) String id) throws Exception {


        Map<String, Object> map = null;
        try {

            List<SubCategoryModal> vendorsCategorys = vendorTypeRepository.getSubCategories(Integer.parseInt(id));

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, vendorsCategorys);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    //getItemsviaSubCategories
    @RequestMapping(value = Constants.getItemsviaSubCategoriesTent, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getItemsviaSubCategories(

            @RequestParam(value = Constants.landType, required = true) String landType,
            @RequestParam(value = Constants.category, required = true) String category,
            @RequestParam(value = Constants.subCategory, required = true) String subCategory
    ) throws Exception {


        Map<String, Object> map = null;

        try {

            List<Items> items = subCategoryItemsRepository.getItemsSubCategory(

                    Integer.parseInt(landType),
                    Integer.parseInt(category),
                    Integer.parseInt(subCategory));


            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, items);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }


    }


    //getItemsviaSubCategoriesNR
    @RequestMapping(value = Constants.getItemsviaSubCategoriesNR, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getItemsviaSubCategoriesNR(
            @RequestParam(value = Constants.landType, required = true) String landType,
            @RequestParam(value = Constants.category, required = true) String category,
            @RequestParam(value = Constants.regional, required = true) String regional,
            @RequestParam(value = Constants.subCategory, required = true) String subCategory
    ) throws Exception {


        Map<String, Object> map;
        try {
            List<Items> items = subCategoryItemsRepository.getItemsSubCategoryNR(

                    Integer.parseInt(landType),
                    Integer.parseInt(category),
                    Integer.parseInt(regional),
                    Integer.parseInt(subCategory));


            map = new HashMap<>();
            map.put(Constants.keyResponse, items);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            // return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {
            map = new HashMap<>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }


    }

    // getItemsviaSubCategoriesNonTentNonRegional
    @RequestMapping(value = Constants.getItemsviaSubCategoriesNonTentNonRegional, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getItemsviaSubCategoriesNonTentNonRegional(
            @RequestParam(value = Constants.landType, required = true) String landType,
            @RequestParam(value = Constants.category, required = true) String category,
            @RequestParam(value = Constants.regional, required = true) String regional,
            @RequestParam(value = Constants.subCategory, required = true) String subCategory
    ) throws Exception {


        Map<String, Object> map = null;
        try {
            List<Items> items = subCategoryItemsRepository.getItemsSubCategoryOthers(
                    Integer.parseInt(landType),
                    Integer.parseInt(category),
                    Integer.parseInt(subCategory));

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, items);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        } catch (Exception ex) {
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //  return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }


    }

    //getDistrict
    @RequestMapping(value = Constants.getDistrict, method = RequestMethod.GET, produces = Constants.consumesProducesJson)
    public @ResponseBody
    String getDistrict() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<DistrictModal> districts = districtRepository.getDistricts(false, true);

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, districts);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }


}

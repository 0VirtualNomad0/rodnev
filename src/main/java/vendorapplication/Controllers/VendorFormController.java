package vendorapplication.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vendorapplication.entities.*;
import vendorapplication.form.vendorAgriApplicationForm;
import vendorapplication.form.vendorApplicationForm;
import vendorapplication.modal.CropDetails;
import vendorapplication.modal.FamilyMemberList;
import vendorapplication.modal.FutureCropDetails;
import vendorapplication.repositories.survey.*;
import vendorapplication.repositories.user.UserRepository;
import vendorapplication.services.SurveyUserService;
import vendorapplication.validators.SurveyAgricultureFormValidator;
import vendorapplication.validators.SurveyFormValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class VendorFormController {


    private static final Logger logger = LoggerFactory.getLogger(VendorFormController.class);
    @Autowired
    FamilyMembersRepository familyMembersRepository;
    @Autowired
    private SurveyFormValidator surveyFormValidator;
    @Autowired
    private SurveyAgricultureFormValidator surveyAgricultureFormValidator;
    @Autowired
    private SurveyUserService surveyUserService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurveyAgricultureRepository surveyAgricultureRepository;
    @Autowired
    private SurveyAnimalHusbandryRepository surveyAnimalHusbandryRepository;

    @Autowired
    private CropDetailRepository cropDetailRepository;
    @Autowired
    private FutureCropDetailRepository futureCropDetailRepository;
    public static int parseIntegerWithDefault(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static float parseFloatWithDefault(String number) {
        try {
            return Float.parseFloat(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static double parseDoubleWithDefault(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static long parseLongWithDefault(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            return 0l;
        }
    }

    @RequestMapping(value = "/vendorForm", method = RequestMethod.GET)
    public String createUser(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("successMessage", "");
        model.addAttribute("vendorApplicationForm", new vendorApplicationForm());
        return "vendorRegistration";
    }

    //vendorAgriForm
    @RequestMapping(value = "/vendorAgriForm", method = RequestMethod.GET)
    public String vendorAgriForm(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("successMessage", "");
        model.addAttribute("vendorAgriApplicationForm", new vendorAgriApplicationForm());
        return "vendorAgriRegistration";
    }

    @RequestMapping(value = "/saveapplication", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public String saveAnimalHusbandryForm(@ModelAttribute("vendorApplicationForm")
                                          vendorApplicationForm vendorForm,
                                          BindingResult bindingResult, Model model,
                                          HttpServletRequest request, HttpSession session,
                                          RedirectAttributes redirectAttributes) {
        surveyFormValidator.validate(vendorForm, bindingResult);
        logger.info("================================= Form Validated Successfully =================================");
        logger.info("\n");
        if (bindingResult.hasErrors()) {
            return "vendorRegistration";
        }
        try {
            System.out.println(vendorForm.toString());
            logger.info("Vendor Form:- " + vendorForm.toString());
            logger.info("\n");
            SurveyUserEntity surveyUser = new SurveyUserEntity();

            surveyUser = populateSurveyUserInfo(vendorForm);
            logger.info("User Data Form:- " + surveyUser.toString());

            if (surveyUser != null) {
                try {
                    System.out.println(surveyUser.toString());
                   addFamilyMembers(surveyUser, vendorForm);
                    SurveyAnimalHusbandryEntity animalHusbandryEntity =
                            populateAnimalHusbandrySurveyData(surveyUser, vendorForm);

                    if (animalHusbandryEntity == null) {
                        request.getSession().setAttribute("serverError", "Unable to save data. Please try again.");
                        return "vendorRegistration";
                    }
                    model.addAttribute("successMessage", "Survey submitted successfully");
                    model.addAttribute("vendorApplicationForm", new vendorApplicationForm());
                    return "vendorRegistration";

                } catch (Exception ex) {
                    request.getSession().setAttribute("serverError", ex.getLocalizedMessage());
                    return "vendorRegistration";
                }

            } else {
                request.getSession().setAttribute("serverError", "Unable to save the Data. Please try again");
                return "vendorRegistration";
            }
        } catch (Exception ex) {
            model.addAttribute("serverError", ex.toString());
            return "vendorRegistration";
        }

    }


    @RequestMapping(value = "/saveagriapplication", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public String saveForm(@ModelAttribute("vendorAgriApplicationForm") vendorAgriApplicationForm vendorAgriForm,
                           BindingResult bindingResult, Model model,
                           HttpServletRequest request, HttpSession session,
                           RedirectAttributes redirectAttributes) {
        surveyAgricultureFormValidator.validate(vendorAgriForm, bindingResult);
        logger.info("================================= Form Validated Successfully =================================");
        logger.info("\n");
        if (bindingResult.hasErrors()) {
            return "vendorAgriRegistration";
        }
        try {
            System.out.println(vendorAgriForm.toString());
            logger.info("Vendor Form:- " + vendorAgriForm.toString());
            logger.info("\n");
            SurveyUserEntity surveyUser = new SurveyUserEntity();

            surveyUser = populateSurveyUserInfo(vendorAgriForm);
            logger.info("User Data Form:- " + surveyUser.toString());

            if (surveyUser != null) {
                try {
                    System.out.println(surveyUser.toString());
                    addFamilyMembers(surveyUser, vendorAgriForm);
                    SurveyAgricultureEntity agricultureEntity =
                            populateAgriSurveyData(surveyUser, vendorAgriForm);

                    if (agricultureEntity == null) {
                        request.getSession().setAttribute("serverError", "Unable to save data. Please try again.");
                        return "vendorAgriRegistration";
                    }
                    model.addAttribute("successMessage", "Survey submitted successfully");
                    model.addAttribute("vendorAgriApplicationForm", new vendorAgriApplicationForm());
                    return "vendorAgriRegistration";

                } catch (Exception ex) {
                    request.getSession().setAttribute("serverError", ex.getLocalizedMessage());
                    return "vendorAgriRegistration";
                }

            } else {
                request.getSession().setAttribute("serverError", "Unable to save the Data. Please try again");
                return "vendorAgriRegistration";
            }
        } catch (Exception ex) {
            model.addAttribute("serverError", ex.toString());
            return "vendorAgriRegistration";
        }

    }

    //Survey User Details
    private SurveyUserEntity populateSurveyUserInfo(vendorApplicationForm vendorForm) {

        logger.info("========= Populating User Data From Form ========");
        logger.info("\n");
        SurveyUserEntity surveyUser =
                surveyUserService.getSurveyUserByAadhaarNumber(Long.valueOf(vendorForm.getAadhaarNumber()));
        if (surveyUser == null)
            surveyUser = new SurveyUserEntity();

        StateEntity state = new StateEntity();
        DistrictEntity district = new DistrictEntity();
        BlocksEntity block = new BlocksEntity();
        GPEntity grampanchayat = new GPEntity();
        GenderEntity gender = new GenderEntity();
        QualificationEntity qualification = new QualificationEntity();
        CategoryEntity category = new CategoryEntity();

        try {
            surveyUser.setAadhaarNumber(Long.valueOf(vendorForm.getAadhaarNumber()));
            logger.info("survey user aadhaar number:- " + surveyUser.getAadhaarNumber());
            logger.info("\n");

            surveyUser.setFirstName(vendorForm.getFirstname());
            logger.info("User First Name:- " + surveyUser.getFirstName());
            logger.info("\n");

            surveyUser.setLastName(vendorForm.getLastname());
            logger.info("User Last Name:- " + surveyUser.getLastName());
            logger.info("\n");

            if (parseIntegerWithDefault(vendorForm.getGender()) > 0) {
                gender.setGenderId(parseIntegerWithDefault(vendorForm.getGender()));
                surveyUser.setGenderId(gender);
                logger.info("User Gender :- " + surveyUser.getGenderId());
                logger.info("\n");
            }

            surveyUser.setMobileNumber(Long.valueOf(vendorForm.getMobileNumber()));
            logger.info("User Mobile Number:- " + surveyUser.getMobileNumber());
            logger.info("\n");

            surveyUser.setAge(parseIntegerWithDefault(vendorForm.getAge()));
            logger.info("User Age :- " + surveyUser.getAge());
            logger.info("\n");

            if (parseIntegerWithDefault(vendorForm.getCategory()) > 0) {
                category.setCategoryID(parseIntegerWithDefault(vendorForm.getCategory()));
                surveyUser.setCategoryId(category);
                logger.info("User category :- " + surveyUser.getCategoryId());
                logger.info("\n");
            }

            surveyUser.setFamilyHeadName(vendorForm.getFamilyHead());
            logger.info("User family head :- " + surveyUser.getFamilyHeadName());
            logger.info("\n");

            if (parseIntegerWithDefault(vendorForm.getEducationalQualification()) > 0) {
                qualification.setQualificationId(parseIntegerWithDefault(vendorForm.getEducationalQualification()));
                surveyUser.setQualificationId(qualification);
                logger.info("User qualifications :- " + surveyUser.getQualificationId());
                logger.info("\n");
            }

            if (parseIntegerWithDefault(vendorForm.getState()) > 0) {
                state.setStateID(parseIntegerWithDefault(vendorForm.getState()));
                surveyUser.setStateId(state);
                logger.info("User state :- " + surveyUser.getStateId());
                logger.info("\n");
            }

            if (parseIntegerWithDefault(vendorForm.getLocalDistrict()) > 0) {
                district.setDistrictId(parseIntegerWithDefault(vendorForm.getLocalDistrict()));
                surveyUser.setDistrictId(district);
                logger.info("User qualifications :- " + surveyUser.getQualificationId());
                logger.info("\n");
            }

            if (vendorForm.getLocalBlock() != null && parseIntegerWithDefault(vendorForm.getLocalBlock()) > 0) {
                block.setBlockId(parseIntegerWithDefault(vendorForm.getLocalBlock()));
                surveyUser.setBlockId(block);
                logger.info("User block :- " + surveyUser.getBlockId());
                logger.info("\n");
            }

            if (vendorForm.getLocalgp() != null && parseIntegerWithDefault(vendorForm.getLocalgp()) > 0) {
                grampanchayat.setPanchayatId(parseIntegerWithDefault(vendorForm.getLocalgp()));
                surveyUser.setPanchayatId(grampanchayat);
            }

            surveyUser.setVillageName(vendorForm.getVillageName());
            logger.info("User Village :- " + surveyUser.getVillageName());
            logger.info("\n");

            surveyUser.setPermanentAddress(vendorForm.getP_address());
            logger.info("User address :- " + surveyUser.getPermanentAddress());
            logger.info("\n");


            surveyUser = surveyUserService.saveSurveyUser(surveyUser);

        } catch (Exception ex) {
            logger.info("========== Error While Populating User Data ==========");
            logger.info(ex.toString());
            logger.info(ex.getLocalizedMessage());
            surveyUser = null;
        }
        logger.info(surveyUser.toString());
        return surveyUser;
    }

    private SurveyUserEntity populateSurveyUserInfo(vendorAgriApplicationForm vendorForm) {

        logger.info("========= Populating User Data From Form ========");
        logger.info("\n");

        SurveyUserEntity surveyUser =
                surveyUserService.getSurveyUserByAadhaarNumber(Long.valueOf(vendorForm.getAadhaarNumber()));
        if (surveyUser == null)
            surveyUser = new SurveyUserEntity();
        StateEntity state = new StateEntity();
        DistrictEntity district = new DistrictEntity();
        BlocksEntity block = new BlocksEntity();
        GPEntity grampanchayat = new GPEntity();
        GenderEntity gender = new GenderEntity();
        QualificationEntity qualification = new QualificationEntity();
        CategoryEntity category = new CategoryEntity();

        try {
            surveyUser.setAadhaarNumber(Long.valueOf(vendorForm.getAadhaarNumber()));
            logger.info("survey user aadhaar number:- " + surveyUser.getAadhaarNumber());
            logger.info("\n");

            surveyUser.setFirstName(vendorForm.getFirstname());
            logger.info("User First Name:- " + surveyUser.getFirstName());
            logger.info("\n");

            surveyUser.setLastName(vendorForm.getLastname());
            logger.info("User Last Name:- " + surveyUser.getLastName());
            logger.info("\n");

            if (parseIntegerWithDefault(vendorForm.getGender()) > 0) {
                gender.setGenderId(parseIntegerWithDefault(vendorForm.getGender()));
                surveyUser.setGenderId(gender);
                logger.info("User Gender :- " + surveyUser.getGenderId());
                logger.info("\n");
            }

            surveyUser.setMobileNumber(Long.valueOf(vendorForm.getMobileNumber()));
            logger.info("User Mobile Number:- " + surveyUser.getMobileNumber());
            logger.info("\n");

            surveyUser.setAge(parseIntegerWithDefault(vendorForm.getAge()));
            logger.info("User Age :- " + surveyUser.getAge());
            logger.info("\n");

            if (parseIntegerWithDefault(vendorForm.getCategory()) > 0) {
                category.setCategoryID(parseIntegerWithDefault(vendorForm.getCategory()));
                surveyUser.setCategoryId(category);
                logger.info("User category :- " + surveyUser.getCategoryId());
                logger.info("\n");
            }

            surveyUser.setFamilyHeadName(vendorForm.getFamilyHead());
            logger.info("User family head :- " + surveyUser.getFamilyHeadName());
            logger.info("\n");

            if (parseIntegerWithDefault(vendorForm.getEducationalQualification()) > 0) {
                qualification.setQualificationId(parseIntegerWithDefault(vendorForm.getEducationalQualification()));
                surveyUser.setQualificationId(qualification);
                logger.info("User qualifications :- " + surveyUser.getQualificationId());
                logger.info("\n");
            }

            if (parseIntegerWithDefault(vendorForm.getState()) > 0) {
                state.setStateID(parseIntegerWithDefault(vendorForm.getState()));
                surveyUser.setStateId(state);
                logger.info("User state :- " + surveyUser.getStateId());
                logger.info("\n");
            }

            if (parseIntegerWithDefault(vendorForm.getLocalDistrict()) > 0) {
                district.setDistrictId(parseIntegerWithDefault(vendorForm.getLocalDistrict()));
                surveyUser.setDistrictId(district);
                logger.info("User qualifications :- " + surveyUser.getQualificationId());
                logger.info("\n");
            }

            if (vendorForm.getLocalBlock() != null && parseIntegerWithDefault(vendorForm.getLocalBlock()) > 0) {
                block.setBlockId(parseIntegerWithDefault(vendorForm.getLocalBlock()));
                surveyUser.setBlockId(block);
                logger.info("User block :- " + surveyUser.getBlockId());
                logger.info("\n");
            }

            if (vendorForm.getLocalgp() != null && parseIntegerWithDefault(vendorForm.getLocalgp()) > 0) {
                grampanchayat.setPanchayatId(parseIntegerWithDefault(vendorForm.getLocalgp()));
                surveyUser.setPanchayatId(grampanchayat);
            }

            surveyUser.setVillageName(vendorForm.getVillageName());
            logger.info("User Village :- " + surveyUser.getVillageName());
            logger.info("\n");

            surveyUser.setPermanentAddress(vendorForm.getP_address());
            logger.info("User address :- " + surveyUser.getPermanentAddress());
            logger.info("\n");

            //Check if there are family members added and if added then add to surveyUser
            Set<FamilyMembersEntity> familyMembers = new HashSet<FamilyMembersEntity>();
            for (FamilyMemberList familyMember : vendorForm.getItemsForm()) {
                FamilyMembersEntity familyMembersEntity = new FamilyMembersEntity();
                familyMembersEntity.setName(familyMember.getName());
                if (familyMember.getAge() != null && !familyMember.getAge().isEmpty()) {
                    familyMembersEntity.setAge(parseIntegerWithDefault(familyMember.getAge()));
                }

                if (parseIntegerWithDefault(familyMember.getQualification()) > 0) {
                    QualificationEntity familyQualification = new QualificationEntity();
                    familyQualification.setQualificationId(parseIntegerWithDefault(familyMember.getQualification()));
                    familyMembersEntity.setQualificationId(familyQualification);
                }

                if (parseIntegerWithDefault(familyMember.getGender()) > 0) {
                    GenderEntity familyMemberGender = new GenderEntity();
                    familyMemberGender.setGenderId(parseIntegerWithDefault(familyMember.getGender()));
                    familyMembersEntity.setGenderId(familyMemberGender);
                }
                familyMembersEntity.setSurveyUserId(surveyUser);
                familyMembers.add(familyMembersEntity);
            }
            surveyUser.setFamilyMembers(familyMembers);

            surveyUser = surveyUserService.saveSurveyUser(surveyUser);

        } catch (Exception ex) {
            logger.info("========== Error While Populating User Data ==========");
            logger.info(ex.toString());
            logger.info(ex.getLocalizedMessage());
            surveyUser = null;
        }
        logger.info(surveyUser.toString());
        return surveyUser;
    }
    // Application Details

    private SurveyAnimalHusbandryEntity populateAnimalHusbandrySurveyData(SurveyUserEntity surveyUser, vendorApplicationForm vendorForm) {
        SurveyAnimalHusbandryEntity animalHusbandryEntity = surveyUser.getSurveyAnimalHusbandryId();
        if (animalHusbandryEntity == null)
            animalHusbandryEntity = new SurveyAnimalHusbandryEntity();
        animalHusbandryEntity.setSurveyUserId(surveyUser);
        animalHusbandryEntity.setGovtEmplFamilyNumber(parseIntegerWithDefault(vendorForm.getGovernmentEmp()));
        animalHusbandryEntity.setSelfEmplFamilyNumber(parseIntegerWithDefault(vendorForm.getSelfEmp()));
        animalHusbandryEntity.setOutsourcedEmplFamilyNumber(parseIntegerWithDefault(vendorForm.getOutsourcedEmp()));
        animalHusbandryEntity.setPmuEmplFamilyNumber(parseIntegerWithDefault(vendorForm.getPmuEmp()));
        animalHusbandryEntity.setPrivateEmplFamilyNumber(parseIntegerWithDefault(vendorForm.getPrivateEmp()));
        animalHusbandryEntity.setCows(parseIntegerWithDefault(vendorForm.getCowNum()));
        animalHusbandryEntity.setBuffaloes(parseIntegerWithDefault(vendorForm.getBuffaloNum()));
        animalHusbandryEntity.setOtherAnimals(parseIntegerWithDefault(vendorForm.getOtherNum()));
        animalHusbandryEntity.setTotalAnimals(parseIntegerWithDefault(vendorForm.getTotalNum()));
        animalHusbandryEntity.setCowMilkQuantity(parseFloatWithDefault(vendorForm.getCowMilkProduction()));
        animalHusbandryEntity.setBuffaloMilkQuantity(parseFloatWithDefault(vendorForm.getBuffaloMilkProduction()));
        animalHusbandryEntity.setPersonalUseMilkQuantity(
                parseFloatWithDefault(vendorForm.getHouseMilkProduction()));
        animalHusbandryEntity.setMilkSoldQuantity(parseFloatWithDefault(vendorForm.getMilkquantitySold()));
        animalHusbandryEntity.setMilkSoldTo(vendorForm.getMilkwheresold());
        animalHusbandryEntity.setSellingPrice(parseFloatWithDefault(vendorForm.getMilksellingprice()));
        if (parseIntegerWithDefault(vendorForm.getWillingsellmilk()) == 1) {
            animalHusbandryEntity.setWillingToSell(true);
            animalHusbandryEntity.setQuantityToSell(parseFloatWithDefault(vendorForm.getQyantitytosell()));
        } else if (parseIntegerWithDefault(vendorForm.getWillingsellmilk()) == 2) {
            animalHusbandryEntity.setWillingToSell(false);
            animalHusbandryEntity.setQuantityToSell(0);

        }

        if (parseIntegerWithDefault(vendorForm.getWillingtosell()) > 0) {
            animalHusbandryEntity.setCanIncreaseAnimal(parseIntegerWithDefault(vendorForm.getWillingtosell()) == 1);
        }

        animalHusbandryEntity =
                surveyUserService.saveAnimalHusbandrySurvey(animalHusbandryEntity);

        return animalHusbandryEntity;

    }

    private SurveyAgricultureEntity populateAgriSurveyData(SurveyUserEntity surveyUser,
                                                           vendorAgriApplicationForm vendorAgriForm) {
        SurveyAgricultureEntity surveyAgricultureEntity = surveyUser.getSurveyAgricultureId();
        if (surveyAgricultureEntity == null)
            surveyAgricultureEntity = new SurveyAgricultureEntity();

        surveyAgricultureEntity.setSurveyUserId(surveyUser);
        surveyAgricultureEntity.setTotalLand(parseFloatWithDefault(vendorAgriForm.getTotalLand()));
        surveyAgricultureEntity.setCultivatedLand(parseFloatWithDefault(vendorAgriForm.getCultivatedLand()));
        surveyAgricultureEntity.setIrrigatedLand(parseFloatWithDefault(vendorAgriForm.getIrrigatedLand()));
        surveyAgricultureEntity.setNonIrrigatedLand(parseFloatWithDefault(vendorAgriForm.getNonIrrigatedLand()));
        surveyAgricultureEntity.setPresentIncome(parseDoubleWithDefault(vendorAgriForm.getPresentIncome()));
        surveyAgricultureEntity.setMarketableIncome(vendorAgriForm.getMarketableSystem());
        surveyAgricultureEntity.setInfraRequirements(vendorAgriForm.getInfrareq());
        surveyAgricultureEntity.setTrainingAgri(vendorAgriForm.getTrainingAgri());
        if (parseIntegerWithDefault(vendorAgriForm.getNaturalFarming()) > 0) {
            surveyAgricultureEntity.setNaturalFarming(
                    parseIntegerWithDefault(vendorAgriForm.getNaturalFarming()) == 1);
        }
        if (parseIntegerWithDefault(vendorAgriForm.getPmkisanbenifit()) > 0) {
            surveyAgricultureEntity.setPmkisanBenifit(
                    parseIntegerWithDefault(vendorAgriForm.getPmkisanbenifit()) == 1);
        }
        if (parseIntegerWithDefault(vendorAgriForm.getNaturalFarming()) == 1
                && parseIntegerWithDefault(vendorAgriForm.getFullPartial()) > 0) {
            surveyAgricultureEntity.setPartial(
                    parseIntegerWithDefault(vendorAgriForm.getFullPartial()) == 2);
        }

        surveyAgricultureEntity =
                surveyUserService.saveAgricultureSurvey(surveyAgricultureEntity);
        if(surveyAgricultureEntity.getCropDetails() != null) {
            cropDetailRepository.deleteAll(surveyAgricultureEntity.getCropDetails());
            surveyAgricultureEntity.getCropDetails().removeAll(surveyAgricultureEntity.getCropDetails());
        }

        List<CropDetailEntity> cropDetails = new ArrayList<>();
        for (CropDetails cropDetail : vendorAgriForm.getCropdetailsForm()) {
            CropDetailEntity cropDetailEntity = new CropDetailEntity();
            cropDetailEntity.setCropArea(parseFloatWithDefault(cropDetail.getCropArea()));
            cropDetailEntity.setCropName(cropDetail.getCropName());
            cropDetailEntity.setCropMarketing(parseFloatWithDefault(cropDetail.getCropMarketing()));
            cropDetailEntity.setCropProduction(parseFloatWithDefault(cropDetail.getCropProduction()));

            if (parseIntegerWithDefault(cropDetail.getCropType()) > 0) {
                CropTypeEntity cropType = new CropTypeEntity();
                cropType.setCropTypeId(parseIntegerWithDefault(cropDetail.getCropType()));
                cropDetailEntity.setCropTypeId(cropType);
            }
            cropDetailEntity.setSurveyAgricultureId(surveyAgricultureEntity);
            cropDetails.add(cropDetailEntity);
        }
        cropDetailRepository.saveAll(cropDetails);

        if(surveyAgricultureEntity.getFutureCropDetails() != null) {
            futureCropDetailRepository.deleteAll(surveyAgricultureEntity.getFutureCropDetails());
            surveyAgricultureEntity.getFutureCropDetails().removeAll(
                    surveyAgricultureEntity.getFutureCropDetails());
        }

        List<FutureCropDetailEntity> futureCropDetails = new ArrayList<>();
        for (FutureCropDetails cropDetail : vendorAgriForm.getFutureCropDetailsForm()) {
            FutureCropDetailEntity cropDetailEntity = new FutureCropDetailEntity();
            cropDetailEntity.setCropArea(parseFloatWithDefault(cropDetail.getCropArea()));
            cropDetailEntity.setCropName(cropDetail.getCropName());

            if (parseIntegerWithDefault(cropDetail.getCropType()) > 0) {
                CropTypeEntity cropType = new CropTypeEntity();
                cropType.setCropTypeId(parseIntegerWithDefault(cropDetail.getCropType()));
                cropDetailEntity.setCropTypeId(cropType);
            }
            cropDetailEntity.setSurveyAgricultureId(surveyAgricultureEntity);
            futureCropDetails.add(cropDetailEntity);
        }
        futureCropDetailRepository.saveAll(futureCropDetails);

        return surveyAgricultureEntity;
    }

    private void addFamilyMembers(SurveyUserEntity surveyUser, vendorApplicationForm vendorForm) {
        List<FamilyMembersEntity> existingFamilyMembers =
                familyMembersRepository.findAllBySurveyUserId_surveyUserId(surveyUser.getSurveyUserId());
        if (existingFamilyMembers != null)
            familyMembersRepository.deleteAll(existingFamilyMembers);
        surveyUser.getFamilyMembers().removeAll(surveyUser.getFamilyMembers());
        Set<FamilyMembersEntity> familyMembers = new HashSet<FamilyMembersEntity>();
        for (FamilyMemberList familyMember : vendorForm.getItemsForm()) {
            FamilyMembersEntity familyMembersEntity = new FamilyMembersEntity();
            familyMembersEntity.setName(familyMember.getName());

            if (familyMember.getAge() != null && !familyMember.getAge().isEmpty()) {
                familyMembersEntity.setAge(parseIntegerWithDefault(familyMember.getAge()));
            }

            if (parseIntegerWithDefault(familyMember.getQualification()) > 0) {
                QualificationEntity familyQualification = new QualificationEntity();
                familyQualification.setQualificationId(parseIntegerWithDefault(familyMember.getQualification()));
                familyMembersEntity.setQualificationId(familyQualification);
            }

            if (parseIntegerWithDefault(familyMember.getGender()) > 0) {
                GenderEntity familyMemberGender = new GenderEntity();
                familyMemberGender.setGenderId(parseIntegerWithDefault(familyMember.getGender()));
                familyMembersEntity.setGenderId(familyMemberGender);
            }
            familyMembersEntity.setSurveyUserId(surveyUser);
            familyMembers.add(familyMembersEntity);
        }
        familyMembersRepository.saveAll(familyMembers);
    }

    private void addFamilyMembers(SurveyUserEntity surveyUser, vendorAgriApplicationForm vendorForm) {
        List<FamilyMembersEntity> existingFamilyMembers =
                familyMembersRepository.findAllBySurveyUserId_surveyUserId(surveyUser.getSurveyUserId());
        if (existingFamilyMembers != null)
            familyMembersRepository.deleteAll(existingFamilyMembers);
        surveyUser.getFamilyMembers().removeAll(surveyUser.getFamilyMembers());
        Set<FamilyMembersEntity> familyMembers = new HashSet<FamilyMembersEntity>();
        for (FamilyMemberList familyMember : vendorForm.getItemsForm()) {
            FamilyMembersEntity familyMembersEntity = new FamilyMembersEntity();
            familyMembersEntity.setName(familyMember.getName());

            if (familyMember.getAge() != null && !familyMember.getAge().isEmpty()) {
                familyMembersEntity.setAge(parseIntegerWithDefault(familyMember.getAge()));
            }

            if (parseIntegerWithDefault(familyMember.getQualification()) > 0) {
                QualificationEntity familyQualification = new QualificationEntity();
                familyQualification.setQualificationId(parseIntegerWithDefault(familyMember.getQualification()));
                familyMembersEntity.setQualificationId(familyQualification);
            }

            if (parseIntegerWithDefault(familyMember.getGender()) > 0) {
                GenderEntity familyMemberGender = new GenderEntity();
                familyMemberGender.setGenderId(parseIntegerWithDefault(familyMember.getGender()));
                familyMembersEntity.setGenderId(familyMemberGender);
            }
            familyMembersEntity.setSurveyUserId(surveyUser);
            familyMembers.add(familyMembersEntity);
        }
        familyMembersRepository.saveAll(familyMembers);
    }

}

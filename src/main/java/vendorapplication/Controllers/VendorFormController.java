package vendorapplication.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vendorapplication.entities.*;
import vendorapplication.form.vendorAgriApplicationForm;
import vendorapplication.form.vendorApplicationForm;
import vendorapplication.modal.ApplicationsViaLocations;
import vendorapplication.modal.LoggedInUserLocationSession;
import vendorapplication.services.*;
import vendorapplication.utilities.Constants;
import vendorapplication.validators.VendorApplicationFormValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

@Controller
public class VendorFormController {


    private static final Logger logger = LoggerFactory.getLogger(VendorFormController.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    UserAppItemsService availedServices;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private VendorApplicationFormValidator vendorApplicationFormValidator;

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

    //vendorForm
    @RequestMapping(value = "/vendorIndex", method = RequestMethod.GET)
    public String vendorIndex(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("successMessage", "");
        System.out.println(request.getSession().getAttribute("UserData"));
        String authority_ = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();

            UserEntity user = userService.getUserDetailsViaUsername(username);
            System.out.println((user.getUserId()).intValue());

            if (user != null) {

                //Set Session UserID
                request.getSession().setAttribute("user_Id", user.getUserId());
                request.getSession().setAttribute("user_Name_First", user.getFirstName());
                request.getSession().setAttribute("user_Name_LAst", user.getLastName());
                request.getSession().setAttribute("user_Name_LAst", user.getUsername());
                request.getSession().setAttribute("user_age", user.getAge());
                request.getSession().setAttribute("Mobile_Number", user.getMobileNumber());
                request.getSession().setAttribute("gender", user.getGenderID().getGenderName());
                request.getSession().setAttribute("address", user.getpAddress());



                return "vendorIndex";
            } else {
                return "errorPage";
            }


        }

    }

    //bdo_dfo
    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String applications(Model model, HttpServletRequest request, HttpSession session) {
        request.getSession().setAttribute("successMessage", "");

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

            for (GrantedAuthority authority : authorities) {
                authority_ = authority.getAuthority().toString();
                System.out.println(authority.getAuthority().toString());
            }

            LoggedInUserLocationSession user = (LoggedInUserLocationSession) request.getSession().getAttribute("UserData");
            System.out.println(user.toString());

            if (user != null) {


                List<Object[]> dashboardDataServerList = null;
                if(authority_.equalsIgnoreCase("PCB")){
                    dashboardDataServerList = userApplicationService.getApplicationsLocationWisePcb(user.getStateId(),user.getDistrictId(),2);

                }else{
                    dashboardDataServerList =  userApplicationService.getApplicationsLocationWise(user.getStateId(),user.getDistrictId());

                }

                List<ApplicationsViaLocations> applications = new ArrayList<>();
                for (Object[] result : dashboardDataServerList) {
                    ApplicationsViaLocations pojo = new ApplicationsViaLocations();
                    pojo.setApp_id((Integer) result[0]);
                    pojo.setFirstName((String) result[1]);
                    pojo.setLastName((String) result[2]);
                    pojo.setMobileNumber((BigInteger) result[3]);
                    pojo.setCategory((String) result[4]);
                    pojo.setSubCategory((String) result[5]);
                    pojo.setUser_id((Integer) result[6]);
                    pojo.setApplication_status((String) result[7]);
                    applications.add(pojo);
                }

                model.addAttribute("userApplications", applications);

                return "applications_list";
            } else {
                return "errorPage";
            }


        }

    }

    @RequestMapping(value = "/saveapplication", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public String saveForm(@ModelAttribute("vendorApplicationForm") vendorApplicationForm vendorForm,
                           BindingResult bindingResult, Model model,
                           HttpServletRequest request, HttpSession session,
                           RedirectAttributes redirectAttributes) {


        String captcha = (String) session.getAttribute("CAPTCHA");
        if (captcha == null || (captcha != null && !captcha.equals(vendorForm.getCaptcha()))) {
            vendorForm.setCaptcha("");
            model.addAttribute("serverError", "Captcha Mismatch");
            return "vendorRegistration";
        } else {
            vendorApplicationFormValidator.validate(vendorForm, bindingResult);
            logger.info("================================= Form Validated Successfully =================================");
            logger.info("\n");
            if (bindingResult.hasErrors()) {
                return "vendorRegistration";
            }
            try {
                System.out.println(vendorForm.toString());
                logger.info("Vendor Form:- " +vendorForm.toString());
                logger.info("\n");
                UserEntity user = new UserEntity();
                UserApplicationEntity userApplication = new UserApplicationEntity();

                user = populateBean(vendorForm);
                logger.info("User Data Form:- " +user.toString());

                if (user != null) {

                    try {
                        System.out.println(user.toString());
                        userApplication = populateApplicationData(user, vendorForm);

                        if (userApplication != null) {
                            //Save Category Details Here
                            System.out.println(userApplication.toString());
                            //Save the Items Table if Available
                            if (vendorForm.getVendorType().equalsIgnoreCase("2")) {
                                //Check if there is value or not inside the list Save Tent ITems
                                List<UserAppItemsEntity> items = new ArrayList<>();
                                UserAppItemsEntity datax = null;
                                SubCategoryItemsEntity subCategoryItemsEntity = null;
                                for (int i = 0; i < vendorForm.getItemsForm().size(); i++) {
                                    datax = new UserAppItemsEntity();
                                    subCategoryItemsEntity = new SubCategoryItemsEntity();


//                                    if (!vendorForm.getItemsForm().get(i).getItem_number().equalsIgnoreCase("")
//                                            && vendorForm.getItemsForm().get(i).getItem_number() != null) {
//
//                                        datax.setTentNumber(Integer.parseInt(vendorForm.getItemsForm().get(i).getItem_number()));
//                                        subCategoryItemsEntity.setItemId(Integer.parseInt(vendorForm.getItemsForm().get(i).getItem()));
//                                        datax.setItem(subCategoryItemsEntity);
//                                        datax.setAppId(userApplication.getAppId());
//
//                                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//                                        Date date = new Date(timestamp.getTime());
//
//                                        datax.setCreateddate(date);
//                                        datax.setActive(true);
//                                        items.add(datax);
//
//                                    }
                                }
                                availedServices.saveData(items);
                                request.getSession().setAttribute("appId", userApplication.getAppId());
                                // redirectAttributes.addFlashAttribute("appId", userApplication.getAppId());
                                return "redirect:/paymentpage";


                            } else {

                                //Save Non Tent Items
                                UserAppItemsEntity datax = new UserAppItemsEntity();
                                SubCategoryItemsEntity subCategoryItemsEntity = new SubCategoryItemsEntity();

                                datax.setTentNumber(Integer.parseInt("0"));
                                subCategoryItemsEntity.setItemId(Integer.parseInt(vendorForm.getItem()));
                                datax.setItem(subCategoryItemsEntity);
                                datax.setAppId(userApplication.getAppId());

                                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                                Date date = new Date(timestamp.getTime());

                                datax.setCreateddate(date);
                                datax.setActive(true);

                                availedServices.saveDataSingle(datax);
                                request.getSession().setAttribute("successMessage", userApplication.getAppId());
                                request.getSession().setAttribute("appId", userApplication.getAppId());
                               // redirectAttributes.addFlashAttribute("appId", userApplication.getAppId());
                                return "redirect:/paymentpage";
                               // return "vendorRegistration";
                            }


                            // redirectAttributes.addFlashAttribute("appId", savedData.getAppId());
                            //  return "redirect:/paymentpage";
                        } else {
                            request.getSession().setAttribute("serverError", "Unable to save data. Please try again.");
                            return "vendorRegistration";
                        }
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

    }


    // Application Details
    private UserApplicationEntity populateApplicationData(UserEntity user, vendorApplicationForm vendorForm) {
        logger.info("Inside Populate Function Add Application");
        UserApplicationEntity applicationData = new UserApplicationEntity();

        try {

            StateEntity state = new StateEntity();
            DistrictEntity district = new DistrictEntity();
            BlocksEntity block = new BlocksEntity();
            TehsilEntity tehsil = new TehsilEntity();
            GPEntity grampanchayat = new GPEntity();
            NationalityEntity nationality = new NationalityEntity();
            CategoryEntity categoryEntity = new CategoryEntity();
            SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
            LandTypeEntity landTypeEntity = new LandTypeEntity();

            applicationData.setUserId(user);
            state.setStateID(Integer.parseInt(vendorForm.getVstate()));
            applicationData.setState(state);
            district.setDistrictId(Integer.parseInt(vendorForm.getVlocalDistrict()));
            applicationData.setDistrict(district);
            block.setDistrictId(Integer.parseInt(vendorForm.getVlocalBlock()));
            applicationData.setBlock(block);
            tehsil.setDistrictId(Integer.parseInt(vendorForm.getVlocalTehsil()));
            applicationData.setTehsil(tehsil);
            grampanchayat.setPanchayatId(Integer.parseInt(vendorForm.getVlocalgp()));
            applicationData.setPanchayat(grampanchayat);

            applicationData.setVendingAddress(vendorForm.getLoc_address());
            applicationData.setFromDate(vendorForm.getFromDate());
            applicationData.setTo_date(vendorForm.getToDate());
            applicationData.setTotalDays(Integer.parseInt(vendorForm.getTotalDays()));

            nationality.setNationalityId(Integer.parseInt(vendorForm.getNationality()));
            applicationData.setNationalityEntity(nationality);
            landTypeEntity.setLandTypeId(Integer.parseInt(vendorForm.getLandType()));
            applicationData.setPurposeActivity(landTypeEntity);
            categoryEntity.setCategoryID(Integer.parseInt(vendorForm.getVendor()));
            applicationData.setCategory(categoryEntity);
            subCategoryEntity.setSubCategoryId(Integer.parseInt(vendorForm.getVendorType()));
            applicationData.setSubcategory(subCategoryEntity);

            if(vendorForm.getNumberItems().isEmpty()){
                applicationData.setNumberItems("0");
                logger.info("Number of Items:- 0");
            }else{
                applicationData.setNumberItems(vendorForm.getNumberItems());
                logger.info("Number of Items:- "+vendorForm.getNumberItems());
            }

            if (!vendorForm.getIdentityDoc().getOriginalFilename().isEmpty()) {
                String fileName = StringUtils.cleanPath(vendorForm.getIdentityDoc().getOriginalFilename());
                fileName = fileName.toLowerCase().replaceAll(" ", "_");
                fileName = System.currentTimeMillis() + "__" + fileName;
                applicationData.setIdentityDoc(fileName);
                fileStorageService.storeFile(vendorForm.getIdentityDoc(), fileName);
            } else {
                applicationData.setIdentityDoc("");
            }

            if (!vendorForm.getPhotoDoc().getOriginalFilename().isEmpty()) {
                String fileName = StringUtils.cleanPath(vendorForm.getPhotoDoc().getOriginalFilename());
                fileName = fileName.toLowerCase().replaceAll(" ", "_");
                fileName = System.currentTimeMillis() + "__" + fileName;
                applicationData.setPhotoDoc(fileName);
                fileStorageService.storeFile(vendorForm.getPhotoDoc(), fileName);
            } else {
                applicationData.setPhotoDoc("");
            }

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            applicationData.setCreatedDate(date);

            applicationData.setActive(true);
            applicationData.setWithdrawVenLicence("");
            applicationData.setFineDefaulter("");
            applicationData.setApplicationStatus(Constants.PENDING);

            UserApplicationEntity savedApplication = userApplicationService.saveApplication(applicationData);

            return savedApplication;
        } catch (Exception ex) {
            applicationData = null;
            return applicationData;
        }


    }


    //User Details
    private UserEntity populateBean(vendorApplicationForm vendorForm) {

        logger.info("========= Populating User Data From Form ========");
        logger.info("\n");

        UserEntity user = new UserEntity();
        StateEntity state = new StateEntity();
        DistrictEntity district = new DistrictEntity();
        BlocksEntity block = new BlocksEntity();
        TehsilEntity tehsil = new TehsilEntity();
        GPEntity grampanchayat = new GPEntity();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        GenderEntity gender = new GenderEntity();

        try {

            user.setActive(true);
            logger.info("User Is Active:- " + user.isActive());
            logger.info("\n");

            user.setFirstName(vendorForm.getFirstname());
            logger.info("User First Name:- " + user.getFirstName());
            logger.info("\n");

            user.setLastName(vendorForm.getLastname());
            logger.info("User Last Name:- " + user.getLastName());
            logger.info("\n");

            user.setUsername(Constants.createUsername(vendorForm.getFirstname(), vendorForm.getLastname(), vendorForm.getAge(), "vendor"));
            logger.info("User Username:- " + user.getUsername());
            logger.info("\n");

            state.setStateID(Integer.parseInt(vendorForm.getState()));
            user.setState(state);
            logger.info("User State Id:- " + user.getState().getStateID());
            logger.info("\n");

            district.setDistrictId(Integer.parseInt(vendorForm.getLocalDistrict()));
            user.setDistrict(district);
            logger.info("User District Id:- " + user.getDistrict().getDistrictId());
            logger.info("\n");

            block.setDistrictId(Integer.parseInt(vendorForm.getLocalBlock()));
            user.setBlock(block);
            logger.info("User Block Id:- " + user.getBlock().getDistrictId());
            logger.info("\n");


            tehsil.setDistrictId(Integer.parseInt(vendorForm.getLocalTehsil()));
            user.setTehsil(tehsil);
            logger.info("User Tehsil Id:- " + user.getTehsil().getDistrictId());
            logger.info("\n");


            grampanchayat.setPanchayatId(Integer.parseInt(vendorForm.getLocalgp()));
            user.setGrampanchayat(grampanchayat);
            logger.info("User Gram Panchayat Id:- " + user.getGrampanchayat().getPanchayatId());
            logger.info("\n");

            user.setDeleted(false);
            logger.info("User IsDeleted:- " + user.isDeleted());
            logger.info("\n");


            user.setMobileNumber(Long.valueOf(vendorForm.getMobileNumber()));
            logger.info("User Mobile Number:- " + user.getMobileNumber());
            logger.info("\n");


            user.setPassword(encoder.encode("Demo@123"));
            logger.info("User Password :- " + user.getPassword());
            logger.info("\n");


            user.setpAddress(vendorForm.getP_address());
            logger.info("User Address:- " + user.getpAddress());
            logger.info("\n");

            user.setAge(Integer.parseInt(vendorForm.getAge()));
            logger.info("User Age :- " + user.getAge());
            logger.info("\n");


            if (vendorForm.getEmailAddress().isEmpty() || vendorForm.getEmailAddress() == null) {
                user.setEmail("");
                logger.info("User Email :- " + user.getEmail());
                logger.info("\n");
            } else {
                user.setEmail(vendorForm.getEmailAddress());
                logger.info("User Email :- " + user.getEmail());
                logger.info("\n");

            }
            gender.setGenderId(Integer.parseInt(vendorForm.getGender()));
            user.setGenderID(gender);
            logger.info("User Gender :- " + user.getGenderID());
            logger.info("\n");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            user.setCreatedDate(date);
            logger.info("User Created Date :- " + user.getCreatedDate());
            logger.info("\n");

            String roleIid = vendorForm.getRoleId();
            logger.info("User Role ID :- " + vendorForm.getRoleId());
            logger.info("\n");


            Optional<RolesEntity> role = roleService.getRoleDetails(roleIid);
            if (role.get() != null) {
                List<RolesEntity> list = new ArrayList<RolesEntity>();
                list.add(role.get());
                user.setRoles(list);
                UserEntity user_saved = userService.saveUser(user);

                return user_saved;

            } else {
                user = null;
                return user;
            }
        } catch (Exception ex) {
            logger.info("========== Error While Populating User Data ==========");
            logger.info(ex.toString());
            logger.info(ex.getLocalizedMessage());
            user = null;
        }
        logger.info(user.toString());
        return user;
    }


}

package vendorapplication.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vendorapplication.entities.*;
import vendorapplication.form.vendorApplicationForm;
import vendorapplication.services.*;
import vendorapplication.utilities.Constants;
import vendorapplication.validators.VendorApplicationFormValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class VendorFormController {


    private static final Logger logger = LoggerFactory.getLogger(VendorFormController.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    ApplicatioRoutsService applicatioRoutsService;


    @Autowired
    private VendorApplicationFormValidator vendorApplicationFormValidator;

    @RequestMapping(value = "/vendorForm", method = RequestMethod.GET)
    public String createUser(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("successMessage", "");
        model.addAttribute("vendorApplicationForm", new vendorApplicationForm());
        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();


            UserEntity user = userService.getUserDetailsViaUsername(username);
            System.out.println(user);

            if (user != null) {
                //Set Session UserID
                request.getSession().setAttribute("user_Id", user.getUserId());
                model.addAttribute("user", user);
                model.addAttribute("vendorApplicationForm", new vendorApplicationForm());
                return "vendorForm";
            } else {
                return "errorPage";
            }


        }

    }

    //vendorForm
    @RequestMapping(value = "/vendorIndex", method = RequestMethod.GET)
    public String vendorIndex(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("successMessage", "");

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();


            UserEntity user = userService.getUserDetailsViaUsername(username);
            System.out.println(user);

            if (user != null) {

                //Get Applications via USer Details
                List<UserApplicationEntity> userApplications = userApplicationService.getApplicationsUserId(user.getUserId());

                    //Set Session UserID
                    request.getSession().setAttribute("user_Id", user.getUserId());
                    request.getSession().setAttribute("user_Name_First", user.getFirstName());
                    request.getSession().setAttribute("user_Name_LAst", user.getLastName());
                    request.getSession().setAttribute("user_Name_LAst", user.getUsername());
                    request.getSession().setAttribute("user_age", user.getAge());
                    request.getSession().setAttribute("Mobile_Number", user.getMobileNumber());
                    request.getSession().setAttribute("gender", user.getGenderID().getGenderName());
                    request.getSession().setAttribute("address", user.getpAddress());
                model.addAttribute("userApplications", userApplications);







                return "vendorIndex";
            } else {
                return "errorPage";
            }


        }

    }

    //bdo_dfo
    @RequestMapping(value = "/bdo_dfo", method = RequestMethod.GET)
    public String bdo_dfo(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("successMessage", "");

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails) principal).getUsername();


            UserEntity user = userService.getUserDetailsViaUsername(username);
            System.out.println(user);

            if (user != null) {

                //Get Applications via USer Details
                List<UserApplicationEntity> userApplications = userApplicationService.getApplications();

                //Set Session UserID
                request.getSession().setAttribute("user_Id", user.getUserId());
                request.getSession().setAttribute("user_Name_First", user.getFirstName());
                request.getSession().setAttribute("user_Name_LAst", user.getLastName());
                request.getSession().setAttribute("user_Name_LAst", user.getUsername());
                request.getSession().setAttribute("user_age", user.getAge());
                request.getSession().setAttribute("Mobile_Number", user.getMobileNumber());
                request.getSession().setAttribute("gender", user.getGenderID().getGenderName());
                request.getSession().setAttribute("address", user.getpAddress());
                model.addAttribute("userApplications", userApplications);

                return "bdo_dfo";
            } else {
                return "errorPage";
            }


        }

    }

    @RequestMapping(value = "/saveapplication",
            method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public String saveForm(@ModelAttribute("vendorApplicationForm") vendorApplicationForm vendorForm,
                           BindingResult bindingResult, Model model,
                           HttpServletRequest request, HttpSession session,
                           RedirectAttributes redirectAttributes) {

        String authority_ = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            vendorApplicationFormValidator.validate(vendorForm, bindingResult);
            if (bindingResult.hasErrors()) {
                return "vendorForm";
            }
            try {
                System.out.println(vendorForm.toString());
                UserApplicationEntity vendorApplication = new UserApplicationEntity();
                vendorApplication  =   populateBean(vendorForm, session);
                if (vendorApplication != null) {

                    try {
                        UserApplicationEntity savedData = userApplicationService.saveUser(vendorApplication);
                        if (!vendorForm.getLocationAvailable().isEmpty()) {
                            //Check if there is value or not inside the list
                            List<ApplicationRoutesEntity> availedServices = new ArrayList<>();
                            ApplicationRoutesEntity datax = null;
                            AvailableAreaEntity area = null;

                            for (int i = 0; i < vendorForm.getLocationAvailable().size(); i++) {
                                datax = new ApplicationRoutesEntity();
                                area = new AvailableAreaEntity();
                                UserApplicationEntity app_id = new UserApplicationEntity();
                                app_id.setAppId(savedData.getAppId());

                                if (vendorForm.getLocationAvailable().get(i) != null) {

                                    System.out.println(vendorForm.getLocationAvailable().get(i));
                                    area.setAreaId(vendorForm.getLocationAvailable().get(i));
                                    datax.setAreaId(area);
                                    datax.setAppId(app_id);
                                    datax.setActive(true);
                                    availedServices.add(datax);

                                }
                            }
                            System.out.println(availedServices.toString());
                            applicatioRoutsService.saveData(availedServices);

                        }

                        //Payment Data
                      //  request.getSession().setAttribute("successMessage", "Successfully Saved:- " + savedData.getAppId() );
                        return "vendorIndex";
                    } catch (Exception ex) {
                        request.getSession().setAttribute("serverError", ex.getLocalizedMessage().toString());
                        return "vendorForm";
                    }


                } else {
                    request.getSession().setAttribute("serverError", "Unable to Save the Data. Please try again");
                    return "vendorForm";
                }


            } catch (Exception ex) {
                model.addAttribute("serverError", ex.toString());
                return "vendorForm";
            }


        }

    }


    //getApplicationDetails

    private UserApplicationEntity populateBean(vendorApplicationForm vendorForm, HttpSession session) {

        logger.info("Inside Populate Function");

        UserApplicationEntity userApplicationEntity = new UserApplicationEntity();
        UserEntity user = new UserEntity();
        NationalityEntity nationality = new NationalityEntity();
        VendorEntity vendorEntity = new VendorEntity();
        VendorTypeEntity ventorTypeEntity = new VendorTypeEntity();
        DistrictEntity district = new DistrictEntity();


        try {

            userApplicationEntity.setActive(true);

            user.setUserId((Long) session.getAttribute("user_Id"));
            userApplicationEntity.setUserId(user);
            logger.info(user.toString());

            nationality.setNationalityId(Integer.parseInt(vendorForm.getNationality()));
            userApplicationEntity.setNationalityEntity(nationality);
            logger.info(nationality.toString());

            vendorEntity.setVenTypeID(Integer.parseInt(vendorForm.getVendor()));
            userApplicationEntity.setVendorId(vendorEntity);
            logger.info(vendorEntity.toString());

            ventorTypeEntity.setVendorTypeId(Integer.parseInt(vendorForm.getVendorType()));
            userApplicationEntity.setVendorTypeId(ventorTypeEntity);
            logger.info(ventorTypeEntity.toString());

            district.setDistrictId(Integer.parseInt(vendorForm.getDistrict()));
            userApplicationEntity.setDistrictId(district);
            logger.info(district.toString());

            if(vendorForm.getTentNumber().isEmpty() || vendorForm.getTentNumber()==null){
                userApplicationEntity.setTentNumber(Integer.parseInt("0"));
            }else{
                userApplicationEntity.setTentNumber(Integer.parseInt(vendorForm.getTentNumber()));
            }



            userApplicationEntity.setVendorComments(vendorForm.getComments());

            userApplicationEntity.setAppActionBdo(Constants.PENDING);
            userApplicationEntity.setBdoComments("");

            userApplicationEntity.setAppActionDc(Constants.PENDING);
            userApplicationEntity.setDcComments("");

            userApplicationEntity.setAppActionDfo(Constants.PENDING);
            userApplicationEntity.setDfoComments("");




            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            userApplicationEntity.setCreatedDate(date);

            if (!vendorForm.getIdentityDoc().getOriginalFilename().isEmpty()) {
                String fileName = StringUtils.cleanPath(vendorForm.getIdentityDoc().getOriginalFilename());
                fileName = fileName.toLowerCase().replaceAll(" ", "_");
                fileName = System.currentTimeMillis() + "__" + fileName;
                userApplicationEntity.setIdentityDoc(fileName);
                fileStorageService.storeFile(vendorForm.getIdentityDoc(), fileName);
            } else {
                userApplicationEntity.setIdentityDoc("");
            }



        } catch (Exception ex) {
            userApplicationEntity = null;
        }

        logger.info(userApplicationEntity.toString());
        return userApplicationEntity;

    }



}

package vendorapplication.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
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
import vendorapplication.form.vendorApplicationForm;
import vendorapplication.modal.VendorDashboardList;
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
import java.util.Optional;

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
        return "vendorRegistration";
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
                //Get Applications via USer Details
                List<Object[]> dashboardDataServerList = userApplicationService.getListByUserId((user.getUserId()).intValue());
                List<VendorDashboardList> dashboardData = new ArrayList<>();
                for (Object[] result : dashboardDataServerList) {
                    VendorDashboardList pojo = new VendorDashboardList();
                    pojo.setApp_id((Integer) result[0]);
                    pojo.setApp_action_dc((String)result[1]);
                    pojo.setApp_dc_date((Date) result[2]);
                    pojo.setApp_action_dfo((String)result[3]);
                    pojo.setApp_dfo_date((Date) result[4]);
                    pojo.setApp_action_bdo((String)result[5]);
                    pojo.setApp_bdo_date((Date) result[6]);
                    pojo.setCreatedDate((Date)result[7]);
                    pojo.setVendorType((String)result[8]);
                    pojo.setVendorCategory((String)result[9]);
                    dashboardData.add(pojo);
                }


                model.addAttribute("userApplications", dashboardData);







                return "vendorIndex";
            } else {
                return "errorPage";
            }


        }

    }

    //bdo_dfo
    @RequestMapping(value = "/bdo_dfo", method = RequestMethod.GET)
    public String bdo_dfo(Model model, HttpServletRequest request, HttpSession session) {
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
                //Set Session UserID
                request.getSession().setAttribute("user_Id", user.getUserId());
                request.getSession().setAttribute("user_Name_First", user.getFirstName());
                request.getSession().setAttribute("user_Name_LAst", user.getLastName());
                request.getSession().setAttribute("user_Name_LAst", user.getUsername());
                request.getSession().setAttribute("user_age", user.getAge());
                request.getSession().setAttribute("Mobile_Number", user.getMobileNumber());
                request.getSession().setAttribute("gender", user.getGenderID().getGenderName());
                request.getSession().setAttribute("address", user.getpAddress());


                List<Object[]> dashboardDataServerList = userApplicationService.getBodDfoDashboard();
                List<VendorDashboardList> dashboardData = new ArrayList<>();
                for (Object[] result : dashboardDataServerList) {
                    VendorDashboardList pojo = new VendorDashboardList();
                    pojo.setApp_id((Integer) result[0]);
                    pojo.setApp_action_dc((String)result[1]);
                    pojo.setApp_dc_date((Date) result[2]);
                    pojo.setApp_action_dfo((String)result[3]);
                    pojo.setApp_dfo_date((Date) result[4]);
                    pojo.setApp_action_bdo((String)result[5]);
                    pojo.setApp_bdo_date((Date) result[6]);
                    pojo.setCreatedDate((Date)result[7]);
                    pojo.setVendorType((String)result[8]);
                    pojo.setVendorCategory((String)result[9]);
                    pojo.setName((String)result[10]);
                    dashboardData.add(pojo);
                }

                model.addAttribute("userApplications", dashboardData);

                return "bdo_dfo";
            } else {
                return "errorPage";
            }


        }

    }

    @RequestMapping(value = "/saveapplication",  method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public String saveForm(@ModelAttribute("vendorApplicationForm") vendorApplicationForm vendorForm,
                           BindingResult bindingResult, Model model,
                           HttpServletRequest request, HttpSession session,
                           RedirectAttributes redirectAttributes) {



        String captcha=(String)session.getAttribute("CAPTCHA");
        if(captcha==null || (captcha!=null && !captcha.equals(vendorForm.getCaptcha()))){
            vendorForm.setCaptcha("");
            model.addAttribute("serverError", "Captcha Mismatch");
            return "vendorForm";
        }else {
            vendorApplicationFormValidator.validate(vendorForm, bindingResult);
            if (bindingResult.hasErrors()) {
                return "vendorForm";
            }
            try {
                System.out.println(vendorForm.toString());
                UserEntity user = new UserEntity();

                user = populateBean(vendorForm);
                if (user != null) {

                    try {
                        System.out.println(user.toString());
                       // redirectAttributes.addFlashAttribute("appId", savedData.getAppId());
                        return "redirect:/paymentpage";
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
    private UserEntity populateBean(vendorApplicationForm vendorForm) {

        logger.info("Inside Populate Function Add User");

        UserEntity user = new UserEntity();
        StateEntity state = new StateEntity();
        DistrictEntity district  = new DistrictEntity();
        BlocksEntity block = new BlocksEntity();
        TehsilEntity tehsil = new TehsilEntity();
        GPEntity grampanchayat = new GPEntity();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        GenderEntity gender = new GenderEntity();

        try {

            user.setActive(true);
            user.setFirstName(vendorForm.getFirstname());
            user.setLastName(vendorForm.getLastname());
            user.setUsername(Constants.createUsername(vendorForm.getFirstname(),vendorForm.getLastname(),vendorForm.getAge(),"vendor"));
            state.setStateID(Integer.parseInt(vendorForm.getState()));
            user.setState(state);
            district.setDistrictId(Integer.parseInt(vendorForm.getLocalDistrict()));
            user.setDistrict(district);
            block.setDistrictId(Integer.parseInt(vendorForm.getLocalBlock()));
            user.setBlock(block);
            tehsil.setDistrictId(Integer.parseInt(vendorForm.getLocalTehsil()));
            user.setTehsil(tehsil);
            grampanchayat.setPanchayatId(Integer.parseInt(vendorForm.getLocalgp()));
            user.setGrampanchayat(grampanchayat);
            user.setDeleted(false);
            user.setMobileNumber(Long.valueOf(vendorForm.getMobileNumber()));
            user.setPassword(encoder.encode("Demo@123"));
            user.setpAddress(vendorForm.getP_address());
            user.setAge(Integer.parseInt(vendorForm.getAge()));
            if(vendorForm.getEmailAddress().isEmpty() || vendorForm.getEmailAddress() == null){
                user.setEmail("");
            }else{
                user.setEmail(vendorForm.getEmailAddress());
            }
            gender.setGenderId(Integer.parseInt(vendorForm.getGender()));
            user.setGenderID(gender);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            user.setCreatedDate(date);
            String roleIid = vendorForm.getRoleId();
            Optional<RolesEntity> role = roleService.getRoleDetails(roleIid);
            if (role.get() != null) {
                List<RolesEntity> list = new ArrayList<RolesEntity>();
                list.add(role.get());
                user.setRoles(list);
                UserEntity user_saved = userService.saveUser(user);

                return user_saved;

            }else{
               user = null;
               return user;
            }
        } catch (Exception ex) {
            user = null;
        }
        logger.info(user.toString());
        return user;
    }






}

package vendorapplication.Controllers;


import org.springframework.security.core.userdetails.UserDetails;
import vendorapplication.entities.GenderEntity;
import vendorapplication.entities.RolesEntity;
import vendorapplication.entities.UserEntity;
import vendorapplication.form.RegisterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.modal.VendorDashboardList;
import vendorapplication.services.RoleService;
import vendorapplication.services.UserService;
import vendorapplication.validators.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserValidator userValidator;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String createUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            model.addAttribute("registerUser", new RegisterUser());
            return "createuser";
        }
    }

     // updateProfile
     @RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
     public String updateProfile(Model model) {
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
             return "login";
         } else {
             Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
             String username = ((UserDetails) principal).getUsername();
             RegisterUser registerUser = new RegisterUser();
             model.addAttribute("registerUser", registerUser);
             UserEntity user = userservice.getUserDetailsViaUsername(username);
             System.out.println(user);
             if (user != null) {
                 model.addAttribute("user", user);
                 registerUser.setC_address(user.getcAddress());
                 registerUser.setP_address(user.getpAddress());
                 return "updateProfile";
             } else {
                 return "error";
             }
         }
     }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    @Transactional
    public String saveUser(@ModelAttribute("registerUser") RegisterUser registerUser, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {

        String captcha=(String)session.getAttribute("CAPTCHA");
        if(captcha==null || (captcha!=null && !captcha.equals(registerUser.getCaptcha()))){
            registerUser.setCaptcha("");
            model.addAttribute("serverError", "Captcha Mismatch");
            return "createuser";
        }else {
            userValidator.validate(registerUser, bindingResult);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
                return "login";
            } else {
                if (bindingResult.hasErrors()) {
                    return "createuser";
                }
                try {
                    UserEntity user = new UserEntity();
                    GenderEntity genderEntity = new GenderEntity();
                    genderEntity.setGenderId(Integer.parseInt(registerUser.getGender()));
                    PasswordEncoder encoder = new BCryptPasswordEncoder();
                    user.setActive(true);
                    user.setDeleted(false);
                    user.setMobileNumber(Long.valueOf(registerUser.getMobileNumber()));
                    user.setUsername(registerUser.getUsername());
                    user.setPassword(encoder.encode(registerUser.getPassword()));
                    user.setFirstName(registerUser.getFirstname());
                    user.setLastName(registerUser.getLastname());
                    user.setpAddress(registerUser.getP_address());
                    user.setcAddress(registerUser.getC_address());
                    user.setAge(Integer.parseInt(registerUser.getAge()));

                    String roleIid = registerUser.getRoleId();
                    user.setEmail(registerUser.getEmailAddress());
                    user.setGenderID(genderEntity);

                    Optional<RolesEntity> role = roleService.getRoleDetails(roleIid);
                    if (role.get() != null) {
                        List<RolesEntity> list = new ArrayList<RolesEntity>();
                        list.add(role.get());
                        user.setRoles(list);
                        UserEntity savedData = userservice.saveUser(user);

                        request.getSession().setAttribute("successMessage", savedData.getUsername() + "  Successfully Saved. ID is" + savedData.getUserId());
                        registerUser.setMobileNumber("");
                        registerUser.setPasswordConfirm("");
                        registerUser.setPassword("");
                        registerUser.setUsername("");
                        registerUser.setFirstname("");
                        registerUser.setLastname("");
                        registerUser.setAge("");
                        registerUser.setEmailAddress("");
                        registerUser.setP_address("");
                        registerUser.setC_address("");
                        registerUser.setCaptcha("");
                        return "createuser";
                    } else {
                        registerUser.setMobileNumber("");
                        registerUser.setPasswordConfirm("");
                        registerUser.setPassword("");
                        registerUser.setUsername("");
                        registerUser.setFirstname("");
                        registerUser.setLastname("");
                        registerUser.setAge("");
                        registerUser.setEmailAddress("");
                        registerUser.setP_address("");
                        registerUser.setC_address("");
                        registerUser.setCaptcha("");
                        model.addAttribute("serverError", "No Role Name and Role Description Exist with this ID");
                        return "createuser";
                    }

                } catch (Exception ex) {
                    registerUser.setMobileNumber("");
                    registerUser.setPasswordConfirm("");
                    registerUser.setPassword("");
                    registerUser.setUsername("");
                    registerUser.setFirstname("");
                    registerUser.setLastname("");
                    registerUser.setAge("");
                    registerUser.setEmailAddress("");
                    registerUser.setP_address("");
                    registerUser.setC_address("");
                    registerUser.setCaptcha("");
                    model.addAttribute("serverError", ex.toString());
                    return "createuser";
                }
            }

        }







    }

}

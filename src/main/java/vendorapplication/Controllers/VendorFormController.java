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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vendorapplication.entities.UserEntity;
import vendorapplication.form.RegisterUser;
import vendorapplication.form.vendorApplicationForm;
import vendorapplication.services.FileStorageService;
import vendorapplication.services.RoleService;
import vendorapplication.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class VendorFormController {

    //vendorForm
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/vendorForm", method = RequestMethod.GET)
    public String createUser(Model model, HttpServletRequest request ) {
        request.getSession().setAttribute("successMessage", "");
        model.addAttribute("vendorApplicationForm", new vendorApplicationForm());
        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
             Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
             String username = ((UserDetails) principal).getUsername();;

            UserEntity user = userService.getUserDetailsViaUsername(username);
            System.out.println(user);

            if(user!=null) {
                model.addAttribute("user", user);
                model.addAttribute("vendorApplicationForm", new vendorApplicationForm());
                return "vendorForm";
            }else{
                return "errorPage";
            }


        }

    }

    @RequestMapping(value = "/saveapplication",
            method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveForm(@ModelAttribute("vendorApplicationForm") vendorApplicationForm  vendorForm,
                           BindingResult bindingResult, Model model,
                           HttpServletRequest request, HttpSession session,
                           RedirectAttributes redirectAttributes) {

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            System.out.println(vendorForm.toString());
           return null;

        }

    }
}

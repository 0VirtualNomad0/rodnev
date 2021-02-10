package vendorapplication.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.entities.UserEntity;
import vendorapplication.form.RegisterUser;
import vendorapplication.services.RoleService;
import vendorapplication.services.UserService;

import java.util.Collection;

@Controller
public class VendorFormController {

    //vendorForm
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/vendorForm", method = RequestMethod.GET)
    public String createUser(Model model) {
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
                return "vendorForm";
            }else{
                return "errorPage";
            }


        }

    }
}

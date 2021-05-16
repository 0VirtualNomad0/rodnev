package vendorapplication.Controllers;


import vendorapplication.entities.RolesEntity;
import vendorapplication.form.RolesForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.services.RoleService;
import vendorapplication.validators.RoleValidator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RolesController {

    @Autowired
    private RoleValidator roleValidator;

    @Autowired
    private RoleService roleService;

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @RequestMapping(value = "/createRole", method = RequestMethod.GET)
    public String createRole(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//            return "login";
//        } else {
            model.addAttribute("rolesForm", new RolesForm());
            return "createrole";
//        }
    }


    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("rolesForm") RolesForm roleForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
        roleValidator.validate(roleForm, bindingResult);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            if (bindingResult.hasErrors()) {
                return "createrole";
            }
            try {
                RolesEntity rolesEntity = new RolesEntity();
                rolesEntity.setActive(true);
                rolesEntity.setRoleName(roleForm.getRoleName());
                rolesEntity.setRoleDescription(roleForm.getRoleDescription());
                RolesEntity savedData = roleService.saveRole(rolesEntity);
                roleForm.setRoleName("");
                roleForm.setRoleDescription("");
                request.getSession().setAttribute("successMessage", savedData.getRoleName() + " role Successfully Saved. ID is" + savedData.getRoleId());
                return "createrole";
            } catch (Exception ex) {
                roleForm.setRoleName("");
                roleForm.setRoleDescription("");
                model.addAttribute("serverError", ex.toString());
                return "createrole";
            }
       }


    }
}

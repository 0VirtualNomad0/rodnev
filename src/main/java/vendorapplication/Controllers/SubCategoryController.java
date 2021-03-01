package vendorapplication.Controllers;

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
import vendorapplication.entities.VendorEntity;
import vendorapplication.form.CategoryForm;
import vendorapplication.form.SubCategoryForm;
import vendorapplication.services.VendorService;
import vendorapplication.validators.CategoryValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class SubCategoryController {


    @Autowired
    VendorService vendorService;

    @Autowired
    CategoryValidator categoryValidator;

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @RequestMapping(value = "/addsubcategories", method = RequestMethod.GET)
    public String createRole(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
        model.addAttribute("subCategoryForm", new SubCategoryForm());
        return "subcategories";
       }
    }


}

package vendorapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.entities.UserEntity;
import vendorapplication.repositories.UserRepository;
import vendorapplication.services.UserApplicationService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationDetailsController {

    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/getApplicationDetails/{app_Id}", method= RequestMethod.GET)
    public String getApplicationDetails(@PathVariable("app_Id")Integer appID,
                                        Model model, HttpServletRequest request) {



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
           // model.addAttribute("actionForm", new ActionForm());

            UserApplicationEntity userApplicationEntity = new UserApplicationEntity();

           // UserTranactionEntity transactionUser = new UserTranactionEntity();
            try {

                userApplicationEntity = userApplicationService.getUserApplicationViaAppId(appID);
                if (userApplicationEntity!=null) {
                    System.out.println(userApplicationEntity.toString());
                   // transactionUser =userTransactionService.getUserTransaction(user.getUserId());

                    model.addAttribute("applicationData", userApplicationEntity);
                    request.getSession().setAttribute("successMessage", "Data found Successfully");
                    return "vendorFormDetails";
                } else {
                    request.getSession().setAttribute("successMessage", "No Data Available.");
                    return "vendorFormDetails";
                }

            } catch (Exception ex) {
                request.getSession().setAttribute("serverError", ex.getLocalizedMessage().toString());
            }

            return "vendorFormDetails";
        }

    }
}

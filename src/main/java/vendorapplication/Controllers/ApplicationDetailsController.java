package vendorapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.entities.UserEntity;
import vendorapplication.form.ActionForm;
import vendorapplication.repositories.UserRepository;
import vendorapplication.services.UserApplicationService;
import vendorapplication.utilities.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;

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
            model.addAttribute("actionForm", new ActionForm());

            UserApplicationEntity userApplicationEntity = null;
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

    //Update Action for Application
    @RequestMapping(value = "/updateActionApplication", method = RequestMethod.POST)
    @Transactional
    public String update_application(@ModelAttribute("actionForm") ActionForm actionForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
        // roleValidator.validate(roleForm, bindingResult);
        System.out.println(actionForm.toString());
        String Action = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            try {

                    if (actionForm.getAction().equalsIgnoreCase("A")) {
                        Action = Constants.APPROVED;
                    } else if (actionForm.getAction().equalsIgnoreCase("R")) {
                        Action = Constants.REJECTED;
                    } else if (actionForm.getAction().equalsIgnoreCase("I")) {
                        Action = Constants.INCOMPLETE;
                    }else {
                        Action = Constants.PENDING;
                    }
                    if(actionForm.getUser_role().equalsIgnoreCase("BDO")){
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        Date date = new Date(timestamp.getTime());
                        int value = userApplicationService.updateBdoAction(Action,actionForm.getComments(),Integer.parseInt(actionForm.getApp_id()),date);
                        if(value>0){
                            System.out.println("Data Updated");
                        }else{
                            System.out.println("Data Not Updated");
                        }

                    }else if(actionForm.getUser_role().equalsIgnoreCase("DFO")){
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        Date date = new Date(timestamp.getTime());
                        int value = userApplicationService.updateDfoAction(Action,actionForm.getComments(),Integer.parseInt(actionForm.getApp_id()),date);
                        if(value>0){
                            System.out.println("Data Updated");
                        }else{
                            System.out.println("Data Not Updated");
                        }
                    }else{
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        Date date = new Date(timestamp.getTime());
                        int value = userApplicationService.updateDcAction(Action,actionForm.getComments(),Integer.parseInt(actionForm.getApp_id()),date);
                        if(value>0){
                            System.out.println("Data Updated");
                        }else{
                            System.out.println("Data Not Updated");
                        }
                    }

//
//               // FlightFormEntity savedData = flightFormService.saveUser(user);
//                model.addAttribute("userdata", savedData);
//                model.addAttribute("successMessage", "Application Updated");
                return "vendorFormDetails";

            } catch (Exception ex) {

                model.addAttribute("serverError", ex.toString());
                return "vendorFormDetails";
            }
        }


    }
}

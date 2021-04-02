package vendorapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.entities.UserEntity;
import vendorapplication.entities.UserPermissionsEntity;
import vendorapplication.entities.UserTranactionEntity;
import vendorapplication.form.ActionForm;
import vendorapplication.repositories.RolesRepository;
import vendorapplication.repositories.UserRepository;
import vendorapplication.repositories.UserTranactionRepository;
import vendorapplication.services.*;
import vendorapplication.utilities.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class ApplicationDetailsController {

    @Autowired
    UserPermissionsService userPermissionsService;

    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService rolesService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    UserTransactionService userTransactionService;

    @RequestMapping(value = "/getApplicationDetails/{app_Id}", method= RequestMethod.GET)
    public String getApplicationDetails(@PathVariable("app_Id")Integer appID,
                                        Model model, HttpServletRequest request) {



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            model.addAttribute("actionForm", new ActionForm());

            UserApplicationEntity userApplicationEntity = null;
            UserTranactionEntity transactionalUser = null;
            try {

                userApplicationEntity = userApplicationService.getUserApplicationViaAppId(appID);
                if (userApplicationEntity!=null) {
                    System.out.println(userApplicationEntity.toString());
                    transactionalUser =userTransactionService.getUserTransaction(appID);

                    System.out.println(transactionalUser.toString());
                    model.addAttribute("applicationData", userApplicationEntity);
                    model.addAttribute("transaction",transactionalUser);
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
    @RequestMapping(value = "/updateActionApplication", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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

                UserPermissionsEntity permissionsEntity = new UserPermissionsEntity();

                permissionsEntity.setActive(true);

                if(actionForm.getComments().isEmpty()) permissionsEntity.setComments("");
                else permissionsEntity.setComments(actionForm.getComments());

                if (actionForm.getAction().equalsIgnoreCase("A")) {
                    Action = Constants.APPROVED;
                    permissionsEntity.setStatus(Action);
                } else if (actionForm.getAction().equalsIgnoreCase("R")) {
                    Action = Constants.REJECTED;
                    permissionsEntity.setStatus(Action);
                } else {
                    Action = Constants.PENDING;
                    permissionsEntity.setStatus(Action);
                }

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Date date = new Date(timestamp.getTime());
                permissionsEntity.setCreateddate(date);

                permissionsEntity.setAppId(Integer.parseInt(actionForm.getApp_id()));

                UserEntity entityUSer = new UserEntity();
                entityUSer.setUserId((long) Integer.parseInt(actionForm.getUser_id()));
                permissionsEntity.setUserId(entityUSer);

                permissionsEntity.setRoleId(rolesService.checkRoleName(actionForm.getUser_role()).getRoleId().intValue());

                if (!actionForm.getAttachment_if_any().getOriginalFilename().isEmpty()) {
                    String fileName = StringUtils.cleanPath(actionForm.getAttachment_if_any().getOriginalFilename());
                    fileName = fileName.toLowerCase().replaceAll(" ", "_");
                    fileName = System.currentTimeMillis() + "__" + fileName;
                    permissionsEntity.setAttachemnts(fileName);
                    fileStorageService.storeFile(actionForm.getAttachment_if_any(), fileName);
                } else {
                    permissionsEntity.setAttachemnts("");
                }



                        UserPermissionsEntity  savedEntity = userPermissionsService.addPermission(permissionsEntity);
                        if(savedEntity!=null){
                            System.out.println("Data Updated");
                            System.out.println(savedEntity.toString());
                            request.getSession().setAttribute("successMessage", "Data Saved Successfully.");
                        }else{
                            request.getSession().setAttribute("successMessage", "Unable to save the Data. Please try again Later.");
                        }



                return "vendorFormDetails";

            } catch (Exception ex) {

                model.addAttribute("serverError", ex.toString());
                return "vendorFormDetails";
            }
        }


    }
}

package vendorapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
import vendorapplication.modal.LoggedInUserLocationSession;
import vendorapplication.repositories.RolesRepository;
import vendorapplication.repositories.UserRepository;
import vendorapplication.repositories.UserTranactionRepository;
import vendorapplication.services.*;
import vendorapplication.utilities.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

        String authority_ = null;
        Boolean canGivePermission = false;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            model.addAttribute("actionForm", new ActionForm());

            UserApplicationEntity userApplicationEntity = null;
            UserTranactionEntity transactionalUser = null;
            try {
                Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

                for (GrantedAuthority authority : authorities) {
                    authority_ = authority.getAuthority().toString();
                    System.out.println(authority.getAuthority().toString());
                }
                System.out.println(authority_);

                userApplicationEntity = userApplicationService.getUserApplicationViaAppId(appID);
                if (userApplicationEntity!=null) {
                    System.out.println(userApplicationEntity.toString());
                    transactionalUser =userTransactionService.getUserTransaction(appID);

                    //Check who all have given permissions
                    if(authority_.equalsIgnoreCase("BDO")){
                        //Check Weather BDO has give permission to the application
                        canGivePermission =checkPermissionByRole(userApplicationEntity.getApp_permissions(),"BDO");
                        model.addAttribute("canGivePermission", canGivePermission);
                    }else if(authority_.equalsIgnoreCase("DFO")){
                        //Check Weather DFO has gave permission to the application
                        canGivePermission =  checkPermissionByRole(userApplicationEntity.getApp_permissions(),"DFO");
                        model.addAttribute("canGivePermission", canGivePermission);
                    }else{
                        //Check weather DC Has Given Permission to the application
                        canGivePermission = checkPermissionByRole(userApplicationEntity.getApp_permissions(),"DC");
                        model.addAttribute("canGivePermission", canGivePermission);
                    }

                    LoggedInUserLocationSession user = (LoggedInUserLocationSession) request.getSession().getAttribute("UserData");
                    System.out.println(user.toString());

                    System.out.println(transactionalUser.toString());
                    model.addAttribute("applicationData", userApplicationEntity);
                    model.addAttribute("transaction",transactionalUser);
                    model.addAttribute("userId",user.getUserID());
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

    private boolean checkPermissionByRole(List<UserPermissionsEntity> app_permissions, String role) {
        //Check weather the list is Empty or not
        if(app_permissions.isEmpty()){
            return true;  //Give Permission
        }else{
            // check weather the role is present or not
            System.out.println(app_permissions.stream().filter(o -> o.getRoleName().equals(role)).findFirst().isPresent());
            if(app_permissions.stream().filter(o -> o.getRoleName().equals(role)).findFirst().isPresent()){
                return false;  //Dont Give Permission
            }else{
                return true;  // Give Permission
            }
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


                permissionsEntity.setUserId(Integer.valueOf(actionForm.getUser_id()));

                permissionsEntity.setRoleName(actionForm.getUser_role());

                if (!actionForm.getAttachment_if_any().getOriginalFilename().isEmpty()) {
                    String fileName = StringUtils.cleanPath(actionForm.getAttachment_if_any().getOriginalFilename());
                    fileName = fileName.toLowerCase().replaceAll(" ", "_");
                    fileName = System.currentTimeMillis() + "__" + fileName;
                    permissionsEntity.setAttachemnts(fileName);
                    fileStorageService.storeFile(actionForm.getAttachment_if_any(), fileName);
                } else {
                    permissionsEntity.setAttachemnts("");
                }
                if(actionForm.getApplicant_mobile().isEmpty())  permissionsEntity.setApplicantMobile("");
                else  permissionsEntity.setApplicantMobile(actionForm.getApplicant_mobile());



                        UserPermissionsEntity  savedEntity = userPermissionsService.addPermission(permissionsEntity);
                        if(actionForm.getUser_role().equalsIgnoreCase("DC")){
                            //Change Application Status to A
                            userApplicationService.updateUserApplication(actionForm.getApp_id(),Action);
                        }
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

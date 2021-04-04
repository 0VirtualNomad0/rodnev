package vendorapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.modal.ApplicationsViaLocations;
import vendorapplication.modal.LoggedInUserLocationSession;
import vendorapplication.services.UserApplicationService;
import vendorapplication.utilities.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class Dashboard {

    @Autowired
    UserApplicationService userApplicationService;



    //dashboard  homepage_new
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model, HttpServletRequest request, HttpSession session) {


        request.getSession().setAttribute("successMessage", "");

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

            for (GrantedAuthority authority : authorities) {
                authority_ = authority.getAuthority().toString();
                System.out.println(authority.getAuthority().toString());
            }


            LoggedInUserLocationSession user = (LoggedInUserLocationSession) request.getSession().getAttribute("UserData");
            System.out.println(user.toString());

            if (user != null) {

                if(authority_.equalsIgnoreCase("Super Admin") || authority_.equalsIgnoreCase("Admin")){
                    Integer applicationCountTotal = userApplicationService.getTotalApplications();
                    Integer approvedApplications = userApplicationService.getApprovedApplications(Constants.APPROVED);
                    Integer rejectedApplications = userApplicationService.getApprovedApplications(Constants.REJECTED);
                    Integer pendingApplications = userApplicationService.getApprovedApplications(Constants.PENDING);
                    System.out.println(applicationCountTotal);
                    model.addAttribute("totalApplications", applicationCountTotal);
                    model.addAttribute("approvedApplications", approvedApplications);
                    model.addAttribute("rejectedApplications", rejectedApplications);
                    model.addAttribute("pendingApplications", pendingApplications);
                }else{
                    Integer applicationCountTotal = userApplicationService.getTotalApplicationsRole(user.getStateId(),user.getDistrictId());
                    Integer approvedApplications = userApplicationService.getApprovedApplicationsRole(user.getStateId(),user.getDistrictId(),Constants.APPROVED);
                    Integer rejectedApplications = userApplicationService.getApprovedApplicationsRole(user.getStateId(),user.getDistrictId(),Constants.REJECTED);
                    Integer pendingApplications = userApplicationService.getApprovedApplicationsRole(user.getStateId(),user.getDistrictId(),Constants.PENDING);
                    System.out.println(applicationCountTotal);
                    model.addAttribute("totalApplications", applicationCountTotal);
                    model.addAttribute("approvedApplications", approvedApplications);
                    model.addAttribute("rejectedApplications", rejectedApplications);
                    model.addAttribute("pendingApplications", pendingApplications);
                }



                return "homepage_new";
            } else {
                return "errorPage";
            }

        }
    }

    @RequestMapping(value = "/getApplications/{status}", method= RequestMethod.GET)
    public String getApplicationsStatus(@PathVariable("status")String status,
                                        Model model, HttpServletRequest request) {

        request.getSession().setAttribute("successMessage", "");

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            LoggedInUserLocationSession user = (LoggedInUserLocationSession) request.getSession().getAttribute("UserData");
            System.out.println(user.toString());

            if (user != null) {

                List<Object[]> dashboardDataServerList = userApplicationService.getApplicationsLocationWiseStatus(user.getStateId(), user.getDistrictId(), status);
                List<ApplicationsViaLocations> applications = new ArrayList<>();
                for (Object[] result : dashboardDataServerList) {
                    ApplicationsViaLocations pojo = new ApplicationsViaLocations();
                    pojo.setApp_id((Integer) result[0]);
                    pojo.setFirstName((String) result[1]);
                    pojo.setLastName((String) result[2]);
                    pojo.setMobileNumber((BigInteger) result[3]);
                    pojo.setCategory((String) result[4]);
                    pojo.setSubCategory((String) result[5]);
                    pojo.setUser_id((Integer) result[6]);
                    pojo.setApplication_status((String) result[7]);
                    applications.add(pojo);
                }

                model.addAttribute("userApplications", applications);

                return "applications_list";
            } else {
                return "errorPage";
            }
        }

    }
}

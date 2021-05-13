package vendorapplication.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.modal.LoggedInUserLocationSession;
import vendorapplication.repositories.user.UserRepository;
import vendorapplication.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {




    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainpage(Model model) {
        return "mainpage";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String homePage(Model model, HttpServletRequest request) {

        String authority_ = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                username = principal.toString();
            }
            for (GrantedAuthority authority : authorities) {
                authority_ = authority.getAuthority().toString();
                System.out.println(authority.getAuthority().toString());
            }
            //Get the User Data and Set Set the Data in Session
            List<LoggedInUserLocationSession> data = userRepository.getUserGeoData(username);

//            List<LoggedInUserLocationSession> loggedInUserLocationSessionsList = new ArrayList<>();
//
//
//            for (Object[] result : data) {
//                LoggedInUserLocationSession userSession = new LoggedInUserLocationSession();
//                userSession.setStateId((Integer) result[0]);
//                userSession.setDistrictId((Integer) result[1]);
//                userSession.setBlockId((Integer) result[2]);
//                userSession.setTehsilId((Integer) result[3]);
//                userSession.setPanchayatId((Integer) result[4]);
//                userSession.setUserID((Integer)result[5]);
//
//                loggedInUserLocationSessionsList.add(userSession);
//            }





            //Save the Object in Session
            request.getSession().setAttribute("UserData", data.get(0));


       if(authority_.equalsIgnoreCase("Super Admin") || authority_.equalsIgnoreCase("Admin") || authority_.equalsIgnoreCase("DC")) { return "redirect:/dashboard";}
       else if(authority_.equalsIgnoreCase("DFO") || authority_.equalsIgnoreCase("PCB") || authority_.equalsIgnoreCase("BDO") ) { return "redirect:/dashboard"; }
       else { return "redirect:/vendorIndex";}
        }

    }





    @RequestMapping(value = "/gallery", method = RequestMethod.GET)
    public String gallery(Model model) {
        return "gallery";
    }

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String contactus(Model model) {
        return "contactus";
    }

    @RequestMapping(value = "/refundpage", method = RequestMethod.GET)
    public String refundpage(Model model) {
        return "refundpage";
    }

    @RequestMapping(value = "/privacypolicy", method = RequestMethod.GET)
    public String privacypolicy(Model model) {
        return "privacypolicy";
    }

    @RequestMapping(value = "/termsandconditions", method = RequestMethod.GET)
    public String termsandconditions(Model model) {
        return "termsandconditions";
    }












}

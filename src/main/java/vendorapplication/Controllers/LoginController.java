package vendorapplication.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String login(Model model, String error, String logout, HttpSession httpSession) {
 //       System.out.println("This is Login Controller");
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        Object message = httpSession.getAttribute("message");
        if (message != null) {
            model.addAttribute("message", message);
            httpSession.removeAttribute("message");
        }

        return "login";
    }





    @RequestMapping(value =  "/logout" , method = RequestMethod.GET)
    public String logout(Model model) {
        System.out.println("Logout Successful");
        return "login";
    }
}

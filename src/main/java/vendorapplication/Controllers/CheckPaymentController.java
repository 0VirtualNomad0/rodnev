package vendorapplication.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vendorapplication.entities.UserTranactionEntity;
import vendorapplication.form.CheckPayment;
import vendorapplication.paymentutility.PaymentUtil;
import vendorapplication.services.UserTransactionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckPaymentController {

    @Autowired
    UserTransactionService userTransactionService;


    @RequestMapping(value = "/checkpayment", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            request.getSession().setAttribute("successMessage", "");
            model.addAttribute("checkPayment", new CheckPayment());
            return "checkpayment";
        }
    }


    @RequestMapping(value = "/checkPaymentPost", method = RequestMethod.POST)
    public String saveDetails(@ModelAttribute("checkPayment") CheckPayment checkPayment,
                               Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            PaymentUtil util = new PaymentUtil();
            String status = util.verifyPayment(checkPayment.getApplication_id());

            request.getSession().setAttribute("successMessage", status);


            return "checkpayment";
        }
    }

    //checkpaymentdb

    @RequestMapping(value = "/checkpaymentdb", method = RequestMethod.GET)
    public String checkpaymentdb(Model model, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            request.getSession().setAttribute("successMessage", "");
            model.addAttribute("checkPayment", new CheckPayment());
            return "checkpaymentdb";
        }
    }


    @RequestMapping(value = "/checkPaymentdbPost", method = RequestMethod.POST)
    public String checkPaymentdbPost(@ModelAttribute("checkPayment") CheckPayment checkPayment,
                              Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {

            UserTranactionEntity entity = userTransactionService.getUserTransaction(Integer.parseInt(checkPayment.getApplication_id()));
            if(entity!=null){
                request.getSession().setAttribute("successMessage", entity.toString());

            }else{
                request.getSession().setAttribute("successMessage", "Data No Found");
            }



            return "checkpaymentdb";
        }
    }
}

package vendorapplication.Controllers;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.qrcode.WriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.entities.UserPermissionsEntity;
import vendorapplication.entities.UserTranactionEntity;
import vendorapplication.form.CheckStatusForm;
import vendorapplication.repositories.userapplication.UserApplicationRepository;
import vendorapplication.services.UserPermissionsService;
import vendorapplication.services.UserTransactionService;
import vendorapplication.utilities.Constants;
import vendorapplication.utilities.DateUtilities;
import vendorapplication.utilities.GeneratePdfReport;
import vendorapplication.validators.CheckStatusValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class CheckAppStatusController {

    private static final Logger logger = LoggerFactory.getLogger(CheckAppStatusController.class);
    @Autowired
    private CheckStatusValidator checkStatusValidator;
    @Autowired
    private UserPermissionsService userPermissionsService;

    @Autowired
    private UserTransactionService userTransactionService;

    //Check Status
    @Autowired
    private UserApplicationRepository userApplicationRepository;

    @RequestMapping(value = "/checkStatus", method = RequestMethod.GET)
    public String checkStatus(Model model) {
        model.addAttribute("checkStatus", new CheckStatusForm());
        return "checkStatus";
    }

    //checkStatusApp
    @RequestMapping(value = "/checkStatusApp", method = RequestMethod.POST)
    public String checkStatusApp(@ModelAttribute("checkStatus") CheckStatusForm form, BindingResult bindingResult, Model model, HttpServletRequest request) {
        checkStatusValidator.validate(form, bindingResult);

        if (bindingResult.hasErrors()) {
            return "checkStatus";
        }

        try {
            boolean downloadApplication , applicationRejected= false;
            List<UserPermissionsEntity> data = null;
            Long DatesDifference;


            data = userPermissionsService.checkApplicationStatus(Integer.parseInt(form.getAppId()), form.getMobileNumber());

            if (!data.isEmpty()) {
                downloadApplication = checkApplicationDownloadable(data, "DC", "PCB");
               if(downloadApplication){
                   request.getSession().setAttribute("successMessage", "Data found Successfully");
                   model.addAttribute("appPermissions", data);
                   model.addAttribute("downloadApplication", downloadApplication);
                   model.addAttribute("applicatoinId", form.getAppId());
                   model.addAttribute("autoApproved", false);
                   return "checkStatus";
               }else {

                   applicationRejected = checkApplicationREjected(data, "DC", "PCB");

                   if(applicationRejected){
                       request.getSession().setAttribute("successMessage", "Data found Successfully"); model.addAttribute("downloadApplication", false);
                       model.addAttribute("applicatoinId", form.getAppId());
                       model.addAttribute("appPermissions", data);
                       model.addAttribute("autoApproved", false);
                       return "checkStatus";
                   }else{
                       Map<String, Object> map = null;
                       //Object[]
                       Date dates_server = userApplicationRepository.getApplicationCreatedDate(Integer.parseInt(form.getAppId()));

                       if (!dates_server.toString().isEmpty() ) {
                           //Calculate Dates
                           System.out.println("Created Date of Application:- " + dates_server);
                           System.out.println("Today's Date:- " + DateUtilities.getCurrentDate());

                           DatesDifference = DateUtilities.getDifferenceDays(DateUtilities.convertToDate(dates_server.toString()), DateUtilities.convertToDate(DateUtilities.getCurrentDate()));
                           System.out.println(DatesDifference);

                           if (DatesDifference > 7) {
                               //Application Auto Approved
                               model.addAttribute("successMessage", "Data Found Successfully.");
                               model.addAttribute("downloadApplication", downloadApplication);
                               model.addAttribute("appPermissions", data);
                               model.addAttribute("applicatoinId", form.getAppId());
                               model.addAttribute("autoApproved", true);
                               return "checkStatus";
                           } else {
                               //Application Not Auto Approved
                               model.addAttribute("successMessage", " Application Pending. Application not yet approved by the DC or PCB.");
                               model.addAttribute("downloadApplication", downloadApplication);
                               model.addAttribute("appPermissions", data);
                               model.addAttribute("applicatoinId", form.getAppId());
                               model.addAttribute("autoApproved", false);
                               return "checkStatus";
                           }


                       } else {
                           model.addAttribute("serverError", "No Data available for the current Application ID and Mobile Number.");
                           model.addAttribute("downloadApplication", false);
                           model.addAttribute("applicatoinId", form.getAppId());
                           model.addAttribute("autoApproved", false);
                           return "checkStatus";
                       }
                   }


               }




            } else {

                //Check Weather the Application is There in Application Table and get Date
                if (userApplicationRepository.countApplicationsViaAppIs(Long.parseLong(form.getMobileNumber()), Integer.parseInt(form.getAppId())) != 1) {
                    model.addAttribute("serverError", "No Data available for the current Application ID and Mobile Number.");
                    model.addAttribute("downloadApplication", false);
                    model.addAttribute("applicatoinId", form.getAppId());
                    return "checkStatus";

                } else {

                    Map<String, Object> map = null;
                    //Object[]
                    Date dates_server = userApplicationRepository.getApplicationCreatedDate(Integer.parseInt(form.getAppId()));
//dates_server.length == 1
                    if (!dates_server.toString().isEmpty() ) {
                        //Calculate Dates
                        System.out.println("Created Date of Application:- " + dates_server);
                        System.out.println("Today's Date:- " + DateUtilities.getCurrentDate());
//dates_server[0]
                        DatesDifference = DateUtilities.getDifferenceDays(DateUtilities.convertToDate(dates_server.toString()), DateUtilities.convertToDate(DateUtilities.getCurrentDate()));
                        System.out.println(DatesDifference);

                        if (DatesDifference > 7) {
                            //Application Auto Approved
                            model.addAttribute("successMessage", "Data Found Successfully.");
                            model.addAttribute("downloadApplication", true);
                            model.addAttribute("applicatoinId", form.getAppId());
                            model.addAttribute("autoApproved", true);
                            return "checkStatus";
                        } else {
                            //Application Not Auto Approved
                            model.addAttribute("successMessage", " Application Pending. Application not yet approved by the DC or PCB.");
                            model.addAttribute("downloadApplication", false);
                            model.addAttribute("applicatoinId", form.getAppId());
                            model.addAttribute("autoApproved", false);
                            return "checkStatus";
                        }


                    } else {
                        model.addAttribute("serverError", "No Data available for the current Application ID and Mobile Number.");
                        model.addAttribute("downloadApplication", false);
                        model.addAttribute("applicatoinId", form.getAppId());
                        model.addAttribute("autoApproved", false);
                        return "checkStatus";
                    }
                }


            }


        } catch (Exception ex) {
            model.addAttribute("serverError", ex.toString());
            model.addAttribute("downloadApplication", false);
            model.addAttribute("applicatoinId", "");
            model.addAttribute("autoApproved", false);
            return "checkStatus";
        }
    }

    private boolean checkApplicationDownloadable(List<UserPermissionsEntity> data, String roleDc, String rolePCB) {
        try {
            //Check Weather the Application is Approved By DC or PCB
            boolean checkRole = data.stream().filter(fixture ->
                    (fixture.getRoleName().equals(roleDc) && fixture.getStatus().equals(Constants.APPROVED)) ||
                            (fixture.getRoleName().equals(rolePCB) && fixture.getStatus().equals(Constants.APPROVED))
            ).findFirst().isPresent();
            System.out.println(checkRole);
            if (checkRole) return true;
            else return false;
        } catch (Exception ex) {
            logger.info("Exception While Downloading Application:- " + ex.getLocalizedMessage().toLowerCase(Locale.ROOT));
            return false;
        }

    }

    private boolean checkApplicationREjected(List<UserPermissionsEntity> data, String roleDc, String rolePCB) {
        try {
            //Check Weather the Application is Approved By DC or PCB
            boolean checkRole = data.stream().filter(fixture ->
                    (fixture.getRoleName().equals(roleDc) && fixture.getStatus().equals(Constants.REJECTED)) ||
                            (fixture.getRoleName().equals(rolePCB) && fixture.getStatus().equals(Constants.REJECTED))
            ).findFirst().isPresent();
            System.out.println(checkRole);
            if (checkRole) return true;
            else return false;
        } catch (Exception ex) {
            logger.info("Exception While Downloading Application:- " + ex.getLocalizedMessage().toLowerCase(Locale.ROOT));
            return false;
        }

    }

    //generatePdf
    @RequestMapping(value = "/generatePdf/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public void downloadPDF(@PathVariable("id") String id,HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        try {
            UserApplicationEntity userApplicationEntity = userApplicationRepository.findById(Integer.parseInt(id)).get();
            UserTranactionEntity userTranactionEntity = userTransactionService.getUserTransaction(Integer.parseInt(id));
            ByteArrayOutputStream bis = GeneratePdfReport.generateIdCard(userApplicationEntity, userTranactionEntity);

            response.setContentType("application/pdf");
            response.setHeader("Content-disposition","attachment;filename=" + userApplicationEntity.getUserId().getMobileNumber() + ".pdf");
            logger.info("We are In the End");
            logger.info("Bis Length===" + bis.size());
            DataOutputStream os = new DataOutputStream(response.getOutputStream());
            response.setHeader("Content-Length", String.valueOf(bis.size()));
            logger.info("Content-Length===" + bis.size());

            os.write(bis.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

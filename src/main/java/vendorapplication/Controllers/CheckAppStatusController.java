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
import vendorapplication.form.CheckStatusForm;
import vendorapplication.repositories.UserApplicationRepository;
import vendorapplication.services.UserPermissionsService;
import vendorapplication.utilities.GeneratePdfReport;
import vendorapplication.validators.CheckStatusValidator;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class CheckAppStatusController {

    @Autowired
    private CheckStatusValidator checkStatusValidator;

    @Autowired
    private UserPermissionsService userPermissionsService;

    @Autowired
    private UserApplicationRepository userApplicationRepository;

    //Check Status

    private static final Logger logger = LoggerFactory.getLogger(CheckAppStatusController.class);

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
            List<UserPermissionsEntity> data = null;
            data = userPermissionsService.checkApplicationStatus(Integer.parseInt(form.getAppId()), form.getMobileNumber());

            if (!data.isEmpty()) {
                request.getSession().setAttribute("successMessage", "Data found Successfully");
                model.addAttribute("appPermissions", data);
                return "checkStatus";
            } else {
                model.addAttribute("serverError", "No Data available for the current Application ID and Mobile Number.");
                return "checkStatus";
            }


        } catch (Exception ex) {
            model.addAttribute("serverError", ex.toString());
            return "checkStatus";
        }
    }


        //generatePdf
    @RequestMapping(value = "/generatePdf/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    ResponseEntity<InputStreamResource> printId(@PathVariable("id") String id) throws IOException, WriterException, DocumentException {

        UserApplicationEntity userApplicationEntity = userApplicationRepository.findById(Integer.parseInt(id)).get();
        ByteArrayInputStream bis = GeneratePdfReport.generateIdCard(userApplicationEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + userApplicationEntity.getUserId().getMobileNumber() + ".pdf");


        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

}

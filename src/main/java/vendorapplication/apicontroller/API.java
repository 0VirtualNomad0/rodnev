package vendorapplication.apicontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.security.EncryptDecrypt;
import vendorapplication.services.FileStorageService;
import vendorapplication.services.UserAppItemsService;
import vendorapplication.services.UserApplicationService;
import vendorapplication.utilities.Constants;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class API {

    private static final Logger logger = LoggerFactory.getLogger(API.class);


    @Autowired
    private UserApplicationService userApplicationService;

    /**
     * Get Application Details Via Application Id and Mobile Number
     */
    @RequestMapping(value = "/api/getCompleteApplication", method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getApplicationDetails(@RequestBody String jsondata ) {
        Map<String, Object> map = null;
        String appId = null, mobileNumber = null, userId = null ,  encrypted = null;
        if(jsondata!=null && !jsondata.isEmpty()){
            JsonObject o = new JsonParser().parse(jsondata).getAsJsonObject();
            System.out.println(o.toString());
            appId = o.getAsJsonObject().get("application_id").getAsString();
            mobileNumber = o.getAsJsonObject().get("mobile_number").getAsString();
            userId = o.getAsJsonObject().get("user_id").getAsString();
        }

        try {
            UserApplicationEntity data = userApplicationService.getUserApplicationViaAppIdUserId(Integer.parseInt(appId), Integer.parseInt(userId));


            // Creating Object of ObjectMapper define in Jakson Api
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;

            jsonStr = Obj.writeValueAsString(data);

            EncryptDecrypt ED = new EncryptDecrypt();
            encrypted = ED.encrypt(jsonStr);

            if (data != null ) {
                map = new HashMap<String, Object>();
                map.put(Constants.keyResponse, encrypted);
                map.put(Constants.keyMessage, Constants.valueMessage);
                map.put(Constants.keyStatus, HttpStatus.OK.value());
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            } else {

                map = new HashMap<String, Object>();
                map.put(Constants.keyResponse, "Nothing Found.");
                map.put(Constants.keyMessage, Constants.valueMessage);
                map.put(Constants.keyStatus, HttpStatus.OK.value());
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            }
        } catch (Exception ex) {
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, "Something Bad Happed. Please Try Again Later.");
            map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
            map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

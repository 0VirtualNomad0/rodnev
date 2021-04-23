package vendorapplication.apicontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.security.EncryptDecrypt;
import vendorapplication.services.UserApplicationService;
import vendorapplication.utilities.Constants;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
    @RequestMapping(value = Constants.apiMethod, method = RequestMethod.POST, consumes = Constants.consumesProducesJson, produces = Constants.consumesProducesJson)
    @ResponseBody
    public synchronized ResponseEntity<?> getApplicationDetails(@RequestBody String jsonDataApp ) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        logger.info("Json App Date:- "+ jsonDataApp);
        Map<String, Object> map = null;
        EncryptDecrypt ED = new EncryptDecrypt();

        String appId = null, mobileNumber = null, userId = null ,  encrypted = null;
        if(jsonDataApp!=null && !jsonDataApp.isEmpty()){
            logger.info("API:: Data Not Empty");

            try {
                String decryptedData = ED.decrypt(jsonDataApp);
                JsonObject o = new JsonParser().parse(decryptedData).getAsJsonObject();
                System.out.println(o.toString());
                logger.info("API:: Data is:- " + o);
                appId = o.getAsJsonObject().get(Constants.application_id).getAsString();
                mobileNumber = o.getAsJsonObject().get(Constants.mobule_number).getAsString();
                userId = o.getAsJsonObject().get(Constants.user_id).getAsString();

                UserApplicationEntity data = userApplicationService.getUserApplicationViaAppIdUserId(Integer.parseInt(appId), Integer.parseInt(userId));
                ObjectMapper Obj = new ObjectMapper();
                String jsonStr = null;
                jsonStr = Obj.writeValueAsString(data);

                encrypted = ED.encrypt(jsonStr);
                logger.info("API:: Json Object is:- " + jsonStr);
                logger.info("API:: Encrypted Data is:- " + encrypted);

                if (data != null ) {
                    map = new HashMap<String, Object>();
                    map.put(Constants.keyResponse, encrypted);
                    map.put(Constants.keyMessage, Constants.valueMessage);
                    map.put(Constants.keyStatus, HttpStatus.OK.value());
                    return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
                } else {

                    map = new HashMap<String, Object>();
                    map.put(Constants.keyResponse, Constants.nothingFound);
                    map.put(Constants.keyMessage, Constants.valueMessage);
                    map.put(Constants.keyStatus, HttpStatus.OK.value());
                    return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
                }
            } catch (Exception ex) {
                map = new HashMap<String, Object>();
                map.put(Constants.keyResponse, Constants.genericError);
                map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
                map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.genericError);
            map.put(Constants.keyMessage, Constants.applicationDataEmpty);
            map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

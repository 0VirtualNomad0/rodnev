package vendorapplication.apicontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.entities.UserEntity;
import vendorapplication.security.EncryptDecrypt;
import vendorapplication.services.UserApplicationService;
import vendorapplication.services.UserService;
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

    @Autowired
    UserService userService;

    /**
     * Get Application Details Via Application Id and Mobile Number
     */
    @RequestMapping(value = Constants.apiMethod, method = RequestMethod.POST, consumes = Constants.getConsumesProducesPlainText, produces = Constants.consumesProducesJson)
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

                if (encrypted != null ) {
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



    /**
     * Login Using Username and Password
     */
    @RequestMapping(value = Constants.apiMethodLogin, method = RequestMethod.POST, consumes = Constants.getConsumesProducesPlainText, produces = Constants.consumesProducesJson)
    @ResponseBody
    public ResponseEntity<?> getUserLoginDetails(@RequestBody String userData ) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        logger.info("Json App Date:- "+ userData);
        Map<String, Object> map = null;
        EncryptDecrypt ED = new EncryptDecrypt();
        String username = null, password = null, encrypted = null;


        if(userData!=null && !userData.isEmpty()){
            logger.info("API:: User Data Not Empty");

            try {
                String decryptedData = ED.decrypt(userData);
                System.out.println(decryptedData);
                JsonObject o = new JsonParser().parse(decryptedData).getAsJsonObject();
                System.out.println(o.toString());
                logger.info("API:: User Data is:- " + o);
                username = o.getAsJsonObject().get(Constants.username).getAsString();
                password = o.getAsJsonObject().get(Constants.password).getAsString();

                UserEntity user = userService.getUserDetailsViaUsername(username);


                if(user!=null ){
                    System.out.println(user.toString());
                    PasswordEncoder encoder = new BCryptPasswordEncoder();
                    System.out.println(encoder.encode(password));

                    boolean isPasswordMatch = encoder.matches(password, user.getPassword());
                    System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

                    if(isPasswordMatch){
                        ObjectMapper Obj = new ObjectMapper();
                        String jsonStr = null;
                        jsonStr = Obj.writeValueAsString(user);

                        encrypted = ED.encrypt(jsonStr);
                        logger.info("API:: Json Object is:- " + jsonStr);
                        logger.info("API:: Encrypted Data is:- " + encrypted);

                        if (encrypted != null ) {
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
                }else{
                        map = new HashMap<String, Object>();
                        map.put(Constants.keyResponse, Constants.nothingFound);
                        map.put(Constants.keyMessage, Constants.valueMessage);
                        map.put(Constants.keyStatus, HttpStatus.OK.value());
                        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
                    }




                }else{
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
            map.put(Constants.keyMessage, Constants.userDetailsDataEmpty);
            map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
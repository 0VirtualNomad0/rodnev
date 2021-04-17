package vendorapplication.apicontroller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vendorapplication.services.FileStorageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
public class API {

    private static final Logger logger = LoggerFactory.getLogger(API.class);

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * Download Resource Service
     * @param fileName
     * @param request
     * @return
     */
//    @GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//        // Load file as Resource
//        Resource resource = fileStorageService.loadFileAsResource(fileName);
//
//        // Try to determine file's content type
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            logger.info("Could not determine file type.");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }


    /**
     * Get Application Details Via Application Id and Mobile Number
     */
//    @RequestMapping(value = "/api/getApplicationDetails", method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
//    @ResponseBody
//    public ResponseEntity<?> getVehicleDetailsViaVahan(@RequestBody String jsondata ) {
//        Map<String, Object> map = null;
//        HTTP http = new HTTP();
//        String registrationNumber = null, ip = null, userId = null;
//        if(jsondata!=null && !jsondata.isEmpty()){
//            JsonObject o = new JsonParser().parse(jsondata).getAsJsonObject();
//            System.out.println(o.toString());
//            registrationNumber = o.getAsJsonObject().get("regNo").getAsString();
//            ip = o.getAsJsonObject().get("Ip").getAsString();
//            userId = o.getAsJsonObject().get("userId").getAsString();
//        }
//        VahanObject data = null;
//        try {
//            VahanObject object = new VahanObject();
//
//            object.setFunction_name(Constants.getCarDetailsVahan);
//            object.setUrl(Constants.vahan);
//            object.setParameters_to_send(registrationNumber);
//            data = http.postData(object);
//            if (data != null && data.getSuccessFail().equalsIgnoreCase("SUCCESS")) {
//                VehicleDetailsObject objectVehicle = ParseXML.parseXml(data.getResponse());
//                VahanLog log =   createLog(data,ip,userId,objectVehicle);
//                vahanLogsRepository.save(log);
//                map = new HashMap<String, Object>();
//                map.put(Constants.keyResponse, objectVehicle);
//                map.put(Constants.keyMessage, Constants.valueMessage);
//                map.put(Constants.keyStatus, HttpStatus.OK);
//                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//            } else {
//                VehicleDetailsObject objectVehicle = null;
//                VahanLog log =   createLog(data,ip,userId,objectVehicle);
//                vahanLogsRepository.save(log);
//                map = new HashMap<String, Object>();
//                map.put(Constants.keyResponse, data.getResponse());
//                map.put(Constants.keyMessage, Constants.valueMessage);
//                map.put(Constants.keyStatus, HttpStatus.OK);
//                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//            }
//        } catch (Exception ex) {
//            VehicleDetailsObject objectVehicle = null;
//            VahanLog log =   createLog(data,ip,userId,objectVehicle);
//            vahanLogsRepository.save(log);
//            map = new HashMap<String, Object>();
//            map.put(Constants.keyResponse, "");
//            map.put(Constants.keyMessage, ex.getLocalizedMessage().toString());
//            map.put(Constants.keyStatus, HttpStatus.INTERNAL_SERVER_ERROR);
//            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
}

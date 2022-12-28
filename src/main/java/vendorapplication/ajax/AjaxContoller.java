package vendorapplication.ajax;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vendorapplication.modal.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vendorapplication.repositories.blocks.BlockRepository;
import vendorapplication.repositories.category.CategoryRepository;
import vendorapplication.repositories.categorycaste.CasteCategoryRepository;
import vendorapplication.repositories.district.DistrictRepository;
import vendorapplication.repositories.gender.GenderRepository;
import vendorapplication.repositories.grampanchayat.GPRepository;
import vendorapplication.repositories.landtype.LandTypeRepository;
import vendorapplication.repositories.nationality.NationalityRepository;
import vendorapplication.repositories.nationalregional.NationalRegionalRepository;
import vendorapplication.repositories.qualification.QualificationRepository;
import vendorapplication.repositories.roles.RolesRepository;
import vendorapplication.repositories.states.StateRepository;
import vendorapplication.repositories.subcategory.SubCategoryRepository;
import vendorapplication.repositories.subcategoryitems.SubCategoryItemsRepository;
import vendorapplication.repositories.tehsil.TehsilRepository;
import vendorapplication.utilities.Constants;

import java.util.*;

@RestController
public class AjaxContoller {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    NationalityRepository nationalityRepository;

    @Autowired
    CategoryRepository vendorRepository;

    @Autowired
    CasteCategoryRepository casteCategoryRepository;

    @Autowired
    QualificationRepository qualificationRepository;

    @Autowired
    SubCategoryRepository vendorTypeRepository;

    @Autowired
    DistrictRepository districtRepository;



    @Autowired
    StateRepository stateRepository;

    @Autowired
    BlockRepository blockRepository;

    @Autowired
    TehsilRepository tehsilRepository;

    @Autowired
    GPRepository gpRepository;

    @Autowired
    LandTypeRepository landTypeRepository;

    @Autowired
    NationalRegionalRepository nationalRegionalRepository;

    @Autowired
    SubCategoryItemsRepository subCategoryItemsRepository;





    private static final Logger logger = LoggerFactory.getLogger(AjaxContoller.class);


    @RequestMapping(value = Constants.getRoles, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody  //ResponseEntity<?>
    String  getRoles() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<RolesModal> roles = rolesRepository.getRoles();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, roles);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    @RequestMapping(value = Constants.getGender, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody   //ResponseEntity<?>
    String getGender() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<GenderModal> gender = genderRepository.getGender();


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, gender);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
       // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;
    }

    //Get State
    @RequestMapping(value = Constants.getState, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody  // ResponseEntity<?>
    String getState() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<StateModal > states = stateRepository.getStates();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, states);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
       // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //Get Districs
    @RequestMapping(value = Constants.getDistrictsViaState, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody  //ResponseEntity<?>
     String getDistrictsViaState(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {

        Map<String, Object> map = null;

        try{
            Integer id_ = Integer.parseInt(id);
            List<DistrictModal> districtsObject = districtRepository.getDistrictsViaId(id_,false,true);


            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, districtsObject);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;

        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse );
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }



    }

    //getBlocks
    @RequestMapping(value = Constants.getBlocks, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getBlocks(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {
        Map<String, Object> map = null;

        try{
            List<BlockModal> blockObjects = blockRepository.getBlocksViaDitricts(Integer.parseInt(id),true,false);
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, blockObjects);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }catch(Exception ex){

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    // Get Blocks Two
//    @RequestMapping(value = Constants.getBlocks, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
//    public @ResponseBody
//    ResponseEntity<?> getBlocksTwo(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {
//        Map<String, Object> map = null;
//
//        try{
//            List<BlocksEntity> blockObjects = blockRepository.getBlocksViaDitricts(Integer.parseInt(id));
//
//            if(!blockObjects.isEmpty()){
//                map = new HashMap<String, Object>();
//                map.put(Constants.keyResponse, blockObjects);
//                map.put(Constants.keyMessage, Constants.valueMessage);
//                map.put(Constants.keyStatus, HttpStatus.OK);
//                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//            }else{
//                map = new HashMap<String, Object>();
//                map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
//                map.put(Constants.keyMessage, Constants.valueMessage);
//                map.put(Constants.keyStatus, HttpStatus.OK);
//                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//            }
//
//
//        }catch(Exception ex){
//
//            map = new HashMap<String, Object>();
//            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
//            map.put(Constants.keyMessage, Constants.valueMessage);
//            map.put(Constants.keyStatus, HttpStatus.OK);
//            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//        }
//
//    }

    //getTehsils
    @RequestMapping(value = Constants.getTehsils, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getTehsils(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {
        Map<String, Object> map = null;

        try{

            List<TehsilModal> TehsilObjects = tehsilRepository.getTehsils(Integer.parseInt(id));

            map = new HashMap<>();
            map.put(Constants.keyResponse, TehsilObjects);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
           // return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;

        }catch (Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
           // return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }

    }

    //getWardPanchayat
    @RequestMapping(value = Constants.getWardPanchayat, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getWardPanchayat(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {


        Map<String, Object> map = null;

        try{
            List<GramPanchayatModal> gpObjects = gpRepository.getgpViaId(Integer.parseInt(id));
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, gpObjects);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
           // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
           // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }



    }


    //getNationality
    @RequestMapping(value = Constants.getNationality, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getNationality() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<NationalityModal> nationality = nationalityRepository.getNationalality();



        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, nationality);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
       // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }



    //getNationalRegional
    @RequestMapping(value = Constants.getNationalRegional, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getNationalRegional() throws JsonProcessingException {
        Map<String, Object> map;
        List<NationalRegionalModal> nationalRegional = nationalRegionalRepository.getNationalRegional();
        map = new HashMap<>();
        map.put(Constants.keyResponse, nationalRegional);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //LandType
    //getNationalRegional
    @RequestMapping(value = Constants.getLandType, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
   String getLandType() throws JsonProcessingException {
        Map<String, Object> map;
        List<LandTypeModal> landType = landTypeRepository.getLandType();
        map = new HashMap<>();
        map.put(Constants.keyResponse, landType);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
      //  return new ResponseEntity<>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    @RequestMapping(value = Constants.getrolesVendor, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getrolesVendor() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<RolesModal> roles = rolesRepository.getRoleVendor();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, roles);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
       // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //getVendor
    @RequestMapping(value = Constants.getVendor, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getVendor() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<CategoryModal> categories = vendorRepository.getCategories();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, categories);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //getVendor
    @RequestMapping(value = Constants.getCasteCategories, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getCasteCategory() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<CategoryModal> categories = casteCategoryRepository.getCategories();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, categories);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }

    //getQualifications
    @RequestMapping(value = Constants.getQualifications, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getQualifications() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<QualificationModal> categories = qualificationRepository.getQualifications();
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, categories);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }



    //getVendorCategory
        @RequestMapping(value = Constants.getVendorCategory, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getVendorCategory(@RequestParam(value = Constants.requestParam, required = true) String id) throws Exception {


            Map<String, Object> map = null;
            try{

                List<SubCategoryModal> vendorsCategorys = vendorTypeRepository.getSubCategories(Integer.parseInt(id));

                map = new HashMap<String, Object>();
                map.put(Constants.keyResponse, vendorsCategorys);
                map.put(Constants.keyMessage, Constants.valueMessage);
                map.put(Constants.keyStatus, HttpStatus.OK);
               // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

                ObjectMapper Obj = new ObjectMapper();
                String jsonStr = null;
                jsonStr = Obj.writeValueAsString(map);
                logger.info(jsonStr);

                return jsonStr;
            }catch(Exception ex){
                map = new HashMap<String, Object>();
                map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
                map.put(Constants.keyMessage, Constants.valueMessage);
                map.put(Constants.keyStatus, HttpStatus.OK);
               // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

                ObjectMapper Obj = new ObjectMapper();
                String jsonStr = null;
                jsonStr = Obj.writeValueAsString(map);
                logger.info(jsonStr);

                return jsonStr;
            }

    }

    //getItemsviaSubCategories
    @RequestMapping(value = Constants.getItemsviaSubCategoriesTent, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getItemsviaSubCategories(

            @RequestParam(value = Constants.landType, required = true) String landType,
            @RequestParam(value = Constants.category, required = true) String category,
            @RequestParam(value = Constants.subCategory, required = true) String subCategory
             ) throws Exception {


        Map<String, Object> map = null;

        try {

            List<Items> items = subCategoryItemsRepository.getItemsSubCategory(

                    Integer.parseInt(landType),
                    Integer.parseInt(category),
                    Integer.parseInt(subCategory));


            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, items);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
           // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }


    }


    //getItemsviaSubCategoriesNR
    @RequestMapping(value = Constants.getItemsviaSubCategoriesNR, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getItemsviaSubCategoriesNR(
            @RequestParam(value = Constants.landType, required = true) String landType,
            @RequestParam(value = Constants.category, required = true) String category,
            @RequestParam(value = Constants.regional, required = true) String regional,
            @RequestParam(value = Constants.subCategory, required = true) String subCategory
    ) throws Exception {


        Map<String, Object> map;
        try {
            List<Items> items = subCategoryItemsRepository.getItemsSubCategoryNR(

                    Integer.parseInt(landType),
                    Integer.parseInt(category),
                    Integer.parseInt(regional),
                    Integer.parseInt(subCategory));


            map = new HashMap<>();
            map.put(Constants.keyResponse, items);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
           // return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }catch(Exception ex){
            map = new HashMap<>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            //return new ResponseEntity<>(map, HttpStatus.OK);

            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = null;
            jsonStr = Obj.writeValueAsString(map);
            logger.info(jsonStr);

            return jsonStr;
        }


    }

// getItemsviaSubCategoriesNonTentNonRegional
@RequestMapping(value = Constants.getItemsviaSubCategoriesNonTentNonRegional, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
public @ResponseBody
String getItemsviaSubCategoriesNonTentNonRegional(
        @RequestParam(value = Constants.landType, required = true) String landType,
        @RequestParam(value = Constants.category, required = true) String category,
        @RequestParam(value = Constants.regional, required = true) String regional,
        @RequestParam(value = Constants.subCategory, required = true) String subCategory
) throws Exception {


    Map<String, Object> map = null;
    try {
        List<Items> items = subCategoryItemsRepository.getItemsSubCategoryOthers(
                Integer.parseInt(landType),
                Integer.parseInt(category),
                Integer.parseInt(subCategory));

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, items);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        //return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;
    }catch(Exception ex){
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
      //  return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;
    }


}

    //getDistrict
    @RequestMapping(value = Constants.getDistrict, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    String getDistrict() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<DistrictModal> districts = districtRepository.getDistricts(false,true);

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, districts);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
       // return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;


    }





}

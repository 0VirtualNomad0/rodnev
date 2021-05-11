package vendorapplication.ajax;

import jdk.nashorn.internal.ir.Block;
import vendorapplication.entities.BlocksEntity;
import vendorapplication.modal.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vendorapplication.repositories.*;
import vendorapplication.repositories.blocks.BlockRepository;
import vendorapplication.utilities.Constants;

import java.math.BigInteger;
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
    SubCategoryRepository vendorTypeRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    AvailableAreaRepository availableAreaRepository;

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
    public @ResponseBody
    ResponseEntity<?> getRoles() {
        Map<String, Object> map = null;
        List<Object[] > roles = rolesRepository.getRoles();
        List<RolesModal> modelRole = new ArrayList<>();


        for (Object[] result : roles) {
            RolesModal pojo = new RolesModal();
            pojo.setRole_id((BigInteger) result[0]);
            pojo.setRole_name((String) result[1]);
            modelRole.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, modelRole);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    @RequestMapping(value = Constants.getGender, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getGender() {
        Map<String, Object> map = null;
        List<Object[] > gender = genderRepository.getGender();
        List<GenderModal> modelGender = new ArrayList<>();


        for (Object[] result : gender) {
            GenderModal pojo = new GenderModal();
            pojo.setGenderId((Integer) result[0]);
            pojo.setGenderName((String) result[1]);
            modelGender.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, modelGender);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    //Get State
    @RequestMapping(value = Constants.getState, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getState() {
        Map<String, Object> map = null;
        List<Object[] > gender = stateRepository.getStates();
        List<StateModal> modelState = new ArrayList<>();


        for (Object[] result : gender) {
            StateModal pojo = new StateModal();
            pojo.setStateId((Integer) result[0]);
            pojo.setStateName((String) result[1]);
            modelState.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, modelState);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    //Get Districs
    @RequestMapping(value = Constants.getDistrictsViaState, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getDistrictsViaState(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {

        Map<String, Object> map = null;

        try{
            Integer id_ = Integer.parseInt(id);
            List<Object[] > districtsObject = districtRepository.getDistrictsViaId(id_);
            List<DistrictModal> districtModals = new ArrayList<>();


            for (Object[] result : districtsObject) {
                DistrictModal pojo = new DistrictModal();
                pojo.setDistrictId((Integer) result[0]);
                pojo.setDistrictName((String) result[1]);
                districtModals.add(pojo);
            }

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, districtModals);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse );
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }



    }

    //getBlocks
    @RequestMapping(value = Constants.getBlocks, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getBlocks(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {
        Map<String, Object> map = null;

        try{
            List<BlocksEntity > blockObjects = blockRepository.getBlocksViaDitricts(Integer.parseInt(id));
            List<BlockModal> blockModals = new ArrayList<>();


            for (BlocksEntity result : blockObjects) {
                BlockModal pojo = new BlockModal();
                pojo.setBlockId(result.getDistrictId());
                pojo.setBlockName(result.getDistrictName());
                blockModals.add(pojo);
            }

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, blockModals);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }catch(Exception ex){

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
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
    ResponseEntity<?> getTehsils(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {
        Map<String, Object> map = null;

        try{

            List<Object[] > TehsilObjects = tehsilRepository.getTehsilViaDistrict(Integer.parseInt(id));
            List<TehsilModal> tehsilModal = new ArrayList<>();


            for (Object[] result : TehsilObjects) {
                TehsilModal pojo = new TehsilModal();
                pojo.setTehsilId((Integer) result[0]);
                pojo.setTehsilName((String) result[1]);
                tehsilModal.add(pojo);
            }

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, tehsilModal);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }catch (Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }

    }

    //getWardPanchayat
    @RequestMapping(value = Constants.getWardPanchayat, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getWardPanchayat(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {


        Map<String, Object> map = null;

        try{
            List<Object[] > gpObjects = gpRepository.getgpViaId(Integer.parseInt(id));
            List<GramPanchayatModal> gpModalList = new ArrayList<>();


            for (Object[] result : gpObjects) {
                GramPanchayatModal pojo = new GramPanchayatModal();
                pojo.setGpId((Integer) result[0]);
                pojo.setGpName((String) result[1]);
                gpModalList.add(pojo);
            }

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, gpModalList);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }



    }


    //getNationality
    @RequestMapping(value = Constants.getNationality, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getNationality() {
        Map<String, Object> map = null;
        List<Object[] > nationality = nationalityRepository.getNationalality();
        List<NationalityModal> modelNationality = new ArrayList<>();


        for (Object[] result : nationality) {
            NationalityModal pojo = new NationalityModal();
            pojo.setNationalityId((Integer) result[0]);
            pojo.setNationalityName((String) result[1]);
            modelNationality.add(pojo);
        }


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, modelNationality);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }



    //getNationalRegional
    @RequestMapping(value = Constants.getNationalRegional, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getNationalRegional() {
        Map<String, Object> map = null;
        List<Object[] > nationalRegional = nationalRegionalRepository.getNationalRegional();
        List<NationalRegionalModal> modelNationalRegional = new ArrayList<>();


        for (Object[] result : nationalRegional) {
            NationalRegionalModal pojo = new NationalRegionalModal();
            pojo.setNationalRegionalId((Integer) result[0]);
            pojo.setNationalRegionalName((String) result[1]);
            modelNationalRegional.add(pojo);
        }


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, modelNationalRegional);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    //LandType
    //getNationalRegional
    @RequestMapping(value = Constants.getLandType, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getLandType() {
        Map<String, Object> map = null;
        List<Object[] > landType = landTypeRepository.getLandType();
        List<LandTypeModal> modalLandType = new ArrayList<>();


        for (Object[] result : landType) {
            LandTypeModal pojo = new LandTypeModal();
            pojo.setLandTypeId((Integer) result[0]);
            pojo.setLandTypeName((String) result[1]);
            modalLandType.add(pojo);
        }


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, modalLandType);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    @RequestMapping(value = Constants.getrolesVendor, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getrolesVendor() {
        Map<String, Object> map = null;
        List<Object[] > roles = rolesRepository.getRoleVendor();
        List<RolesModal> rolesModals = new ArrayList<>();


        for (Object[] result : roles) {
            RolesModal pojo = new RolesModal();
            pojo.setRole_id((BigInteger) result[0]);
            pojo.setRole_name((String) result[1]);
            rolesModals.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, rolesModals);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    //getVendor
    @RequestMapping(value = Constants.getVendor, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getVendor() {
        Map<String, Object> map = null;
        List<Object[] > vendors = vendorRepository.getCategories();
        List<CategoryModal> vendorModal = new ArrayList<>();


        for (Object[] result : vendors) {
            CategoryModal pojo = new CategoryModal();
            pojo.setCategoryId((Integer) result[0]);
            pojo.setCategoryName((String) result[1]);
            vendorModal.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, vendorModal);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }


    //getVendorCategory
        @RequestMapping(value = Constants.getVendorCategory, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getVendorCategory(@RequestParam(value = Constants.requestParam, required = true) String id) throws Exception {


            Map<String, Object> map = null;
            try{

                List<Object[] > vendorsCategorys = vendorTypeRepository.getSubCategories(Integer.parseInt(id));
                List<VendorCategoryModal> vendorCatModal = new ArrayList<>();


                for (Object[] result : vendorsCategorys) {
                    VendorCategoryModal pojo = new VendorCategoryModal();
                    pojo.setVendorCategoryId((Integer) result[0]);
                    pojo.setVendorCategoryName((String) result[1]);
                    vendorCatModal.add(pojo);
                }

                map = new HashMap<String, Object>();
                map.put(Constants.keyResponse, vendorCatModal);
                map.put(Constants.keyMessage, Constants.valueMessage);
                map.put(Constants.keyStatus, HttpStatus.OK);
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            }catch(Exception ex){
                map = new HashMap<String, Object>();
                map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
                map.put(Constants.keyMessage, Constants.valueMessage);
                map.put(Constants.keyStatus, HttpStatus.OK);
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
            }

    }

    //getItemsviaSubCategories
    @RequestMapping(value = Constants.getItemsviaSubCategoriesTent, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getItemsviaSubCategories(

            @RequestParam(value = Constants.landType, required = true) String landType,
            @RequestParam(value = Constants.category, required = true) String category,
            @RequestParam(value = Constants.subCategory, required = true) String subCategory
             ) throws Exception {


        Map<String, Object> map = null;

        try {

            List<Object[]> items = subCategoryItemsRepository.getItemsSubCategory(

                    Integer.parseInt(landType),
                    Integer.parseInt(category),
                    Integer.parseInt(subCategory));
            List<Items> itemModal = new ArrayList<>();


            for (Object[] result : items) {
                Items pojo = new Items();
                pojo.setItemId((Integer) result[0]);
                pojo.setItemName((String) result[1]);
                pojo.setRate((String) result[2]);
                pojo.setSecurityamount((String) result[3]);
                pojo.setFee_panchayat((String) result[4]);
                itemModal.add(pojo);
            }

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, itemModal);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }


    }


    //getItemsviaSubCategoriesNR
    @RequestMapping(value = Constants.getItemsviaSubCategoriesNR, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getItemsviaSubCategoriesNR(
            @RequestParam(value = Constants.landType, required = true) String landType,
            @RequestParam(value = Constants.category, required = true) String category,
            @RequestParam(value = Constants.regional, required = true) String regional,
            @RequestParam(value = Constants.subCategory, required = true) String subCategory
    ) throws Exception {


        Map<String, Object> map = null;
        try {
            List<Object[]> items = subCategoryItemsRepository.getItemsSubCategoryNR(

                    Integer.parseInt(landType),
                    Integer.parseInt(category),
                    Integer.parseInt(regional),
                    Integer.parseInt(subCategory));
            List<Items> itemModal = new ArrayList<>();


            for (Object[] result : items) {
                Items pojo = new Items();
                pojo.setItemId((Integer) result[0]);
                pojo.setItemName((String) result[1]);
                pojo.setRate((String) result[2]);
                pojo.setSecurityamount((String) result[3]);
                pojo.setFee_panchayat((String) result[4]);
                itemModal.add(pojo);
            }

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, itemModal);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }


    }

// getItemsviaSubCategoriesNonTentNonRegional
@RequestMapping(value = Constants.getItemsviaSubCategoriesNonTentNonRegional, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
public @ResponseBody
ResponseEntity<?> getItemsviaSubCategoriesNonTentNonRegional(
        @RequestParam(value = Constants.landType, required = true) String landType,
        @RequestParam(value = Constants.category, required = true) String category,
        @RequestParam(value = Constants.regional, required = true) String regional,
        @RequestParam(value = Constants.subCategory, required = true) String subCategory
) throws Exception {


    Map<String, Object> map = null;
    try {
        List<Object[]> items = subCategoryItemsRepository.getItemsSubCategoryOthers(
                Integer.parseInt(landType),
                Integer.parseInt(category),
                Integer.parseInt(subCategory));
        List<Items> itemModal = new ArrayList<>();


        for (Object[] result : items) {
            Items pojo = new Items();
            pojo.setItemId((Integer) result[0]);
            pojo.setItemName((String) result[1]);
            pojo.setRate((String) result[2]);
            pojo.setSecurityamount((String) result[3]);
            pojo.setFee_panchayat((String) result[4]);
            itemModal.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, itemModal);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }catch(Exception ex){
        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }


}

    //getDistrict
    @RequestMapping(value = Constants.getDistrict, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getDistrict() {
        Map<String, Object> map = null;
        List<Object[] > districts = districtRepository.getDistricts();
        List<DistrictModal> districtModal = new ArrayList<>();


        for (Object[] result : districts) {
            DistrictModal pojo = new DistrictModal();
            pojo.setDistrictId((Integer) result[0]);
            pojo.setDistrictName((String) result[1]);
            districtModal.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, districtModal);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    //getArea
    @RequestMapping(value = Constants.getArea, method = RequestMethod.GET,  produces=Constants.consumesProducesJson)
    public @ResponseBody
    ResponseEntity<?> getArea(@RequestParam(value =  Constants.requestParam, required = true) String id) throws Exception {

        Map<String, Object> map = null;
        try {
            List<Object[]> areaDistrictWise = availableAreaRepository.getAvailableAreaDistrict(Integer.parseInt(id));
            List<AreaModal> areaModal = new ArrayList<>();


            for (Object[] result : areaDistrictWise) {
                AreaModal pojo = new AreaModal();
                pojo.setAreaId((Integer) result[0]);
                pojo.setAreaName((String) result[1]);
                areaModal.add(pojo);
            }

            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, areaModal);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }catch(Exception ex){
            map = new HashMap<String, Object>();
            map.put(Constants.keyResponse, Constants.ErrorAjaxResponse);
            map.put(Constants.keyMessage, Constants.valueMessage);
            map.put(Constants.keyStatus, HttpStatus.OK);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }


    }





}

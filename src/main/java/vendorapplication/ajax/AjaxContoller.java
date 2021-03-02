package vendorapplication.ajax;

import vendorapplication.modal.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vendorapplication.repositories.*;
import vendorapplication.utilities.Constants;

import java.math.BigInteger;
import java.util.*;

@Controller
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


    @RequestMapping(value = "/ajax/getRoles", method = RequestMethod.GET,  produces="application/json")
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

    @RequestMapping(value = "/ajax/getGender", method = RequestMethod.GET,  produces="application/json")
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
    @RequestMapping(value = "/ajax/getState", method = RequestMethod.GET,  produces="application/json")
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
    @RequestMapping(value = "/ajax/getDistrictsViaState", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    ResponseEntity<?> getDistrictsViaState(@RequestParam(value = "id", required = true) String id) throws Exception {


        Map<String, Object> map = null;
        List<Object[] > districtsObject = districtRepository.getDistrictsViaId(Integer.parseInt(id));
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


    }

    //getBlocks
    @RequestMapping(value = "/ajax/getBlocks", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    ResponseEntity<?> getBlocks(@RequestParam(value = "id", required = true) String id) throws Exception {


        Map<String, Object> map = null;
        List<Object[] > blockObjects = blockRepository.getBlocksViaDistrict(Integer.parseInt(id));
        List<BlockModal> blockModals = new ArrayList<>();


        for (Object[] result : blockObjects) {
            BlockModal pojo = new BlockModal();
            pojo.setBlockId((Integer) result[0]);
            pojo.setBlockName((String) result[1]);
            blockModals.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, blockModals);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    //getTehsils
    @RequestMapping(value = "/ajax/getTehsils", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    ResponseEntity<?> getTehsils(@RequestParam(value = "id", required = true) String id) throws Exception {


        Map<String, Object> map = null;
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


    }

    //getWardPanchayat
    @RequestMapping(value = "/ajax/getWardPanchayat", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    ResponseEntity<?> getWardPanchayat(@RequestParam(value = "id", required = true) String id) throws Exception {


        Map<String, Object> map = null;
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


    }


    //getNationality
    @RequestMapping(value = "/ajax/getNationality", method = RequestMethod.GET,  produces="application/json")
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
    @RequestMapping(value = "/ajax/getNationalRegional", method = RequestMethod.GET,  produces="application/json")
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
    @RequestMapping(value = "/ajax/getLandType", method = RequestMethod.GET,  produces="application/json")
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

    @RequestMapping(value = "/ajax/getrolesVendor", method = RequestMethod.GET,  produces="application/json")
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
    @RequestMapping(value = "/ajax/getVendor", method = RequestMethod.GET,  produces="application/json")
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
        @RequestMapping(value = "/ajax/getVendorCategory", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    ResponseEntity<?> getVendorCategory(@RequestParam(value = "id", required = true) String id) throws Exception {


            Map<String, Object> map = null;
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


    }

    //getItemsviaSubCategories
    @RequestMapping(value = "/ajax/getItemsviaSubCategories", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    ResponseEntity<?> getItemsviaSubCategories(
            @RequestParam(value = "nationality", required = true) String nationality,
            @RequestParam(value = "landType", required = true) String landType,
            @RequestParam(value = "regional", required = true) String regional,
            @RequestParam(value = "category", required = true) String category,
            @RequestParam(value = "subCategory", required = true) String subCategory
             ) throws Exception {


        Map<String, Object> map = null;
        List<Object[] > items = subCategoryItemsRepository.getItemsSubCategory(
                Integer.parseInt(nationality),
                Integer.parseInt(landType),
                Integer.parseInt(regional),
                Integer.parseInt(category),
                Integer.parseInt(subCategory));
        List<Items> itemModal = new ArrayList<>();


        for (Object[] result : items) {
            Items pojo = new Items();
            pojo.setItemId((Integer) result[0]);
            pojo.setItemName((String) result[1]);
            pojo.setRate((String)result[2]);
            pojo.setSecurityamount((String)result[3]);
            itemModal.add(pojo);
        }

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, itemModal);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);


    }

    //getDistrict
    @RequestMapping(value = "/ajax/getDistrict", method = RequestMethod.GET,  produces="application/json")
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
    @RequestMapping(value = "/ajax/getArea", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    ResponseEntity<?> getArea(@RequestParam(value = "id", required = true) String id) throws Exception {


        Map<String, Object> map = null;
        List<Object[] > areaDistrictWise = availableAreaRepository.getAvailableAreaDistrict(Integer.parseInt(id));
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


    }





}

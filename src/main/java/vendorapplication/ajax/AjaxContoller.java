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

import java.awt.geom.Area;
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
    VendorRepository vendorRepository;

    @Autowired
    VendorTypeRepository vendorTypeRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    AvailableAreaRepository availableAreaRepository;



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
        List<Object[] > vendors = vendorRepository.getVendors();
        List<VendorModal> vendorModal = new ArrayList<>();


        for (Object[] result : vendors) {
            VendorModal pojo = new VendorModal();
            pojo.setVendorId((Integer) result[0]);
            pojo.setVendorName((String) result[1]);
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
            List<Object[] > vendorsCategorys = vendorTypeRepository.getVendorCategory(Integer.parseInt(id));
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

package vendorapplication.services;


import vendorapplication.entities.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.DistrictRepository;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    public DistrictRepository getDistrictRepository() {
        return districtRepository;
    }

    public void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<District> getDistricts(){
        List<District> TypeList = null;
        try {
            TypeList = districtRepository.getDistrict();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error== getting the UserType");
        }
        return TypeList;
    }
}

package vendorapplication.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vendorapplication.entities.DistrictEntity;
import vendorapplication.entities.GenderEntity;
import vendorapplication.entities.StateEntity;
import vendorapplication.modal.DistrictModal;
import vendorapplication.modal.StateModal;
import vendorapplication.repositories.DistrictRepository;
import vendorapplication.repositories.StateRepository;
import vendorapplication.services.GenderService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class VendorManagementApplicationTests {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    DistrictRepository districtRepository;


        @Test
    public void getStates() {

            List<Object[] > districts = stateRepository.getStates();
            List<StateModal> stateModal = new ArrayList<>();


            for (Object[] result : districts) {
                StateModal pojo = new StateModal();
                pojo.setStateId((Integer) result[0]);
                pojo.setStateName((String) result[1]);
                stateModal.add(pojo);
            }
            System.out.println(stateModal.toString());
        }

    @Test
    public void getDistricts() {

        List<DistrictEntity> districts = districtRepository.getDistrictsViaId(9);
//        List<DistrictModal> districtModals = new ArrayList<>();
//
//
//        for (Object[] result : districts) {
//            DistrictModal pojo = new DistrictModal();
//            pojo.setDistrictId((Integer) result[0]);
//            pojo.setDistrictName((String) result[1]);
//            districtModals.add(pojo);
//        }
        System.out.println(districts.toString());
        System.out.println(districts.get(1).getStateEntity().getStateName());
      //  System.out.println(districts.get(1).gets);
    }
}

package vendorapplication.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import vendorapplication.entities.*;
import vendorapplication.modal.DistrictModal;
import vendorapplication.modal.StateModal;
import vendorapplication.repositories.DistrictRepository;
import vendorapplication.repositories.RolesRepository;
import vendorapplication.repositories.StateRepository;
import vendorapplication.repositories.UserRepository;
import vendorapplication.services.GenderService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class VendorManagementApplicationTests {

//    @Autowired
//    RolesRepository rolesRepository;
//
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    @Transactional
//    @Rollback(value = false)
//    void createUser(){
//
//        UserEntity user1 = new UserEntity();
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        user1.setUsername("kush");
//        user1.setFirstName("Kush");
//        user1.setLastName("Dhawan");
//        user1.setEmail("kushkumardhawan@gmail.com");
//        user1.setpAddress("Dhawan Lodge Shankli Shimla");
//
//        GenderEntity genderEntity  = new GenderEntity();
//        genderEntity.setGenderId(1);
//        user1.setGenderID(genderEntity);
//
//        StateEntity state = new StateEntity();
//        state.setStateID(9);
//        user1.setState(state);
//
//        DistrictEntity districtEntity  =  new DistrictEntity();
//        districtEntity.setDistrictId(202);
//        user1.setDistrict(districtEntity);
//
//        BlocksEntity block =  new BlocksEntity();
//        block.setDistrictId(68);
//        user1.setBlock(block);
//
//        TehsilEntity tehsilEntity = new TehsilEntity();
//        tehsilEntity.setDistrictId(49);
//        user1.setTehsil(tehsilEntity);
//
//        GPEntity gp = new GPEntity();
//        gp.setPanchayatId(3085);
//        user1.setGrampanchayat(gp);
//
//
//        user1.setDeleted(false);
//        user1.setPassword(encoder.encode("Demo@123"));
//        user1.setMobileNumber(9459619235L);
//        user1.setAge(31);
//        user1.setActive(true);
//
//        Optional<RolesEntity> role = rolesRepository.findById(1L);
//		List<RolesEntity> list = new ArrayList<>();
//		list.add(role.get());
//        user1.setRoles(list);
//
//
//	 userRepository.save(user1);
//	}
}

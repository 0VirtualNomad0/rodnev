package vendorapplication.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.xml.sax.SAXException;
import vendorapplication.entities.BlocksEntity;
import vendorapplication.entities.UserEntity;
import vendorapplication.modal.BlockModal;
import vendorapplication.repositories.blocks.BlockRepository;
import vendorapplication.security.EncryptDecrypt;
import vendorapplication.services.UserService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest
public class VendorManagementApplicationTests {


    @Autowired
    UserService userService;

    @Autowired
    BlockRepository blockRepository;

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


//      @Test
//    public  void checkCrypto() throws ParserConfigurationException, IOException, SAXException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
//
//          EncryptDecrypt AES = new EncryptDecrypt();
//
//           String userData = "{\n" +
//                   "  \"username\": \"kush2\",\n" +
//                   "  \"password\": \"Demo@123\"\n" +
//                   "}";
//
//          System.out.println("\n\n\t");
//          String encryptFile = AES.encrypt(userData);
//          System.out.println(" Encryption of File:-  " + encryptFile);
//          System.out.println("\n\n\t");
//          String decryptFile = AES.decrypt(encryptFile);
//          System.out.println("Decryption of File:- " + decryptFile);
//
//      }

//    @Test
//    public  void getBlocks()  {
//
//        List<BlockModal> blocks = blockRepository.getBlocksViaDitricts(196,true,false);
//        System.out.println(blocks.toString());
//
//        List<BlockModal> active_blocks = blockRepository.getAllActiveBlocks(true, false);
//        System.out.println(active_blocks.toString());
//
//
//    }




//@Test
//    public void checkUsernamrAndPassword() {
//
//    String username = "kush";
//    String password = "Demo@123";
//
//
//
//    UserEntity user = userService.getUserDetailsViaUsername(username);
//    System.out.println(user.toString());
//
//    PasswordEncoder encoder = new BCryptPasswordEncoder();
//    System.out.println(encoder.encode(password));
//
//    boolean isPasswordMatch = encoder.matches(password, user.getPassword());
//    System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
//
//
//
//
//
//
//}




}

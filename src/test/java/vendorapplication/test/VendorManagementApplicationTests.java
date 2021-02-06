package vendorapplication.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vendorapplication.entities.GenderEntity;
import vendorapplication.services.GenderService;

import java.util.List;

@SpringBootTest
public class VendorManagementApplicationTests {

    @Autowired
    GenderService genderService;


        @Test
    public void getGenders() {
            List<GenderEntity> genderList = genderService.getGenders();
            System.out.println(genderList.toString());
        }
}

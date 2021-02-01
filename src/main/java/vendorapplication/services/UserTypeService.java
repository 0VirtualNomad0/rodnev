package vendorapplication.services;


import vendorapplication.entities.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.UserTypeRepository;

import java.util.List;

@Service
public class UserTypeService {

    @Autowired
   private UserTypeRepository userTypeRepository;

    public UserTypeRepository getUserTypeRepository() {
        return userTypeRepository;
    }

    public void setUserTypeRepository(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public List<UserType> getActiveUserType(){
        List<UserType> userTypeList = null;
        try {
            userTypeList = userTypeRepository.getActiveTypeUser();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error== getting the UserType");
        }
        return userTypeList;
    }
}

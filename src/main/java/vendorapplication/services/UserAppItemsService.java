package vendorapplication.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.UserAppItemsEntity;
import vendorapplication.repositories.userappitems.UserAppItemsRepository;

import java.util.List;

@Service
public class UserAppItemsService {


    @Autowired
    UserAppItemsRepository userAppItemsRepository;


    public void saveData(List<UserAppItemsEntity> list){
        userAppItemsRepository.saveAll(list);

    }

    public void saveDataSingle(UserAppItemsEntity datax) {
        userAppItemsRepository.save(datax);
    }
}

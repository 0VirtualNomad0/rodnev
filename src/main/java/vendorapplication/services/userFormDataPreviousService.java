package vendorapplication.services;


import vendorapplication.entities.userFormDataPreviousServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.userFormDataPreviousServiceRepository;

import java.util.List;

@Service
public class userFormDataPreviousService {

    @Autowired
    vendorapplication.repositories.userFormDataPreviousServiceRepository userFormDataPreviousServiceRepository;

    public userFormDataPreviousServiceRepository getUserFormDataPreviousServiceRepository() {
        return userFormDataPreviousServiceRepository;
    }

    public void setUserFormDataPreviousServiceRepository(userFormDataPreviousServiceRepository userFormDataPreviousServiceRepository) {
        this.userFormDataPreviousServiceRepository = userFormDataPreviousServiceRepository;
    }


    public void saveData(List<userFormDataPreviousServiceEntity> list){
         userFormDataPreviousServiceRepository.saveAll(list);

    }
}

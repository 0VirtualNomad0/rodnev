package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.UserPermissionsEntity;
import vendorapplication.repositories.UserPermissionsRepository;

@Service
public class UserPermissionsService {

    @Autowired
    UserPermissionsRepository userPermissionsRepository;

    public UserPermissionsEntity addPermission(UserPermissionsEntity permissionsEntity) {
        return  userPermissionsRepository.save(permissionsEntity);
    }
}

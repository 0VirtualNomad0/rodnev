package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.UserPermissionsEntity;
import vendorapplication.repositories.UserPermissionsRepository;

import java.util.List;

@Service
public class UserPermissionsService {

    @Autowired
    UserPermissionsRepository userPermissionsRepository;

    public UserPermissionsEntity addPermission(UserPermissionsEntity permissionsEntity) {
        return  userPermissionsRepository.save(permissionsEntity);
    }

    /**
     *
     * @param mobile
     * @param appId
     * @return
     */
    public List<UserPermissionsEntity> checkApplicationStatus(int appId, String mobile) {
        return userPermissionsRepository.getAllPermissionsByAppIDandMobile(appId,mobile);
    }
}

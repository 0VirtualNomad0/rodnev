package vendorapplication.repositories.userapplication;

import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserApplicationEntity;
import java.util.List;

@Repository
public interface UserApplicationRepositoryCustom {

    List<UserApplicationEntity> getUserApplications(Long userId);
    UserApplicationEntity getUserApplication(Integer appID);
    UserApplicationEntity getUserApplicationviaAppIdUserID(Integer appID,Integer userId);
    Integer getApplicationsCount();
    Integer getApprovedApplicationsRole(Integer stateId, Integer districtId, String appStatus);
    Integer getApplicationsCountRole(Integer stateId, Integer districtId);
    Integer getApplicationsCountRolePCB(Integer stateId, Integer districtId, Integer appId);
    Integer getApprovedApplicationsRolePCB(Integer stateId, Integer districtId, String appStatus, Integer appId);
    Integer getApprovedApplications(String appStatus);




}

package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.repositories.userapplication.UserApplicationRepository;

import java.util.List;

@Service
public class UserApplicationService {

    @Autowired
    private UserApplicationRepository userApplicationRepository;

    public UserApplicationEntity saveApplication(UserApplicationEntity vendorApplication) {
        return userApplicationRepository.save(vendorApplication);
    }

    public List<UserApplicationEntity> getApplicationsUserId(Long id){

        return userApplicationRepository.getUserApplications(id);
    }

    //getUserApplications
    public List<Object[]> getListByUserId(Integer id){

        return userApplicationRepository.getListByUserId(id);
    }


    public UserApplicationEntity getUserApplicationViaAppId(Integer appId){

        return userApplicationRepository.findById(appId).get();
    }

    public UserApplicationEntity getUserApplicationViaAppIdUserId(Integer appId, Integer userId){

        return userApplicationRepository.getUserApplicationviaAppIdUserID(appId,userId);
    }

    public List<UserApplicationEntity> getApplications(){

        return (List<UserApplicationEntity>) userApplicationRepository.findAll();
    }



    public List<Object[]> getApplicationsLocationWise(Integer state, Integer district){
        return userApplicationRepository.getApplicationsLocationWise(state,district);
    }

    public List<Object[]> getApplicationsLocationWisePcb(Integer state, Integer district , Integer appId){
        return userApplicationRepository.getApplicationsLocationWisePcb(state,district,appId);
    }

    public int updateUserApplication(String app_id, String action) {
        return userApplicationRepository.updateApplicationByDc(Integer.parseInt(app_id), action);
    }

    //Total Applications
    public Integer getTotalApplications(){
        return userApplicationRepository.getApplicationsCount();
    }

    public Integer getApprovedApplications(String appStatus) {
        return userApplicationRepository.getApprovedApplications(appStatus);
    }


    public Integer getTotalApplicationsRole(Integer stateId, Integer districtId) {
        return userApplicationRepository.getApplicationsCountRole(stateId,districtId);
    }

    public Integer getApprovedApplicationsRole(Integer stateId, Integer districtId, String approved) {
        return userApplicationRepository.getApprovedApplicationsRole(stateId,districtId,approved);
    }

    public Integer getTotalApplicationsRolePCB(Integer stateId, Integer districtId,Integer subcategoryID) {
        return userApplicationRepository.getApplicationsCountRolePCB(stateId,districtId,subcategoryID);
    }

    public Integer getApprovedApplicationsRolePCB(Integer stateId, Integer districtId, String approved, Integer subcategoryID) {
        return userApplicationRepository.getApprovedApplicationsRolePCB(stateId,districtId,approved,subcategoryID);
    }




    public List<Object[]> getApplicationsLocationWiseStatus(Integer stateId, Integer districtId, String status) {
        return userApplicationRepository.getApplicationsLocationWiseStatus(stateId,districtId,status);
    }

    public List<Object[]> getApplicationsLocationWiseStatusPcb(Integer stateId, Integer districtId, String status, Integer appId) {
        return userApplicationRepository.getApplicationsLocationWiseStatusPcb(stateId,districtId,status, appId);
    }
}

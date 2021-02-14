package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import vendorapplication.entities.UserApplicationEntity;
import vendorapplication.repositories.UserApplicationRepository;

import javax.persistence.Cacheable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserApplicationService {

    @Autowired
    private UserApplicationRepository userApplicationRepository;

    public UserApplicationEntity saveUser(UserApplicationEntity vendorApplication) {
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

    public List<UserApplicationEntity> getApplications(){

        return (List<UserApplicationEntity>) userApplicationRepository.findAll();
    }

    public int updateBdoAction(String action, String comments, Integer appID, Date date){
        return userApplicationRepository.updateBdoAction(action,comments,appID,date);
    }

    public int updateDfoAction(String action, String comments, Integer appID, Date date){
        return userApplicationRepository.updateDfoAction(action,comments,appID,date);
    }

    public int updateDcAction(String action, String comments, Integer appID, Date date){
        return userApplicationRepository.updateDcAction(action,comments,appID,date);
    }

    public List<Object[]> getBodDfoDashboard(){
        return userApplicationRepository.getListByUsers();
    }
}

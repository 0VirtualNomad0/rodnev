package vendorapplication.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserApplicationEntity;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UserApplicationRepository extends CrudRepository<UserApplicationEntity,Integer> {

    @Query(value = "SELECT *  from public.user_application where user_id =:userId AND active = true  order by createddate desc", nativeQuery = true)
    List<UserApplicationEntity> getUserApplications(@Param("userId")Long userId);

    @Query(value = "SELECT app_id, app_action_dc, app_dc_date, app_action_dfo, app_dfo_date, app_action_bdo, app_bdo_date,user_application.createddate,ventype_name, vendortype_name  from public.user_application INNER JOIN mst_vendor ON user_application.ventype_id = mst_vendor.ventype_id INNER JOIN mst_vendortype ON user_application.vendortype_id = mst_vendortype.vendortype_id where user_id =:userId AND user_application.active = true  order by createddate desc", nativeQuery = true)
    List<Object[]> getListByUserId(@Param("userId")Integer userId);

    @Query(value = "SELECT app_id, users.firstname, users.lastname, users.mobile_number, mst_category.category_name, subcategory_name ,user_application.user_id,applicationstatus FROM user_application INNER JOIN mst_category ON user_application.category_id = mst_category.category_id INNER JOIN mst_subcategory ON user_application.subcategory_id = mst_subcategory.subcategory_id INNER JOIN users ON user_application.user_id = users.user_id WHERE user_application.state_id = :state AND user_application.district_id = :district  AND user_application.active = true  order by user_application.createddate desc", nativeQuery = true)
    List<Object[]> getApplicationsLocationWise(@Param("state")Integer state, @Param("district") Integer district);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE user_application  set applicationstatus =:action   where app_id =:app_id", nativeQuery = true )
    int updateApplicationByDc(Integer app_id, String action);

    @Query(value = "SELECT count(*) FROM user_application WHERE user_application.active = true", nativeQuery = true)
    Integer getApplicationsCount();

    @Query(value = "SELECT count(*) FROM user_application WHERE user_application.active = true AND applicationstatus =:appStatus", nativeQuery = true)
    Integer getApprovedApplications(String appStatus);

    @Query(value = "SELECT count(*) FROM user_application WHERE user_application.active = true  AND state_id =:stateId AND district_id =:districtId", nativeQuery = true)
    Integer getApplicationsCountRole(Integer stateId, Integer districtId);

    @Query(value = "SELECT count(*) FROM user_application WHERE user_application.active = true AND applicationstatus =:appStatus AND state_id =:stateId AND district_id =:districtId", nativeQuery = true)
    Integer getApprovedApplicationsRole(Integer stateId, Integer districtId, String appStatus);

    @Query(value = "SELECT app_id, users.firstname, users.lastname, users.mobile_number, mst_category.category_name, subcategory_name ,user_application.user_id,applicationstatus FROM user_application INNER JOIN mst_category ON user_application.category_id = mst_category.category_id INNER JOIN mst_subcategory ON user_application.subcategory_id = mst_subcategory.subcategory_id INNER JOIN users ON user_application.user_id = users.user_id WHERE user_application.state_id = :stateId AND user_application.district_id =:districtId  AND user_application.active = true AND user_application.applicationstatus =:status  order by user_application.createddate  desc", nativeQuery = true)
    List<Object[]> getApplicationsLocationWiseStatus(@Param("stateId") Integer stateId, @Param("districtId") Integer districtId, @Param("status") String status);

    //PCB Only In Case of Tent
    @Query(value = "SELECT count(*) FROM user_application WHERE user_application.active = true  AND state_id =:state_id AND district_id =:district_id AND subcategory_id = :appID", nativeQuery = true)
    Integer getApplicationsCountRolePCB(@Param("state_id")  Integer stateId, @Param("district_id") Integer districtId, @Param("appID")  Integer appId);

    @Query(value = "SELECT count(*) FROM user_application WHERE user_application.active = true AND applicationstatus =:appStatus AND state_id =:state_id AND district_id =:district_id AND subcategory_id = :appID", nativeQuery = true)
    Integer getApprovedApplicationsRolePCB(@Param("state_id") Integer stateId, @Param("district_id") Integer districtId, @Param("appStatus") String appStatus, @Param("appID")Integer appId);

    @Query(value = "SELECT app_id, users.firstname, users.lastname, users.mobile_number, mst_category.category_name, subcategory_name ,user_application.user_id,applicationstatus FROM user_application INNER JOIN mst_category ON user_application.category_id = mst_category.category_id INNER JOIN mst_subcategory ON user_application.subcategory_id = mst_subcategory.subcategory_id INNER JOIN users ON user_application.user_id = users.user_id WHERE user_application.state_id = :stateId AND user_application.district_id =:districtId  AND user_application.active = true AND user_application.applicationstatus =:status  AND user_application.subcategory_id =:appId order by user_application.createddate  desc", nativeQuery = true)
    List<Object[]> getApplicationsLocationWiseStatusPcb(@Param("stateId") Integer stateId, @Param("districtId") Integer districtId, @Param("status") String status , @Param("appId") Integer appID);

    @Query(value = "SELECT app_id, users.firstname, users.lastname, users.mobile_number, mst_category.category_name, subcategory_name ,user_application.user_id,applicationstatus FROM user_application INNER JOIN mst_category ON user_application.category_id = mst_category.category_id INNER JOIN mst_subcategory ON user_application.subcategory_id = mst_subcategory.subcategory_id INNER JOIN users ON user_application.user_id = users.user_id WHERE user_application.state_id = :state AND user_application.district_id = :district  AND user_application.active = true AND user_application.subcategory_id =:appID order by user_application.createddate desc", nativeQuery = true)
    List<Object[]> getApplicationsLocationWisePcb(@Param("state")Integer state, @Param("district") Integer district,@Param("appID") Integer appId);

    @Query(value = "SELECT *  from public.user_application where app_id =:appId AND active = true ", nativeQuery = true)
    UserApplicationEntity getUserApplication(@Param("appId")Integer appID);

    //PCB Only In Case of Tent
    @Query(value = "SELECT count(*) FROM user_application INNER JOIN users ON users.user_id = user_application.user_id WHERE users.mobile_number =:mobile AND user_application.active = true  AND user_application.app_id =:appId", nativeQuery = true)
    Integer countApplicationsViaAppIs(@Param("mobile") Long mobile, @Param("appId")  Integer appId);

    @Query(value = "SELECT createddate FROM user_application WHERE active = true AND app_id =:appID ", nativeQuery = true)
    Object[] getApplicationCreatedDate(@Param("appID") Integer appID);


}

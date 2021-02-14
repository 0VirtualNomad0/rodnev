package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserApplicationEntity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
//@CacheConfig(cacheNames = "userApplications")
public interface UserApplicationRepository extends CrudRepository<UserApplicationEntity,Integer> {

    @Query(value = "SELECT *  from public.user_application where user_id =:userId AND active = true  order by createddate desc", nativeQuery = true)
    List<UserApplicationEntity> getUserApplications(@Param("userId")Long userId);

    @Query(value = "SELECT app_id, app_action_dc, app_dc_date, app_action_dfo, app_dfo_date, app_action_bdo, app_bdo_date,user_application.createddate,ventype_name, vendortype_name  from public.user_application INNER JOIN mst_vendor ON user_application.ventype_id = mst_vendor.ventype_id INNER JOIN mst_vendortype ON user_application.vendortype_id = mst_vendortype.vendortype_id where user_id =:userId AND user_application.active = true  order by createddate desc", nativeQuery = true)
    List<Object[]> getListByUserId(@Param("userId")Integer userId);

    @Query(value = "SELECT app_id, app_action_dc, app_dc_date, app_action_dfo, app_dfo_date, app_action_bdo, app_bdo_date,user_application.createddate,ventype_name, vendortype_name, firstname  from public.user_application INNER JOIN mst_vendor ON user_application.ventype_id = mst_vendor.ventype_id INNER JOIN mst_vendortype ON user_application.vendortype_id = mst_vendortype.vendortype_id INNER JOIN users ON user_application.user_id = users.user_id where  user_application.app_action_dfo='P' OR user_application.app_action_bdo='P' or user_application.app_action_dc='P'  AND user_application.active = true  order by createddate desc", nativeQuery = true)
    List<Object[]> getListByUsers();

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE user_application  set app_action_bdo =:bdo_action, bdo_comments =:bdo_comments , app_bdo_date = :updatedDate  where app_id =:app_id", nativeQuery = true )
    int updateBdoAction(@Param("bdo_action") String action, @Param("bdo_comments") String bdoComments, @Param("app_id") Integer appId , @Param("updatedDate") Date date);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE user_application  set app_action_dfo =:dfo_action, dfo_comments =:dfo_comments , app_dfo_date = :updatedDate  where app_id =:app_id", nativeQuery = true )
    int updateDfoAction(@Param("dfo_action") String action, @Param("dfo_comments") String bdoComments, @Param("app_id") Integer appId , @Param("updatedDate") Date date);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE user_application  set app_action_dc =:dc_action, dc_comments =:dc_comments , app_dc_date = :updatedDate  where app_id =:app_id", nativeQuery = true )
    int updateDcAction(@Param("dc_action") String action, @Param("dc_comments") String bdoComments, @Param("app_id") Integer appId , @Param("updatedDate") Date date);




}

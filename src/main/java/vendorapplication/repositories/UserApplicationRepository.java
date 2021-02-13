package vendorapplication.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserApplicationEntity;

import java.util.Date;
import java.util.List;

@Repository

public interface UserApplicationRepository extends CrudRepository<UserApplicationEntity,Integer> {

    @Query(value = "SELECT *  from public.user_application where user_id =:userId AND active = true  order by createddate desc", nativeQuery = true)
    List<UserApplicationEntity> getUserApplications(@Param("userId")Long userId);

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

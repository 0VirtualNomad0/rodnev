package vendorapplication.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vendorapplication.entities.UserEntity;
import vendorapplication.modal.LoggedInUserLocationSession;

import java.util.List;

@Repository
public interface UserRepositoryCustom {

    List<LoggedInUserLocationSession> getUserGeoData( String username_);
    UserEntity findByMobileNumber(Long mobile);
    UserEntity getUserDetails(Long mobile );


}

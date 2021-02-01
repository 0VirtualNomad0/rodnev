package vendorapplication.CustomLogin;


import vendorapplication.entities.UserEntity;

public interface CustomUserService {


    void save(UserEntity user);
    UserEntity findByUsername(String userName);
    UserEntity findByMobileNumber(String mobileNumber);
}

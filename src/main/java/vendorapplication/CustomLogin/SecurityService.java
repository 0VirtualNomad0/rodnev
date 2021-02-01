package vendorapplication.CustomLogin;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String userName, String password);
}
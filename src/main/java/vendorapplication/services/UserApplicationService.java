package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.UserApplicationRepository;

@Service
public class UserApplicationService {

    @Autowired
    private UserApplicationRepository userApplicationRepository;
}

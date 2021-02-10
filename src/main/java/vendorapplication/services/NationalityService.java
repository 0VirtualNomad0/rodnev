package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.NationalityRepository;

@Service
public class NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;
}

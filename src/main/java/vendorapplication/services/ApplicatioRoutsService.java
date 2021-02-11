package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.ApplicationRoutesRepository;

@Service
public class ApplicatioRoutsService {

    @Autowired
    private ApplicationRoutesRepository applicationRoutesRepository;
}

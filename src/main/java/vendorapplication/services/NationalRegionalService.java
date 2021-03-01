package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.NationalRegionalRepository;

@Service
public class NationalRegionalService {

    @Autowired
    NationalRegionalRepository nationalRegionalRepository;
}

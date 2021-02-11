package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.ApplicationRoutesEntity;
import vendorapplication.repositories.ApplicationRoutesRepository;

import java.util.List;

@Service
public class ApplicatioRoutsService {

    @Autowired
    private ApplicationRoutesRepository applicationRoutesRepository;

    public void saveData(List<ApplicationRoutesEntity> availedServices) {
        applicationRoutesRepository.saveAll(availedServices);
    }
}

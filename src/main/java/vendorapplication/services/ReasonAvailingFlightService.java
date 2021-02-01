package vendorapplication.services;


import vendorapplication.entities.ReasonAvailingFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.ReasonAvailingFlightRepository;

import java.util.List;

@Service
public class ReasonAvailingFlightService {

    @Autowired
    ReasonAvailingFlightRepository reasonAvailingFlightRepository;

    public ReasonAvailingFlightRepository getReasonAvailingFlightRepository() {
        return reasonAvailingFlightRepository;
    }

    public void setReasonAvailingFlightRepository(ReasonAvailingFlightRepository reasonAvailingFlightRepository) {
        this.reasonAvailingFlightRepository = reasonAvailingFlightRepository;
    }

    public List<ReasonAvailingFlight> getReasonAvailingFlight(){
        List<ReasonAvailingFlight> TypeList = null;
        try {
            TypeList = reasonAvailingFlightRepository.getReasonAvailingFlight();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error== getting the UserType");
        }
        return TypeList;
    }
}

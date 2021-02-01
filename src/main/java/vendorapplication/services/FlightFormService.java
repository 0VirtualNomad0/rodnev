package vendorapplication.services;


import vendorapplication.entities.FlightFormEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.FlightFormRepository;

import java.util.List;

@Service
public class FlightFormService {

    @Autowired
    FlightFormRepository flightFormRepository;

    public FlightFormRepository getFlightFormRepository() {
        return flightFormRepository;
    }

    public void setFlightFormRepository(FlightFormRepository flightFormRepository) {
        this.flightFormRepository = flightFormRepository;
    }


    public FlightFormEntity saveUser(FlightFormEntity entity) {
        return flightFormRepository.save(entity);

    }

    public List<FlightFormEntity> getApplications(int location, int helipad, String date, String status) {
        return  flightFormRepository.fetchApplications(location,helipad,date, status);
    }

    public List<Object[]> getProjectionApplicationList(int location, int helipad, String date, String status){
        return flightFormRepository.getApplicationProjection(location,helipad,date,status);
    }

    public FlightFormEntity getDataByUserID(int id){
        return flightFormRepository.getUserDetialsByID(id);
    }

    public List<Object[]> getAllApplications(){
         return flightFormRepository.getApplicationProjectionNoDate();
    }

    public List<Object[]> checkApplicationStatus(int id) {return flightFormRepository.checkStatus(id);}

    public FlightFormEntity getCompleteApplication(int id){
        return flightFormRepository.getApplicationViaUserID(id);
    }
}

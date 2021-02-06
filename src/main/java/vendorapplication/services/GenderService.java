package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import vendorapplication.entities.GenderEntity;
import vendorapplication.repositories.GenderRepository;

import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    //@Cacheable("genders")
    public List<GenderEntity> getGenders(){
        return genderRepository.getGender();
    }
}

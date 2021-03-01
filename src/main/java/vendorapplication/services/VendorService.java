package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.RolesEntity;
import vendorapplication.entities.VendorEntity;
import vendorapplication.repositories.VendorRepository;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public VendorEntity checkCategory(String categoryName) {
        return vendorRepository.checkCategory(categoryName);
    }

    public VendorEntity saveRole(VendorEntity rolesEntity) {
        VendorEntity entity = vendorRepository.save(rolesEntity);
        return entity;
    }
}

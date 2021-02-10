package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.VendorTypeRepository;

@Service
public class VendorTypeService {

    @Autowired
    private VendorTypeRepository vendorTypeRepository;
}

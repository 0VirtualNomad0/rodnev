package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vendorapplication.entities.OTPEntity;
import vendorapplication.repositories.OTPRepository;

@Service
public class OTPService {

    @Autowired
    OTPRepository otpRepository;

    public OTPRepository getOtpRepository() {
        return otpRepository;
    }

    public void setOtpRepository(OTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public void saveOTP(OTPEntity otp){
        otpRepository.save(otp);
    }
}

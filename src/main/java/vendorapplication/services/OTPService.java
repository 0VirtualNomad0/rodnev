package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.OTPEntity;
import vendorapplication.repositories.otp.OTPRepository;

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

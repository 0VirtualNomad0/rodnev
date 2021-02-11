package vendorapplication.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vendorapplication.CustomLogin.CustomUserService;
import vendorapplication.form.RegisterUser;
import vendorapplication.form.vendorApplicationForm;
import vendorapplication.utilities.Constants;

@Component
public class VendorApplicationFormValidator implements Validator {
    @Autowired
    private CustomUserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return vendorApplicationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        vendorApplicationForm user = (vendorApplicationForm) o;


        if(user.getNationality().equalsIgnoreCase("0")){
            errors.rejectValue("nationality", "Select.vendorform.nationality");
        }

        if(user.getVendor().equalsIgnoreCase("0")){
            errors.rejectValue("vendor", "Select.vendorform.vendor");
        }
        if(user.getVendorType().equalsIgnoreCase("0")){
            errors.rejectValue("vendorType", "Select.vendorform.vendorType");
        }
        if(user.getDistrict().equalsIgnoreCase("0")){
            errors.rejectValue("district", "Select.vendorform.district");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationAvailable", "NotEmpty");





    }
}
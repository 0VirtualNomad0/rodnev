package vendorapplication.validators;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vendorapplication.form.vendorApplicationForm;

@Component
public class SurveyFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return vendorApplicationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        vendorApplicationForm applicationForm = (vendorApplicationForm) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "p_address", "NotEmpty");

        if (applicationForm.getGender().equalsIgnoreCase("0")) {
            errors.rejectValue("gender", "Select.vendorform.gender");
        }
        if ( applicationForm.getLocalBlock() == null || applicationForm.getLocalBlock().equalsIgnoreCase("0")) {
            errors.rejectValue("localBlock", "Select.vendorform.localBlock");
        }
        if (applicationForm.getLocalDistrict().equalsIgnoreCase("0")) {
            errors.rejectValue("localDistrict", "Select.vendorform.localDistrict");
        }
        if (applicationForm.getLocalgp() == null || applicationForm.getLocalgp().equalsIgnoreCase("0")) {
            errors.rejectValue("localgp", "Select.vendorform.localgp");
        }

    }
}
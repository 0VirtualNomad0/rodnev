package vendorapplication.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vendorapplication.form.CheckStatusForm;

@Component
public class CheckStatusValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return  CheckStatusValidator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {

        CheckStatusForm checkStatus = (CheckStatusForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "appId", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty");
        if (checkStatus.getAppId()== null || checkStatus.getAppId().isEmpty()) {
            errors.rejectValue("applicationId", "Size.checkStatus.appId");
        }

    }
}
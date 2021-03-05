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
        vendorApplicationForm applicatonForm = (vendorApplicationForm) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "p_address", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loc_address", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromDate", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toDate", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalDays", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "captcha", "NotEmpty");


        if(applicatonForm.getGender().equalsIgnoreCase("0")){
            errors.rejectValue("gender", "Select.vendorform.gender");
        }

        if(applicatonForm.getLocalBlock().equalsIgnoreCase("0")){
            errors.rejectValue("localBlock", "Select.vendorform.localBlock");
        }
        if(applicatonForm.getLocalDistrict().equalsIgnoreCase("0")){
            errors.rejectValue("localDistrict", "Select.vendorform.localDistrict");
        }
        if(applicatonForm.getLocalTehsil().equalsIgnoreCase("0")){
            errors.rejectValue("localTehsil", "Select.vendorform.localTehsil");
        }
        if(applicatonForm.getLocalgp().equalsIgnoreCase("0")){
            errors.rejectValue("localgp", "Select.vendorform.localgp");
        }

        if(applicatonForm.getVlocalgp().equalsIgnoreCase("0")){
            errors.rejectValue("vlocalgp", "Select.vendorform.vlocalgp");
        }

        if(applicatonForm.getVlocalDistrict().equalsIgnoreCase("0")){
            errors.rejectValue("vlocalDistrict", "Select.vendorform.vlocalDistrict");
        }

        if(applicatonForm.getVlocalBlock().equalsIgnoreCase("0")){
            errors.rejectValue("vlocalBlock", "Select.vendorform.vlocalBlock");
        }

        if(applicatonForm.getVlocalTehsil().equalsIgnoreCase("0")){
            errors.rejectValue("vlocalDistrict", "Select.vendorform.vlocalTehsil");
        }

        if(applicatonForm.getNationality().equalsIgnoreCase("0")){
            errors.rejectValue("nationality", "Select.vendorform.vlocalTehsil");
        }

        if(applicatonForm.getVendor().equalsIgnoreCase("0")){
            errors.rejectValue("vendor", "Select.vendorform.vlocalTehsil");
        }

        if(applicatonForm.getVendorType().equalsIgnoreCase("0")){
            errors.rejectValue("vendorType", "Select.vendorform.vlocalTehsil");
        }

        if(applicatonForm.getLandType().equalsIgnoreCase("0")){
            errors.rejectValue("landType", "Select.vendorform.vlocalTehsil");
        }

//        if(applicatonForm.getItem().equalsIgnoreCase("0")){
//            errors.rejectValue("item", "Select.vendorform.item");
//        }


        if(applicatonForm.getIdentityDoc().getSize()!=0){

            if(getFileSizeMb(applicatonForm.getIdentityDoc().getSize())>5){
                errors.rejectValue("identityDoc", "Size.vendorform.identityDoc");
            }
        }

        if(applicatonForm.getPhotoDoc().getSize()!=0){

            if(getFileSizeMb(applicatonForm.getPhotoDoc().getSize())>5){
                errors.rejectValue("photoDoc", "Size.vendorform.photoDoc");
            }
        }




    }

    private long getFileSizeMb(long size){
        long fileSizeInKB = size / 1024;
        long fileSizeInMB = fileSizeInKB / 1024;
        return fileSizeInMB;
    }
}
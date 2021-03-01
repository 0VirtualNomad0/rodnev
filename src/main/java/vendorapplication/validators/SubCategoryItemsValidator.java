package vendorapplication.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vendorapplication.form.SubCategoryForm;
import vendorapplication.form.SubCategoryItemsForm;
import vendorapplication.services.SubCategoryService;

@Component
public class SubCategoryItemsValidator implements Validator {

    @Autowired
    private SubCategoryService subCategoryService;

    @Override
    public boolean supports(Class<?> aClass) {
        return SubCategoryItemsForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SubCategoryItemsForm user = (SubCategoryItemsForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "security", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fee", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"itemName", "NotEmpty");

        if(user.getCategoryId().equalsIgnoreCase("0")){
            errors.rejectValue("categoryId", "Select.subCategoryItemsForm.categoryId");
        }

        if(user.getVendorType() == null){
            errors.rejectValue("vendorType", "Select.subCategoryItemsForm.vendorType");
        }

        if(user.getLandType().equalsIgnoreCase("0")){
            errors.rejectValue("landType", "Select.subCategoryItemsForm.landType");
        }

        if(user.getNationality().equalsIgnoreCase("0")){
            errors.rejectValue("nationality", "Select.subCategoryItemsForm.nationality");
        }

        if(user.getNationalRegional().equalsIgnoreCase("0")){
            errors.rejectValue("nationalRegional", "Select.subCategoryItemsForm.nationalRegional");
        }






    }
}

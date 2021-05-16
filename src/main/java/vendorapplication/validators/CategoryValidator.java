package vendorapplication.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vendorapplication.form.CategoryForm;
import vendorapplication.services.CategoryService;

@Component
public class CategoryValidator implements Validator {

    @Autowired
    private CategoryService vendorService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CategoryForm user = (CategoryForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryName", "NotEmpty");

        if (vendorService.checkCategory(user.getCategoryName())) {
            errors.rejectValue("categoryName", "Duplicate.categoryForm.categoryName");
        }






    }
}

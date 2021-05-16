package vendorapplication.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vendorapplication.form.CategoryForm;
import vendorapplication.form.SubCategoryForm;
import vendorapplication.services.CategoryService;
import vendorapplication.services.SubCategoryService;

@Component
public class SubCategoryValidator implements Validator {

    @Autowired
    private SubCategoryService subCategoryService;

    @Override
    public boolean supports(Class<?> aClass) {
        return SubCategoryForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SubCategoryForm user = (SubCategoryForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subcategoryName", "NotEmpty");

        if (subCategoryService.checkCategory(user.getSubcategoryName())) {
            errors.rejectValue("subcategoryName", "Duplicate.categoryForm.categoryName");
        }






    }
}

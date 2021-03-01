package vendorapplication.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vendorapplication.entities.*;
import vendorapplication.form.CategoryForm;
import vendorapplication.form.SubCategoryForm;
import vendorapplication.form.SubCategoryItemsForm;
import vendorapplication.services.CategoryService;
import vendorapplication.services.SubCategoryItemsService;
import vendorapplication.services.SubCategoryService;
import vendorapplication.validators.CategoryValidator;
import vendorapplication.validators.SubCategoryItemsValidator;
import vendorapplication.validators.SubCategoryValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class SubCategoryController {


    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    SubCategoryItemsService subCategoryItemsService;

    @Autowired
    SubCategoryValidator subCategoryValidator;

    @Autowired
    SubCategoryItemsValidator subCategoryItemsValidator;

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @RequestMapping(value = "/addsubcategories", method = RequestMethod.GET)
    public String createRole(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
        model.addAttribute("subCategoryForm", new SubCategoryForm());
        return "subcategories";
       }
    }



    //saveSubCategory
    @RequestMapping(value = "/saveSubCategory", method = RequestMethod.POST)
    public String saveSubCategory(@ModelAttribute("subCategoryForm") SubCategoryForm subCategoryForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
        subCategoryValidator.validate(subCategoryForm, bindingResult);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            if (bindingResult.hasErrors()) {
                return "subcategories";
            }
            try {
                SubCategoryEntity rolesEntity = new SubCategoryEntity();
                CategoryEntity category = new CategoryEntity();
                rolesEntity.setActive(true);
                rolesEntity.setSubCategoryName(subCategoryForm.getSubcategoryName());
                category.setCategoryID(subCategoryForm.getCategoryId());
                rolesEntity.setCategoryId(category);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Date date = new Date(timestamp.getTime());
                rolesEntity.setCreatedDate(date);
                SubCategoryEntity savedData = subCategoryService.saveSubCategory(rolesEntity);
                subCategoryForm.setSubcategoryName("");
                request.getSession().setAttribute("successMessage", savedData.getSubCategoryName() + " Sub Category Successfully Saved. ID is" + savedData.getSubCategoryId());
                return "subcategories";
            } catch (Exception ex) {
                subCategoryForm.setSubcategoryName("");
                model.addAttribute("serverError", ex.toString());
                return "subcategories";
            }
        }


    }

    @RequestMapping(value = "/subcategoriesitems", method = RequestMethod.GET)
    public String subcategoriesitems(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            model.addAttribute("subCategoryItemsForm", new SubCategoryItemsForm());
            return "subcategoriesitems";
        }
    }


    //addsubcategoriesitems
    @RequestMapping(value = "/addsubcategoriesitems", method = RequestMethod.POST)
    public String addsubcategoriesitems(@ModelAttribute("subCategoryItemsForm") SubCategoryItemsForm subCategoryItemsForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
        subCategoryItemsValidator.validate(subCategoryItemsForm, bindingResult);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            if (bindingResult.hasErrors()) {
                return "subcategoriesitems";
            }
            try {
                SubCategoryItemsEntity rolesEntity = new SubCategoryItemsEntity();

                CategoryEntity category = new CategoryEntity();
                category.setCategoryID(Integer.parseInt(subCategoryItemsForm.getCategoryId()));
                SubCategoryEntity subCategory =  new SubCategoryEntity();
                subCategory.setSubCategoryId(Integer.parseInt(subCategoryItemsForm.getVendorType()));
                LandTypeEntity landType = new LandTypeEntity();
                landType.setLandTypeId(Integer.parseInt(subCategoryItemsForm.getLandType()));
                NationalityEntity nationalityEntity = new NationalityEntity();
                nationalityEntity.setNationalityId(Integer.parseInt(subCategoryItemsForm.getNationality()));
                NationalRegionalEntity nationalRegional = new NationalRegionalEntity();
                nationalRegional.setNationalRegionalId(Integer.parseInt(subCategoryItemsForm.getNationalRegional()));

                rolesEntity.setActive(true);
                rolesEntity.setCategory(category);
                rolesEntity.setSubCategory(subCategory);
                rolesEntity.setLandType(landType);
                rolesEntity.setNationality(nationalityEntity);
                rolesEntity.setNationalRegional(nationalRegional);
                rolesEntity.setFee(subCategoryItemsForm.getFee());
                rolesEntity.setSecurityAmount(subCategoryItemsForm.getSecurity());
                rolesEntity.setItemName(subCategoryItemsForm.getItemName());

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Date date = new Date(timestamp.getTime());
                rolesEntity.setCreatedDate(date);
                SubCategoryItemsEntity savedData = subCategoryItemsService.saveSubCategoryItems(rolesEntity);
                subCategoryItemsForm.setItemName("");
                subCategoryItemsForm.setFee("");
                subCategoryItemsForm.setSecurity("");
                request.getSession().setAttribute("successMessage", savedData.getItemName() + " Sub Category Successfully Saved. ID is" + savedData.getItemId());
                return "subcategoriesitems";
            } catch (Exception ex) {
                subCategoryItemsForm.setItemName("");
                subCategoryItemsForm.setFee("");
                subCategoryItemsForm.setSecurity("");
                model.addAttribute("serverError", ex.toString());
                return "subcategoriesitems";
            }
        }


    }


}

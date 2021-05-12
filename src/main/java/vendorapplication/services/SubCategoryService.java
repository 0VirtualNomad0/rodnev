package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.SubCategoryEntity;
import vendorapplication.repositories.subcategory.SubCategoryRepository;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;



    public SubCategoryEntity checkCategory(String categoryName) {
        return subCategoryRepository.checkSubCategory(categoryName);
    }

    public SubCategoryEntity saveSubCategory(SubCategoryEntity rolesEntity) {
        SubCategoryEntity entity = subCategoryRepository.save(rolesEntity);
        return entity;
    }
}




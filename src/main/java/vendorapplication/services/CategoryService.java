package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.CategoryEntity;
import vendorapplication.repositories.category.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity checkCategory(String categoryName) {
        return categoryRepository.checkCategory(categoryName);
    }

    public CategoryEntity saveRole(CategoryEntity rolesEntity) {
        CategoryEntity entity = categoryRepository.save(rolesEntity);
        return entity;
    }
}

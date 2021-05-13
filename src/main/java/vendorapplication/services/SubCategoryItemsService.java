package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.entities.SubCategoryItemsEntity;
import vendorapplication.repositories.subcategoryitems.SubCategoryItemsRepository;

@Service
public class SubCategoryItemsService {

    @Autowired
    private SubCategoryItemsRepository subCategoryItemsRepository;



    public SubCategoryItemsEntity saveSubCategoryItems(SubCategoryItemsEntity rolesEntity) {
        SubCategoryItemsEntity entity = subCategoryItemsRepository.save(rolesEntity);
        return entity;
    }
}




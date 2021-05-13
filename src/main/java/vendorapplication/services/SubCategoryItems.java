package vendorapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.subcategoryitems.SubCategoryItemsRepository;

@Service
public class SubCategoryItems {

    @Autowired
    SubCategoryItemsRepository subCategoryItemsRepository;
}

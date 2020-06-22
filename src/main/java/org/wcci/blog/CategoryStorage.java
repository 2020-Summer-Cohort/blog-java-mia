package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class CategoryStorage {
    private CategoryRepository categoryRepo;

    public CategoryStorage(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


//    public Object findCategoryByName(String categoryName) {
//        return categoryRepo.findByName(categoryName);
//    }

    public Iterable<Category> findAllCategories() {
        return categoryRepo.findAll();
    }
}

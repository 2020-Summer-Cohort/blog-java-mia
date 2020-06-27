package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.entities.Category;

@Service
public class CategoryStorage {
    private CategoryRepository categoryRepo;

    public CategoryStorage(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category findCategoryByName(String name) {
        return categoryRepo.findByName(name);
    }

    public Iterable<Category> findAllCategories(){
        return categoryRepo.findAll();
    }


}

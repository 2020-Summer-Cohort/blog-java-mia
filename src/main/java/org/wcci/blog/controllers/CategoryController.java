package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.blog.storage.CategoryStorage;

@Controller
public class CategoryController {
    CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;
    }

    @GetMapping("categories/{categoryName}")
    public String showSingleCategory(@PathVariable String categoryName, Model model) {
        model.addAttribute("category", categoryStorage.findCategoryByName(categoryName));
        return "category-template";
    }
}

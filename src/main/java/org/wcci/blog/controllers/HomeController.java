package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.CategoryStorage;

@Controller
public class HomeController {
    CategoryStorage categoryStorage;

    public HomeController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/categories")
    public String showAllCategories (Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "home-template";
    }
}

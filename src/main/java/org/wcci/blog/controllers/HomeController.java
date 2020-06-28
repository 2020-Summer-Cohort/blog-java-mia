package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.HashtagStorage;

@Controller
public class HomeController {
    private HashtagStorage hashtagStorage;
    private CategoryStorage categoryStorage;
    private AuthorStorage authorStorage;

    public HomeController(HashtagStorage hashtagStorage, CategoryStorage categoryStorage, AuthorStorage authorStorage) {
        this.hashtagStorage = hashtagStorage;
        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
    }

    @GetMapping("")
    public String showHomePage(Model model) {
        return "home-template";
    }
}

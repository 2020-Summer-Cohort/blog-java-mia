package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Post;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.HashtagStorage;

@Controller
public class PostController {
    private PostStorage postStorage;
    private HashtagStorage hashtagStorage;
    private AuthorStorage authorStorage;
    private CategoryStorage categoryStorage;

    public PostController(PostStorage postStorage, HashtagStorage hashtagStorage, AuthorStorage authorStorage, CategoryStorage categoryStorage) {
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
        this.authorStorage = authorStorage;
        this.categoryStorage = categoryStorage;
    }

    @GetMapping("post/{postTitle}")
    public String showSinglePost(@PathVariable String postTitle, Model model) {
        model.addAttribute("post", postStorage.findPostByPostTitle(postTitle));
        return "post-template";
    }

    @PostMapping("/category/addPost")
    public String addAPost(String postTitle, String model, int year, String postBody, String name, String categoryName, String hashtagName){
        Category categoryToAdd = new Category(categoryName);
        categoryStorage.addCategory(categoryToAdd);
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagStorage.addAHashtagToPost(hashtagToAdd);
        Author authorToAdd = new Author(name);
        authorStorage.addAuthor(authorToAdd);
        Post postToAdd = new Post(postTitle, model, year, postBody, authorToAdd, categoryToAdd, hashtagToAdd);
        postStorage.addPost(postToAdd);
        return "redirect:/post/" + postTitle;
    }

//    @PostMapping("/post/addHashtag")
//    public String addAHashtagToPost(String hashtagName, String postTitle) {
//        if (hashtagStorage.hashtagExists(hashtagName)) {
//            Hashtag hashtagToAdd = hashtagStorage.findHashtagByHashtagName(hashtagName);
//            Post postToUpdate = postStorage.findPostByPostTitle(postTitle);
//            postToUpdate.addAHashtagToPost(hashtagToAdd);
//            postStorage.addPost(postToUpdate);
//            return "redirect:/post/" + postTitle;
//        }
//        Hashtag hashtagToAdd = new Hashtag(hashtagName);
//        hashtagStorage.addAHashtagToPost(hashtagToAdd);
//        Post postToUpdate = postStorage.findPostByPostTitle(postTitle);
//        postToUpdate.addAHashtagToPost(hashtagToAdd);
//        postStorage.addPost(postToUpdate);
//        return "redirect:/post/" + postTitle;
//    }

    @PostMapping("/post/addHashtag")
    public String addHashTagToReview(String postTitle, String hashtagName){
        if (hashtagStorage.findHashtagByHashtagName(hashtagName) != null) {
            Hashtag hashtagToAdd = hashtagStorage.findHashtagByHashtagName(hashtagName);
            Post post = postStorage.findPostByPostTitle(postTitle);
            post.addAHashtagToPost(hashtagToAdd);
            postStorage.addPost(post);
            return "redirect:/post/" + postTitle;
        }
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagStorage.addAHashtagToPost(hashtagToAdd);
        Post post = postStorage.findPostByPostTitle(postTitle);
        post.addAHashtagToPost(hashtagToAdd);
        postStorage.addPost(post);
        return "redirect:/post/" + postTitle;
    }
}
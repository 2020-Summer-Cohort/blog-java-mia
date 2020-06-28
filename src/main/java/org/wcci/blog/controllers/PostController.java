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
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.HashtagStorage;

@Controller
public class PostController {
    private PostStorage postStorage;
    private HashtagStorage hashtagStorage;

    public PostController(PostStorage postStorage, HashtagStorage hashtagStorage) {
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @GetMapping("post/{postTitle}")
    public String showSinglePost(@PathVariable String postTitle, Model model) {
        model.addAttribute("post", postStorage.findPostByPostTitle(postTitle));
        return "post-template";
    }

    @PostMapping("/addPost")
    public String addAPost(String postTitle, String model, int year, String postBody, Author author, Category category, Hashtag... hashtags){
        if (postStorage.postExists(postTitle)){
            return "redirect:/post/" + postTitle;
        }
        Post postToAdd = new Post(postTitle, model, year, postBody, author, category, hashtags);
        postStorage.addPost(postToAdd);
        return "redirect:/post/" + postTitle;
    }

    @PostMapping("/post/addHashtag")
    public String addAHashtagToPost(String hashtagName, String postTitle) {
        if (hashtagStorage.hashtagExists(hashtagName)) {
            Hashtag hashtagToAdd = hashtagStorage.findHashtagByHashtagName(hashtagName);
            Post postToUpdate = postStorage.findPostByPostTitle(postTitle);
            postToUpdate.addAHashtagToPost(hashtagToAdd);
            postStorage.addPost(postToUpdate);
            return "redirect:/post/" + postTitle;
        }
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagStorage.addAHashtagToPost(hashtagToAdd);
        Post postToUpdate = postStorage.findPostByPostTitle(postTitle);
        postToUpdate.addAHashtagToPost(hashtagToAdd);
        postStorage.addPost(postToUpdate);
        return "redirect:/post/" + postTitle;
    }
}
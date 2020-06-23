package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.PostStorage;

@Controller
public class PostController {
    PostStorage postStorage;
    private Post post;

    public PostController(PostStorage postStorage){
        this.postStorage = postStorage;
    }

    @GetMapping("posts/{postTitle}")
    public String showSingleReview(@PathVariable String postTitle, Model model) {
        model.addAttribute("post", postStorage.findPostByTitle(postTitle));
        return "post-template";
    }

//    @RequestMapping("/post")
//    public String retrievePost(Model model){
//        model.addAttribute("postToDisplay", post);
//        return "post-template";
//    }
}





//post = new Post("NA", 1993, "Turbo Help", "I'm not sure how to install a turbo.", "Ricky Bobby");
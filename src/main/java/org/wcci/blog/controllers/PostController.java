package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Post;

@Controller
public class PostController {

    private Post post;
    public PostController(){
        post = new Post("NA", 1993, "Turbo Help", "I'm not sure how to install a turbo.", "Ricky Bobby");
    }

    @RequestMapping("/post")
    public String retrievePost(Model model){
        model.addAttribute("postToDisplay", post);
        return "post-template";
    }
}

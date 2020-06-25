package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.entities.UserComment;
import org.wcci.blog.storage.HashtagStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.UserCommentStorage;

@Controller
public class PostController {
    PostStorage postStorage;
    HashtagStorage hashtagStorage;
    UserCommentStorage userCommentStorage;
    private Post post;

    public PostController(PostStorage postStorage, HashtagStorage hashtagStorage){
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
        this.userCommentStorage = userCommentStorage;
    }

    @GetMapping("posts/{postTitle}")
    public String showSinglePost(@PathVariable String postTitle, Model model) {
        model.addAttribute("post", postStorage.findPostByTitle(postTitle));
        return "post-template";
    }

    @PostMapping("/categories/post/add")
    public String addPost(String model, int year, String title, String body, String author, String hashtagName) {
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagStorage.addHashtag(hashtagToAdd);
        Post postToAdd = new Post(model, year, title, body, author);
        postStorage.addPost(postToAdd);
        return "redirect:/posts/" + post.getTitle();
    }

    @PostMapping("/post/addComment")
    public String addComment(String userComment, Post post) {
        UserComment commentToAdd = new UserComment(userComment, post);
        userCommentStorage.addComment(commentToAdd);
        return "redirect:/posts/" + post.getTitle();
    }

    @PostMapping("/categories/post/delete")
    public String removePost(Post post) {
        postStorage.deletePost(post);
        return "redirect:/";
    }

    @PostMapping("/posts/addHashtag")
    public String addHashTagToPost(String postTitle, String hashtagName){
        if (hashtagStorage.findHashtagByName(hashtagName) != null) {
            Hashtag hashtagToAdd = hashtagStorage.findHashtagByName(hashtagName);
            Post post = postStorage.findPostByTitle(postTitle);
            post.addHashtag(hashtagToAdd);
            postStorage.addPost(post);
            return "redirect:/posts/" + postTitle;
        }
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagStorage.addHashtag(hashtagToAdd);
        Post post = postStorage.findPostByTitle(postTitle);
        post.addHashtag(hashtagToAdd);
        postStorage.addPost(post);
        return "redirect:/posts/" + postTitle;
    }



//    @RequestMapping("/post")
//    public String retrievePost(Model model){
//        model.addAttribute("postToDisplay", post);
//        return "post-template";
//    }
}





//post = new Post("NA", 1993, "Turbo Help", "I'm not sure how to install a turbo.", "Ricky Bobby");
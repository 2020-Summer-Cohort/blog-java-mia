package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.blog.storage.HashtagStorage;

@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {
        this.hashtagStorage = hashtagStorage;
    }

    @GetMapping("hashtags")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        return "hashtags-template";
    }

    @GetMapping("hashtags/{hashtagName}")
    public String showASingleHashtag(@PathVariable String hashtagName, Model model) {
        model.addAttribute("hashtag", hashtagStorage.findHashtagByHashtagName(hashtagName));
        return "hashtag-template";
    }

}

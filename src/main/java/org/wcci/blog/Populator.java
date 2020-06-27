package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.UserCommentStorage;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.HashtagRepository;
import org.wcci.blog.storage.repositories.PostRepository;


@Component
public class Populator implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    HashtagRepository hashtagRepo;

    @Override
    public void run(String...args) throws Exception {
        Category maintenance = new Category("Maintenance", "This category should contain posts about general maintenance.");
        categoryRepo.save(maintenance);
        Category modifications = new Category("Modifications", "This category should contain posts about specific modifications.");
        categoryRepo.save(modifications);
        Category social = new Category("Social", "This category should contain posts about upcoming events and random Miata-related chatter.");
        categoryRepo.save(social);
        Post post1 = new Post("NB", 2001, "Oil Change", "Do I really have to take the wheel off to get to the oil filter?", "Jimmy Buffet", maintenance);
        postRepo.save(post1);
        Post post2 = new Post("NA", 1993, "Turbo Help", "I'm not sure how to install a turbo.", "Ricky Bobby", modifications);
        postRepo.save(post2);
        Post post3 = new Post("NA", 1996, "Car Meet", "We're meeting at Shell City on Tuesday at 6pm!", "Spongebob Squarepants", social);
        postRepo.save(post3);
    }
}

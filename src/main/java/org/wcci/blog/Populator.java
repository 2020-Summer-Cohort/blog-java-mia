package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.PostRepository;


@Component
public class Populator implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    PostRepository postRepo;

    @Override
    public void run(String...args) throws Exception {
        Category maintenance = new Category("Maintenance", "This category should contain posts about general maintenance.");
        Category modifications = new Category("Modifications", "This category should contain posts about specific modifications.");
        Category social = new Category("Social", "This category should contain posts about upcoming events and random Miata-related chatter.");
        categoryRepo.save(maintenance);
        categoryRepo.save(modifications);
        categoryRepo.save(social);
        Post post1 = new Post("NB", 2001, "Oil Change", "Do I really have to take the wheel off to get to the oil filter?", "Jimmy Buffet");
        Post post2 = new Post("NA", 1993, "Turbo Help", "I'm not sure how to install a turbo.", "Ricky Bobby");
        Post post3 = new Post("NA", 1996, "Car Meet", "We're meeting at Shell City on Tuesday at 6pm!", "Spongebob Squarepants");
        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
    }
}

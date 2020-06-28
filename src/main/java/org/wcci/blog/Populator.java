package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.UserCommentStorage;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.HashtagRepository;
import org.wcci.blog.storage.repositories.PostRepository;


@Component
public class Populator implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    HashtagRepository hashtagRepo;

    @Override
    public void run(String...args) throws Exception {
        Category maintenance = new Category("Maintenance");
        Category modifications = new Category("Modifications");
        Category social = new Category("Social");
        categoryRepo.save(maintenance);
        categoryRepo.save(modifications);
        categoryRepo.save(social);
        Author author1 = new Author("Jimmy Buffet");
        Author author2 = new Author("Ricky Bobby");
        Author author3 = new Author("Spongebob Squarepants");
        authorRepo.save(author1);
        authorRepo.save(author2);
        authorRepo.save(author3);
        Hashtag oilChange = new Hashtag("oilchange");
        Hashtag help = new Hashtag("help");
        Hashtag meet = new Hashtag("meet");
        hashtagRepo.save(oilChange);
        hashtagRepo.save(help);
        hashtagRepo.save(meet);
        Post post1 = new Post("Oil Change", "NB", 2001, "Do I really have to take the wheel off to get to the oil filter?", author1, maintenance, oilChange);
        Post post2 = new Post("Turbo Help", "NA", 1993, "I'm not sure how to install a turbo.", author2, modifications, help);
        Post post3 = new Post("Car Meet", "NA", 1996, "We're meeting at Shell City on Tuesday at 6pm!", author3, social, meet);
        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
    }
}

package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.PostRepository;
import org.wcci.blog.storage.repositories.HashtagRepository;

@Service
public class PostStorage {
    private PostRepository postRepo;
    private HashtagRepository hashtagRepo;

    public PostStorage(PostRepository postRepo, HashtagRepository hashtagRepo) {
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }

    public Post findPostByPostTitle(String postTitle) {
        return postRepo.findByPostTitle(postTitle).get();
    }

    public PostRepository getPostRepo() {
        return postRepo;
    }

    public void addPost(Post postTitle) {
        postRepo.save(postTitle);
    }

    public boolean postExists(String postTitle) {
        return postRepo.findByPostTitle(postTitle).isPresent();
    }
}

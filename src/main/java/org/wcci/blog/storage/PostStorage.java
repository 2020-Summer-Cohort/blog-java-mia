package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.PostRepository;

@Service
public class PostStorage {
    private PostRepository postRepo;

    public PostStorage(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Post findPostByPostTitle(String postTitle) {
        return postRepo.findByPostTitle(postTitle).get();
    }

    public PostRepository getPostRepo() {
        return postRepo;
    }

    public void addPost(Post testPost) {
        postRepo.save(testPost);
    }
}

package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.storage.repositories.PostRepository;

@Service
public class PostStorage {
    PostRepository postRepo;

    public PostStorage(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

}

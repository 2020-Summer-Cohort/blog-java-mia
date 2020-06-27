package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.UserComment;
import org.wcci.blog.storage.repositories.UserCommentRepository;

@Service
public class UserCommentStorage {
    UserCommentRepository userCommentRepo;

    public UserCommentStorage(UserCommentRepository userCommentRepo) {
        this.userCommentRepo = userCommentRepo;
    }

    public Iterable<UserComment> findAllComments() {
        return userCommentRepo.findAll();
    }

    public void addComment(UserComment commentToAdd) {
        userCommentRepo.save(commentToAdd);
    }
}

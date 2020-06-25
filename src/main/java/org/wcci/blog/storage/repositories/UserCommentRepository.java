package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.UserComment;

public interface UserCommentRepository extends CrudRepository<UserComment, Long> {
}

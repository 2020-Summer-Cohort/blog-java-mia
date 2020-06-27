package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.Hashtag;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    Hashtag findByHashtagName(String hashtagName);
}


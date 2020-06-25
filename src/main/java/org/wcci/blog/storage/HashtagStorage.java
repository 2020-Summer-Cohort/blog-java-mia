package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.storage.repositories.HashtagRepository;

@Service
public class HashtagStorage {
  private HashtagRepository hashtagRepo;

  public HashtagStorage(HashtagRepository hashtagRepo) {
      this.hashtagRepo = hashtagRepo;
  }

  public Iterable<Hashtag> findAllHashtags() {
      return hashtagRepo.findAll();
  }

  public Hashtag findHashtagByName(String hashtagName) {
      return hashtagRepo.findHashtagByName(hashtagName);
  }

  public void addHashtag(Hashtag hashtagToAdd) {
      hashtagRepo.save(hashtagToAdd);
  }
}
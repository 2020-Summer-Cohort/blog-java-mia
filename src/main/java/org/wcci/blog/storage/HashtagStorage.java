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

    public HashtagRepository getHashtagRepo() {
        return hashtagRepo;
    }

    public Hashtag findHashtagByHashtagName(String hashtagName) {
        return hashtagRepo.findHashtagByHashtagName(hashtagName).get();
    }

    public void addAHashtagToPost(Hashtag hashtagToAdd) {
        hashtagRepo.save(hashtagToAdd);
    }

    public Iterable<Hashtag> findAllHashtags() {
        return hashtagRepo.findAll();
    }

    public boolean hashtagExists(String hashtagName) {
        return hashtagRepo.findHashtagByHashtagName(hashtagName).isPresent();
    }

}
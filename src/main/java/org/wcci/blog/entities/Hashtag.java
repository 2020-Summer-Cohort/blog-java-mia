package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;
    private String hashtagName;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    protected Hashtag(){}

    public Hashtag(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public Long getId() {
        return id;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(id, hashtag.id) &&
                Objects.equals(hashtagName, hashtag.hashtagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashtagName);
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", hashtagName='" + hashtagName + '\'' +
                '}';
    }
}
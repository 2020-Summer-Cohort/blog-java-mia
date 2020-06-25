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
    private long id;
    private String hashtagName;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    protected Hashtag(){}

    public Hashtag(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public long getId() {
        return id;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return id == hashtag.id &&
                Objects.equals(hashtagName, hashtag.hashtagName) &&
                Objects.equals(posts, hashtag.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashtagName, posts);
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", hashtagName='" + hashtagName + '\'' +
                ", posts=" + posts +
                '}';
    }
}

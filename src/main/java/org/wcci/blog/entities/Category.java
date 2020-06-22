package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    @OneToMany
    private Collection<Post> posts;

    protected Category(){}

    public Category(String title, String description, Collection<Post> posts) {
        this.title = title;
        this.description = description;
        this.posts = posts;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
}

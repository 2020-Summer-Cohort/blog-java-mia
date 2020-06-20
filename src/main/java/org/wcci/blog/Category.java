package org.wcci.blog;

import java.util.Collection;

public class Category {
    private String title;
    private String description;
    private Collection<Post> posts;

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

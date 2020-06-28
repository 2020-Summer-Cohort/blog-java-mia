package org.wcci.blog.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String postTitle;
    private String model;
    private int year;
    private String postBody;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    protected Post(){}

    public Post(String postTitle, String model, int year, String postBody, Author author, Category category, Hashtag... hashtags) {
        this.postTitle = postTitle;
        this.model = model;
        this.year = year;
        this.postBody = postBody;
        this.author = author;
        this.category = category;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));
    }

    public Long getId() {
        return id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getPostBody() {
        return postBody;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public void addAHashtagToPost(Hashtag hashtagToAdd) {
        hashtags.add(hashtagToAdd);
    }
}


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return year == post.year &&
                Objects.equals(id, post.id) &&
                Objects.equals(postTitle, post.postTitle) &&
                Objects.equals(model, post.model) &&
                Objects.equals(postBody, post.postBody) &&
                Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postTitle, model, year, postBody, author);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postTitle='" + postTitle + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", postBody='" + postBody + '\'' +
                ", author=" + author +
                '}';
    }
}


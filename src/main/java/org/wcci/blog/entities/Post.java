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
    private long id;
    private String title;
    private String model;
    private int year;
    private String body;
    private String author;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @OneToMany(mappedBy = "post")
    private Collection<UserComment> userComments;

    protected Post(){}

    public Post(String model, int year, String title, String body, String author, Hashtag... hashtags) {
        this.title = title;
        this.model = model;
        this.year = year;
        this.body = body;
        this.author = author;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public void addHashtag(Hashtag hashtagToAdd) {
        hashtags.add(hashtagToAdd);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                year == post.year &&
                Objects.equals(title, post.title) &&
                Objects.equals(model, post.model) &&
                Objects.equals(body, post.body) &&
                Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, model, year, body, author);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}


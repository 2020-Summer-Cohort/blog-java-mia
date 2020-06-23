package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    protected Post(){}

    public Post(String model, int year, String title, String body, String author) {
        this.title = title;
        this.model = model;
        this.year = year;
        this.body = body;
        this.author = author;
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


package org.wcci.blog;


public class Post {
    private String title;
    private String model;
    private int year;
    private String body;
    private String author;

    public Post(String model, int year, String title, String body, String author) {
        this.title = title;
        this.model = model;
        this.year = year;
        this.body = body;
        this.author = author;
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
}


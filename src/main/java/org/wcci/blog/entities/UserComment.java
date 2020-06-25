package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserComment {
    @Id
    @GeneratedValue
    private long id;
    private String userComments;
    @ManyToOne
    private Post post;

    protected UserComment(){}

    public UserComment(String userComments, Post post) {
        this.userComments = userComments;
        this.post = post;
    }

    public String getUserComments() {
        return userComments;
    }

    public Post getPost() {
        return post;
    }
}

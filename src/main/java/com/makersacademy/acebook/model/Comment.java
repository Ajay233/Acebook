package com.makersacademy.acebook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentid;
    private String comment;
    private Long postid;

    private Comment() {
    }

    public Comment(String comment, Long postid) {
        this.comment = comment;
        this.postid = postid;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public Long getPostid() {
        return this.postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }
}


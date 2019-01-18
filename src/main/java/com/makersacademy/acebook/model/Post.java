package com.makersacademy.acebook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String title;
    private int aced;
//    timestamp adds below
    private java.sql.Timestamp created;
    private java.sql.Timestamp modified;

    private Post() {
    }

    public Post(String content, String title) {
        this.content = content;
        this.title = title;
        this.aced = 0;
    }

    public void setId(long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getAced(){
        return this.aced;
    }

    public void setAced(int num) {
        this.aced = num;
    }

    public void incrementAced() {
        this.aced += 1;
    }

//    timestamp adds below
    public java.sql.Timestamp getCreated() {
        return this.created;
    }

    public java.sql.Timestamp getModified() {
        return this.modified;
    }

    public void setModified(java.sql.Timestamp modified) {
        this.modified = modified;
    }

}


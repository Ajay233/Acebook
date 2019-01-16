package com.makersacademy.acebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Data;

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
        this.aced ++;
    }


}


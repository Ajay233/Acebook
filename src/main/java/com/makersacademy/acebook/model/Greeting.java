package com.makersacademy.acebook.model;

import java.util.ArrayList;

public class Greeting {

    private long id;
    private String content;
    private String title;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
package com.makersacademy.acebook.model;

public class PostForm {

    private String content;
    private String title;


    public PostForm(String content, String title) {
        this.content = content;
        this.title = title;
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

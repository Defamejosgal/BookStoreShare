package com.example.aula3.models;

import org.springframework.web.multipart.MultipartFile;

public class BookForm {

    private String title;
    private String publisher;
    private String author;
    private MultipartFile cover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getCover() {
        return this.cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }
}

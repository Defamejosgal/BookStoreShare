package com.example.aula3.models;

public class Book {

    String title;
    String author;
    String publisher;
    String cover;

    public Book(){};
    public Book(String in_title, String in_author, String in_publisher, String in_cover) {
        this.title = in_title;
        this.author = in_author;
        this.publisher = in_publisher;
        this.cover = in_cover;
    }

    public String toString() {
        return "Title: " + this.title + "| Author: " +
                this.author + "| Publisher: " + this.publisher + "| Cover: " + this.cover;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}

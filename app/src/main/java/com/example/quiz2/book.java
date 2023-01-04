package com.example.quiz2;

public class book {
    String title;
    String author;
    String pages;
    boolean available;

    public book(String title, String author, String pages, boolean available) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.available = available;
    }

    public String getTitle() {
        return title;
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

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

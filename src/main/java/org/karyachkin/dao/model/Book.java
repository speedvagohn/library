package org.karyachkin.dao.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "title shouldn't be empty")
    @Size(min = 2, max = 100, message = "size between 2 and 100 characters")
    private String title;

    @NotEmpty(message = "autor shouldn't be empty")
    @Size(min = 2, max = 100, message = "size between 2 and 100 characters")
    private String author;

    @Min(value = 1, message = "year should be greater than 0")
    private int publishYear;

    @NotEmpty(message = "genre shouldn't be empty")
    @Size(min = 2, max = 100, message = "size between 2 and 100 characters")
    private String genre;

    @NotEmpty(message = "reading status shouldn't be empty")
    @Size(min = 2, max = 100, message = "size between 2 and 100 characters")
    private String readingStatus;

    public Book(int id, String title, String author, int publishYear, String genre, String readingStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.genre = genre;
        this.readingStatus = readingStatus;
    }

    public Book(){

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getReadingStatus() {
        return readingStatus;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReadingStatus(String readingStatus) {
        this.readingStatus = readingStatus;
    }
}

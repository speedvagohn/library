package org.karyachkin.dao.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Book {
    private int id;
    private String title;
    private String autor;
    private int publishYear;
    private String genre;
    private String readingStatus;

    public Book(int id, String title, String autor, int publishYear, String genre, String readingStatus) {
        this.id = id;
        this.title = title;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
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

    public void setAutor(String autor) {
        this.autor = autor;
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

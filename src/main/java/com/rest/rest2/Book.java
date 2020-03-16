package com.rest.rest2;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    private @Id @GeneratedValue Long id;
    private String title;
    private String author;
    private int year;
    private String type;

    Book() {}

    Book(String title, String author, int year, String type){
        this.title = title;
        this.author = author;
        this.year = year;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public long getId(){
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id){
        this.id = id;
    }
}

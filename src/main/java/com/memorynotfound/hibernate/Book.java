package com.memorynotfound.hibernate;

import javax.persistence.*;

@Entity
@NamedQueries(value = {
        @NamedQuery(
                name = "Book.findAll.nq",
                query = "SELECT b FROM Book b"),
        @NamedQuery(
                name = "Book.findById.nq",
                query = "SELECT b FROM Book b WHERE b.id = :id")
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

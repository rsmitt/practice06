package org.example.pecs;

import java.time.LocalDateTime;

public class Book extends Product{

    private LocalDateTime publishedDate;

    public Book(String name, double price, LocalDateTime publishedDate) {
        super(name, price);
        this.publishedDate = publishedDate;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + getName() + '\'' +
                "price='" + getPrice() + '\'' +
                "publishedDate=" + publishedDate +
                '}';
    }
}

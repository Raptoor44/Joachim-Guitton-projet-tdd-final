package org.example.service;

import org.example.models.Book;
import org.example.repository.BookRepostiory;

public class WebService {

    private BookRepostiory bookRepostiory;

    public void setBookRepostiory(BookRepostiory bookRepostiory) {
        this.bookRepostiory = bookRepostiory;
    }

    public Book getBookByIsbn(Book bookParam){
        Book bookToReturn = this.bookRepostiory.findByIsbn(bookParam.getIsbn());

        return bookToReturn;
    }
}

package org.example.service;

import org.example.exceptions.AttributesMissingException;
import org.example.models.Book;
import org.example.repository.BookRepostiory;
import org.example.service.verify.IsbnValidator;

public class BookService {

    private BookRepostiory bookRepostiory;

    private WebService webService;

    private IsbnValidator isbnValidator;

    public BookService(BookRepostiory bookRepostiory, WebService webService) {
        this.bookRepostiory = bookRepostiory;
        this.webService = webService;
        this.isbnValidator = new IsbnValidator();
    }

    public Book save(Book bookParam) throws AttributesMissingException {

        if (bookParam.getFormatBook() == null || bookParam.getTitle() == null || bookParam.getIsbn() == null || bookParam.getAuthor() == null || bookParam.getEditeur() == null) {
            Book bookWebService = new Book();

            bookWebService = this.webService.getBookByIsbn(bookParam);

            if(bookWebService != null) {
                bookParam = bookWebService;
            }
        }
        this.isbnValidator.validateISBN(bookParam.getIsbn());


        if (bookParam.getFormatBook() == null) {
            throw new AttributesMissingException("Le format du livre n'est pas renseignée.");
        } else if (bookParam.getTitle() == null) {
            throw new AttributesMissingException("Le titre du livre n'est pas renseignée.");
        } else if (bookParam.getIsbn() == null) {
            throw new AttributesMissingException("L'ISBN du livre n'est pas renseignée.");
        } else if (bookParam.getAuthor() == null) {
            throw new AttributesMissingException("L'auteur du livre n'est pas renseignée.");
        }else if(bookParam.getEditeur() == null) {
            throw new AttributesMissingException("L'Editeur du livre n'est pas renseignée");
        }

        Book book = this.bookRepostiory.save(bookParam);

        return book;
    }

    public WebService getWebService() {
        return webService;
    }

    public void setWebService(WebService webService) {
        this.webService = webService;
    }

    public BookRepostiory getBookRepostiory() {
        return bookRepostiory;
    }

    public void setBookRepostiory(BookRepostiory bookRepostiory) {
        this.bookRepostiory = bookRepostiory;
    }
}

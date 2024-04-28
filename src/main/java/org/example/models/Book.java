package org.example.models;

public class Book {

    private String Isbn;

    private String Title;

    private String Author;

    private String Editeur;

    private org.example.utils.FormatBook FormatBook;

    public Book(String title, String author, String isbn, org.example.utils.FormatBook format) {
        this.Title = title;
        this.Author = author;
        this.Isbn = isbn;
        this.FormatBook = format;
    }

    public Book() {

    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        this.Isbn = isbn;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getEditeur() {
        return Editeur;
    }

    public void setEditeur(String editeur) {
        Editeur = editeur;
    }

    public org.example.utils.FormatBook getFormatBook() {
        return FormatBook;
    }

    public void setFormatBook(org.example.utils.FormatBook formatBook) {
        FormatBook = formatBook;
    }
}

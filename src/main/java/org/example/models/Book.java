package org.example.models;

public class Book {

    private String isbn;

    private String title;

    private String author;

    private String editor;

    private org.example.utils.FormatBook FormatBook;

    public Book() {

    }

    public Book(String title, String author, String isbn, org.example.utils.FormatBook format) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.FormatBook = format;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public org.example.utils.FormatBook getFormatBook() {
        return FormatBook;
    }

    public void setFormatBook(org.example.utils.FormatBook formatBook) {
        FormatBook = formatBook;
    }
}

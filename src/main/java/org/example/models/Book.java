package org.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private String Isbn;

    private String Titre;

    private String Auteur;

    private String Editeur;

    private org.example.utils.FormatBook FormatBook;

    public Book(String title, String author, String isbn, org.example.utils.FormatBook format) {
        this.Titre = title;
        this.Auteur = author;
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

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
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

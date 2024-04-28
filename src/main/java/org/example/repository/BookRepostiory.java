package org.example.repository;

import org.example.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepostiory extends JpaRepository<Book, String> {

    Book findByIsbn(String isbn);

    Book findByTitle(String title);

    Book findByAuthor(String author);

    Book findByEditor(String editor);
}

package org.yaron.quarkus.starting;


import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BookRepository {
    public List<Book> getAllBooks() {
        Book book1 = new Book(1, "1984", "George Orwell", "Dystopian", 1949);
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960);
        Book book3 = new Book(3, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925);
        return List.of(book1, book2, book3);

        //return bookService.getAllBooks();
    }

    public Book getBookById(int id) {
        return getAllBooks().stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public String countAllBooks() {
        return "Total number of books: "+getAllBooks().size();
    }
}

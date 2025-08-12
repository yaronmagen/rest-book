package org.yaron.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.yaron.quarkus.starting.Book;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class BookResource {
    // This class can be used to define REST endpoints for book-related operations
    // For example, you can add methods to handle GET, POST, PUT, DELETE requests
    // related to books in your application.

    // Example method:
     @GET
     @Path("/all")
     @Produces(MediaType.APPLICATION_JSON)
     public List<Book> getAllBooks() {
            Book book1 = new Book(1, "1984", "George Orwell", "Dystopian", 1949);
            Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960);
            return List.of(book1, book2);

         //return bookService.getAllBooks();
     }

     @GET
     @Produces(MediaType.TEXT_PLAIN)
     public String hello() {

         return "Hello books";
     }

     @GET
        @Path("/count")
        @Produces(MediaType.TEXT_PLAIN)
        public String countAllBooks() {
         return "Total number of books: "+getAllBooks().size();
     }

     @GET
        @Path("/book/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Optional<Book> getBook(@PathParam("id") int id) {
         return getAllBooks().stream().
                 filter(book -> book.getId() == id)
                 .findFirst();
     }
}


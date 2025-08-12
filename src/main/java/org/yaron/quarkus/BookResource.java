package org.yaron.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
public class BookResource {
    // This class can be used to define REST endpoints for book-related operations
    // For example, you can add methods to handle GET, POST, PUT, DELETE requests
    // related to books in your application.

    // Example method:
    // @GET
    // @Path("/books")
    // @Produces(MediaType.APPLICATION_JSON)
    // public List<Book> getAllBooks() {
    //     return bookService.getAllBooks();
    // }
        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String hello() {
            return "Hello books";
        }
    }


package org.yaron.quarkus;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.yaron.quarkus.starting.Book;
import org.yaron.quarkus.starting.BookRepository;

import java.util.List;
import java.util.Optional;


@Path("/api/books")
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger logger;

     @GET
     @Path("/all")
     @Produces(MediaType.APPLICATION_JSON)
        public List<Book> getAllBooks() {
         logger.info("Return all Books");
         return bookRepository.getAllBooks();
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
            return bookRepository.countAllBooks();
        }


     @GET
        @Path("/book/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Optional<Book> getBookById(@PathParam("id") int id) {
         logger.info("Fetching book with ID:" + id);
         return Optional.ofNullable(bookRepository.getBookById(id));
        }



}


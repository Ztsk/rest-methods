package com.rest.rest2;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Library library;

    public BookController(Library library) {
        this.library = library;
    }

    @GetMapping("/books")
    List<Book> all() {
        return library.findAll();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook){
        return library.save(newBook);
    }

    @GetMapping("/books/{id}")
    Book bk(@PathVariable Long id) {
        return library.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/books/{id}")
    Book editBook(@RequestBody Book newBook, @PathVariable Long id){
        return library.findById(id).map(book -> {
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setType(newBook.getType());
            book.setYear(newBook.getYear());
            return library.save(book);
        })
        .orElseGet(() -> {newBook.setId(id);
        return library.save(newBook);
        });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        library.deleteById(id);
    }
}

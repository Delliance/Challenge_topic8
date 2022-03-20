package com.challenges.challenge8.controllers;

import com.challenges.challenge8.entities.Book;
import com.challenges.challenge8.entities.BookStatus;
import com.challenges.challenge8.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookstore/v1/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping
    public void addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @PutMapping
    public void editBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @GetMapping(path = "/findByStatus")
    public List<Book> getBooksByStatus (@RequestBody String status){
        return bookService.getBooksByStatus(BookStatus.valueOf(status));
    }

    @GetMapping(path = "/{id}")
    public List<Book> getBooksById(@PathVariable("id") long id){
        return bookService.getBooksById(id);
    }

    @PostMapping(path = "/{id}")
    public void updateBookNameAndStatusById(@PathVariable("id") long id, @RequestBody String name, @RequestBody String status){
        bookService.updateBookNameAndStatusById(id, name, BookStatus.valueOf(status));
    }



}

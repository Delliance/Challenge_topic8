package com.challenges.challenge8.services;

import com.challenges.challenge8.entities.Book;
import com.challenges.challenge8.entities.BookStatus;
import com.challenges.challenge8.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

//    Services to check tag and category of the book
    private final BookCategoryService bookCategoryService;
    private final BookTagService bookTagService;

    public boolean checkIfBookByIdExists(long id){
        Optional<Book> bookOptional = bookRepository.findById(id);

        return bookOptional.isPresent();
    }

    public void addNewBook(Book book){
        Optional<Book> bookOptional = bookRepository.findBookByName(book.getName());

        if (bookOptional.isPresent()){
            throw new IllegalIdentifierException("This book is already in the database");
        }

        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book book){
        Optional<Book> bookOptional = bookRepository.findById(book.getId());

        if (!bookOptional.isPresent()){
            throw new IllegalIdentifierException("The book with id: "+book.getId()+" does not exist");
        }

        if(!bookCategoryService.checkIfBookCategoryExistsById(book.getBookCategory())){
            throw new IllegalIdentifierException("The category with id: "+book.getBookCategory().getId()+" does not exist");
        }

        if(!bookTagService.checkIfBookTagExistsById(book.getTag())){
            throw new IllegalIdentifierException("The tag with id: "+book.getTag().getId()+" does not exist");
        }

        bookRepository.updateBookNameById(book.getName(),book.getId());

        bookRepository.updateBookStatusById(book.getBookStatus(), book.getId());

        bookCategoryService.updateCategory(book.getBookCategory());

        bookTagService.updateTag(book.getTag());


    }

    public List<Book> getBooksByStatus (BookStatus status){
        return bookRepository.findBooksByBookStatus(status);
    }

    public List<Book> getBooksById (long id){
        return bookRepository.findBooksById(id);
    }

//    TODO: post method to update books with form data
}

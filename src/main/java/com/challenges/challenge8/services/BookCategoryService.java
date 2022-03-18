package com.challenges.challenge8.services;

import com.challenges.challenge8.entities.BookCategory;
import com.challenges.challenge8.repositories.BookCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;

    public boolean checkIfBookCategoryExistsById(BookCategory bookCategory){
        Optional<BookCategory> bookCategoryOptional = bookCategoryRepository.findById(bookCategory.getId());

        return bookCategoryOptional.isPresent();

    }

//    public boolean checkIfBookCategoryExistsByName(BookCategory bookCategory){
//        Optional<BookCategory> bookCategoryOptional = bookCategoryRepository.findBookCategoryByName(bookCategory.getName());
//
//        return bookCategoryOptional.isPresent();
//
//    }

    @Transactional
    public void updateCategory (BookCategory bookCategory){
        if(!checkIfBookCategoryExistsById(bookCategory)){
            throw new IllegalStateException("The category with id: "+bookCategory.getId()+" does not exist");
        }

        bookCategoryRepository.updateCategoryNameById(bookCategory.getName(), bookCategory.getId());


    }

}

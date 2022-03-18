package com.challenges.challenge8.services;

import com.challenges.challenge8.entities.BookCategory;
import com.challenges.challenge8.entities.BookTag;
import com.challenges.challenge8.repositories.BookTagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookTagService {

    private final BookTagRepository bookTagRepository;

    public boolean checkIfBookTagExistsById(BookTag bookTag){
        Optional<BookTag> bookTagOptional = bookTagRepository.findById(bookTag.getId());

        return bookTagOptional.isPresent();
    }

//    public boolean checkIfBookTagExistsByName(BookTag bookTag){
//        Optional<BookTag> bookTagOptional = bookTagRepository.findBookTagByName(bookTag.getName());
//
//        return bookTagOptional.isPresent();
//    }

    @Transactional
    public void updateTag (BookTag bookTag){
        if(!checkIfBookTagExistsById(bookTag)){
            throw new IllegalStateException("The tag with id: "+bookTag.getId()+" does not exist");
        }

        bookTagRepository.updateTagNameById(bookTag.getName(), bookTag.getId());


    }

}

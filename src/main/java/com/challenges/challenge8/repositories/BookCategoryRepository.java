package com.challenges.challenge8.repositories;

import com.challenges.challenge8.entities.Book;
import com.challenges.challenge8.entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BookCategoryRepository extends JpaRepository <BookCategory, Long> {

    Optional<BookCategory> findBookCategoryByName(String name);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE book_category SET name = ?1 WHERE category_id = ?2",
            nativeQuery = true
    )
    Book updateCategoryNameById(String name, long id);

}

package com.challenges.challenge8.repositories;

import com.challenges.challenge8.entities.Book;
import com.challenges.challenge8.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

    Optional<Book>findBookByName(String name);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_book SET name = ?1 WHERE book_id = ?2",
            nativeQuery = true
    )
    Book updateBookNameById(String name, long id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_book SET status = ?1 WHERE book_id = ?2",
            nativeQuery = true
    )
    Book updateBookStatusById(BookStatus status, long id);

    List<Book> findBooksByBookStatus (BookStatus status);

    List<Book> findBooksById (long id);

}

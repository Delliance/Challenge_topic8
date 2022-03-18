package com.challenges.challenge8.repositories;

import com.challenges.challenge8.entities.Book;
import com.challenges.challenge8.entities.BookTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BookTagRepository extends JpaRepository <BookTag, Long> {

    Optional<BookTag> findBookTagByName (String name);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE book_tag SET name = ?1 WHERE tag_id = ?2",
            nativeQuery = true
    )
    Book updateTagNameById(String name, long id);

}

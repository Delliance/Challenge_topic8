package com.challenges.challenge8.repositories;

import com.challenges.challenge8.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
}

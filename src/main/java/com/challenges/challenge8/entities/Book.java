package com.challenges.challenge8.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Book")
@Table(
        name = "tbl_book"
)
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "book_sequence",
            updatable = false
    )
    private long id;

    @Embedded
    private Category category;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Embedded
    private Tag tags;

    @Column(
            name = "status",
            nullable = false
    )
    private BookStatus bookStatus;
}

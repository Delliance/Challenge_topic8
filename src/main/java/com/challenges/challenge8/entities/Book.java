package com.challenges.challenge8.entities;

import com.challenges.challenge8.enums.BookStatus;
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
            name = "book_id",
            updatable = false
    )
    private long id;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch =FetchType.EAGER,
            optional = false
    )
    @JoinColumn (
            name = "category_id",
            referencedColumnName = "category_id"
    )
    private BookCategory bookCategory;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch =FetchType.EAGER,
            optional = false
    )
    @JoinColumn (
            name = "tag_id",
            referencedColumnName = "tag_id"
    )
    private BookTag tag;

    @Enumerated (EnumType.STRING)
    @Column(
            name = "status",
            nullable = false
    )
    private BookStatus bookStatus;

}

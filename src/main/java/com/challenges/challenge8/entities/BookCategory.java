package com.challenges.challenge8.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategory {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Column(
            name = "category_id",
            updatable = false
    )
    private long id;

    @Column (
            unique = true,
            nullable = false
    )
    private String name;

    @OneToOne (
            mappedBy = "bookCategory"
    )
    private Book book;
}

package com.challenges.challenge8.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTag {

    @Id
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    @Column(
            name = "tag_id",
            updatable = false
    )
    private long id;

    @Column (
            unique = true,
            nullable = false
    )
    private String name;

    @OneToOne (
            mappedBy = "tag"
    )
    private Book book;
}

package com.challenges.challenge8.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name") //here we override the column guardian_name, that is how it is called in the database
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email") //here we override the column guardian_email, that is how it is called in the database
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile") //here we override the column guardian_email, that is how it is called in the database
        )
})
public class Category {

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
            name = "category_sequence",
            updatable = false
    )
    private long id;
    private String name;
}

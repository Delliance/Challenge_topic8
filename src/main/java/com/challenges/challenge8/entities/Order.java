package com.challenges.challenge8.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Order")
@Table(
        name = "tbl_order"
)
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
            name = "order_id",
            updatable = false
    )
    private long id;

    @Column(
            name = "book_id",
            nullable = false
    )
    private int bookId;

    @Column(
            name = "quantity",
            nullable = false
    )
    private int quantity;

    @Column(
            name = "ship_date",
            nullable = false
    )
    private LocalDateTime shipDate;

    @Column(
            name = "order_status",
            nullable = false
    )
    private OrderStatus orderStatus;

    @Column(
            name = "complete",
            nullable = false
    )
    private boolean complete;
}

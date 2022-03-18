package com.challenges.challenge8.entities;

import java.time.LocalDateTime;

public class Order {

    private long id;
    private int bookId;
    private int quantity;
    private LocalDateTime shipDate;
    private OrderStatus orderStatus;
    private boolean complete;
}

package com.challenges.challenge8.controllers;

import com.challenges.challenge8.entities.Order;
import com.challenges.challenge8.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookstore/v1/store")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping(path = "/inventory")
    public void getOrdersByStatus (){
        orderService.getQuantityByStatus();
    }

    @PostMapping(path = "/order")
    public Order postOrderAndReturnIt (@RequestBody Order order){
        return orderService.placeOrderAndReturnAcceptedOrder(order);
    }


}

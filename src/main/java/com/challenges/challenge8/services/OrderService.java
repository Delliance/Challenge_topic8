package com.challenges.challenge8.services;

import com.challenges.challenge8.entities.Order;
import com.challenges.challenge8.entities.OrderStatus;
import com.challenges.challenge8.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final BookService bookService;

    public void getQuantityByStatus (){

        System.out.println(OrderStatus.approved+": "+orderRepository.countAllByOrderStatus(OrderStatus.approved));
        System.out.println(OrderStatus.delivered+": "+orderRepository.countAllByOrderStatus(OrderStatus.delivered));
        System.out.println(OrderStatus.placed+": "+orderRepository.countAllByOrderStatus(OrderStatus.placed));

    }

    public Order placeOrderAndReturnAcceptedOrder(Order order){

        if (!bookService.checkIfBookByIdExists(order.getBookId())){
            throw new IllegalStateException("The book with id: "+order.getBookId()+" does not exist");
        }

        orderRepository.save(order);

        return orderRepository.findOrderById(order.getId());
    }

}

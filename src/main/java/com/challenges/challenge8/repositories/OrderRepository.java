package com.challenges.challenge8.repositories;

import com.challenges.challenge8.entities.Order;
import com.challenges.challenge8.entities.OrderStatus;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

//    List<Order> getAllByOrderStatus (OrderStatus status);

    int countAllByOrderStatus (OrderStatus status);

    Order findOrderById (long id);

}

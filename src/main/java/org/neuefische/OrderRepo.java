package org.neuefische;

import java.util.List;
import java.util.UUID;

public interface OrderRepo {
    void add(Order order);
    void remove(Order order);
    List<Order> findAll();
    Order findById(UUID id);

}

package org.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderMapRepo  implements OrderRepo {
    private Map<Integer,Order> orders;
    static  Integer orderNr = 0;
    @Override
    public void add(Order order) {
        orders.put(orderNr++, order);
    }

    @Override
    public void remove(Order order) {
        for (int i = 0; i <orders.size() ; i++) {
            if (orders.get(i).equals(order)) {
                orders.remove(i);
            }
        }
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order findById(UUID id) {
        for (Order order : orders.values()) {
            if( order.id().equals(id)){
                return order;
            }
        }
        throw  new IllegalArgumentException("Order not found");
    }
}

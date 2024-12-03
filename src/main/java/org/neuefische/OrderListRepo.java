package org.neuefische;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderListRepo implements OrderRepo{
    public OrderListRepo(){
        orders = new ArrayList<>();
    }
    private List<Order> orders;
    public List<Order> getAllOrders(){
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Override
    public void add(Order order){
        orders.add(order);
    }
    @Override
    public void remove(Order order){
        orders.remove(order);
    }
    @Override
    public Order findById(UUID id){
        for(Order order : orders){
           if(order.id().equals(id)){
               return order;
           }
        }
        //return orders.stream().findFirst().orElse(null);
        throw  new IllegalArgumentException("Order not found");
    }

    @Override
    public double total(Order order) {
        double total = 0;
        for(Product product : order.products().keySet()){
            total += product.price()*order.products().get(product);
        } ;
        return total;
    }


    public List<Order> getAllOrdersOfCustomer(Customer customer){
        List<Order> customerOrders = new ArrayList<Order>();
        for(Order order : orders){
            if(order.customer().equals(customer)){
                customerOrders.add(order);
            }
        }
        if(customerOrders.isEmpty()){
            throw  new IllegalArgumentException("Customer not found");
        }
        return customerOrders;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
    public double getTotal(Order order){
        double total = 0;
        for(Product product : order.products().keySet()){
            total += product.price();
            }
        return total;
        }


    }




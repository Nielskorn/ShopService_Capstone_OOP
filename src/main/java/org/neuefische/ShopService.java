package org.neuefische;

import java.util.*;

public class ShopService {
    ProductRepo productRepo ;
    OrderRepo orderRepo;
    public ShopService() {
        orderRepo=new OrderListRepo();
        productRepo = new ProductRepo();
    }
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }
    public Order CreateOrder(Map<String, Integer>products , Customer customer) {
       Order order;
        if(products.isEmpty()) {
           throw  new IllegalArgumentException("No products given");
       }
       Map<Product,Integer> productMap = new HashMap<>();
       for(String product : products.keySet()) {
       Product product1= productExists(product);
       if(product1 != null) {
           productMap.put(product1,products.get(product));
           System.out.println(products.get(product));
           product1.withQuatity(product1.quantity()-products.get(product));
       }
       else {
           throw new IllegalArgumentException("Product " + product + " not found");
       }

       }
       order=new Order(UUID.randomUUID(),productMap,customer);
        orderRepo.add(order);

        // Order order=new Order(UUID.randomUUID(),products,customer);
        return order;
    }


    public  Product productExists(String productName) {

        return productRepo.getProductByName(productName);
    }
    public Order findOrder(UUID id){
          return orderRepo.findById(id);
    }
    public double getTotalOrder(Order order){
      return   orderRepo.total(order);
    }
}

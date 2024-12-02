package org.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopService {
    ProductRepo productRepo = new ProductRepo();
    public String CreateOrder(List<String> products,Customer customer) {
       Order order;
        if(products.isEmpty()) {
           return "Error: No products found";
       }
       List<Product> productList = new ArrayList<Product>();
       for(String product : products) {
       Product product1= productExists(product);
       if(product1 != null) {
           productList.add(product1);
       }
       else {
           throw new IllegalArgumentException("Product " + product + " not found");
       }

       }
       order=new Order(UUID.randomUUID(),productList,customer);


        // Order order=new Order(UUID.randomUUID(),products,customer);
        return order.toString()+" successfully created";
    }
    public  Product productExists(String productName) {
        productName = productName.toLowerCase();
        return productRepo.getProductByName(productName);
    }
}

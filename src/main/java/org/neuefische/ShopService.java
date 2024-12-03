package org.neuefische;

import java.util.*;

public class ShopService {
    ProductRepo productRepo ;
    OrderRepo orderRepo;
    EanProductRepo eanProductRepo;
    public ShopService() {
        orderRepo=new OrderListRepo();
        productRepo = new ProductRepo();
        eanProductRepo = new EanProductRepo();
    }
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo, EanProductRepo eanProductRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.eanProductRepo = eanProductRepo;
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
           productRepo.remove(product1);
           productRepo.remove(product1);
           product1=product1.withQuantity(product1.quantity()-products.get(product));

           productRepo.add(product1);
           productMap.put(product1,products.get(product));
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
    public void importEanProduct() {
      List<Product> products= eanProductRepo.getEanProductsAsProducts();
      for(Product product:products) {
          productRepo.add(product);
      }
    }
}

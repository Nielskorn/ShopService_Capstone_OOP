package org.neuefische;

import java.util.ArrayList;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Customer john=new Customer("john doe","amArschderHeide 5 mustermanStadt musterland 44466");
    Product RedBull=new Product(UUID.randomUUID(),"RedBull",1.50);
    Product BlueBull=new Product(UUID.randomUUID(),"BlueBull",1.50);

    ArrayList<String>productStrings=new ArrayList<>();
    productStrings.add("RedBull");
    productStrings.add("BlueBull");
    OrderRepo orderRepo=new OrderListRepo();
    ProductRepo productRepo=new ProductRepo();
    productRepo.add(BlueBull);
    productRepo.add(RedBull);
    ShopService shopService=new ShopService(productRepo,orderRepo);
    String createOrder=shopService.CreateOrder(productStrings,john);
    System.out.println(createOrder);

    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}
package org.neuefische;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
   // Customer john=new Customer("john doe","amArschderHeide 5 mustermanStadt musterland 44466");
    Product RedBull=new Product(UUID.randomUUID(),"RedBull",1.50,500);
    Product BlueBull=new Product(UUID.randomUUID(),"BlueBull",1.50,250);
    OrderRepo orderRepo=new OrderListRepo();
        ProductRepo productRepo=new ProductRepo();
        productRepo.add(BlueBull);
        productRepo.add(RedBull);
        ShopService shopService=new ShopService(productRepo,orderRepo);
//    Map<String,Integer> productStrings=new HashMap<>();
//    productStrings.put("RedBull",1);
//    productStrings.put("BlueBull",5);
//    OrderRepo orderRepo=new OrderListRepo();
//    ProductRepo productRepo=new ProductRepo();
//    productRepo.add(BlueBull);
//    productRepo.add(RedBull);
//    ShopService shopService=new ShopService(productRepo,orderRepo);
//    Order createOrder=shopService.CreateOrder(productStrings,john);
//    System.out.println(createOrder.toString());
//    System.out.println(shopService.getTotalOrder(shopService.findOrder(createOrder.id())));
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the Inventory System");
        System.out.println("please enter the name of the customer");
        String customerName =sc.nextLine();
        sc.reset();
        System.out.println("please enter the Address of the customer");
        String customerAddress =sc.nextLine();
        sc.reset();
        Customer customer=new Customer(customerName,customerAddress);
        System.out.println("enter Number of items of the order");
        int numberOfItems= sc.nextInt();
        //consumes \n
        sc.nextLine();
        Map<String,Integer> productStrings=new HashMap<>();
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("please enter the Product name");
            String productName =sc.nextLine();
            Product productByName = productRepo.getProductByName(productName);
            if(productByName ==null){
                System.out.println("Product does not exist");
                break;
            }else {
                System.out.println("please enter the quantity of the product");
               Integer productquantiy= sc.nextInt();
               sc.reset();
               productStrings.put(productName,productquantiy);
            }
        }
        Order createOrder=shopService.CreateOrder(productStrings,customer);
        System.out.println(createOrder);
        System.out.println("this Order will Cost : "+shopService.getTotalOrder(createOrder));
        System.out.println(productRepo.getProducts());



    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}
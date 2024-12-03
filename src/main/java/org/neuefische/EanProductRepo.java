package org.neuefische;

import java.util.ArrayList;
import java.util.List;

public class EanProductRepo {
    List<EanProduct> products;
    public EanProductRepo() {
        products = new ArrayList<>();
    }
    public EanProductRepo(List <EanProduct> products) {
        this.products = products;
    }
    List<Product> getEanProductsAsProducts() {
        List<Product>productList=new ArrayList<>();
        for (EanProduct e : products) {
          String id = e.getEan();
          String name= e.getProductName();
          double price= e.getPrice();
          int quantity= e.getQuantity();
          productList.add(new Product(id, name, price, quantity));
        }
        return productList;
    }
}

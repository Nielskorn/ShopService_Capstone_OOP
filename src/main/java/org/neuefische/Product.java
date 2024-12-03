package org.neuefische;



public record Product(String id, String name, double price,int quantity) {
    public Product withQuantity(int quantity){
       return new Product(id, name, price, quantity);
    }
}

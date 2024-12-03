package org.neuefische;

import java.util.UUID;

public record Product(UUID id, String name, double price,int quantity) {
    public Product withQuatity(int quantity){
       return new Product(id, name, price, quantity);
    }
}

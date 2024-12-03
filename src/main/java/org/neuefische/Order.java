package org.neuefische;


import java.util.Map;
import java.util.UUID;

public record Order(UUID id, Map<Product,Integer> products, Customer customer) {
}

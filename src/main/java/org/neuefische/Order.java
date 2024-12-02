package org.neuefische;

import java.util.List;
import java.util.UUID;

public record Order(UUID id, List<Product>products,Customer customer) {
}

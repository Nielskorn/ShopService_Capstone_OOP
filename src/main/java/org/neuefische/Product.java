package org.neuefische;

import java.util.UUID;

public record Product(UUID id, String name, double price) {
}

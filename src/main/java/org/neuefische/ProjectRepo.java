package org.neuefische;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProjectRepo {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void add(Product product) {
        this.products.add(product);
    }
    public void remove(Product product) {

        this.products.remove(product);
    }
//    public List<Product>getAllProducts() {
//        return products;
//    }
    public Product getProduct(UUID id) {
        for (Product product : products) {
            if (product.equals(id)){
                return product;
            }
        }
        throw new IllegalArgumentException("No product with id " + id + " found");
    }

    @Override
    public String toString() {
        return "ProjectRepo{" +
                "products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProjectRepo that = (ProjectRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }
}

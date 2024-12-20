package org.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProductRepo
{
    public ProductRepo(){
        products = new ArrayList<>();
    }
    public ProductRepo(List<Product> products) {
        this.products = products;
    }

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
    public Product getProductById(UUID id) {
        for (Product product : products) {
            if (product.id().equals(id)){
                return product;
            }
        }
        throw new IllegalArgumentException("No product with id " + id + " found");
    }
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.name().equals(name)){
                return product;
            }
        }
        throw new IllegalArgumentException("No product with Name " + name + " found");
    }
    public List<Product>getAllProductsForPrice(double price){
        List<Product> Resultproducts = new ArrayList<>();
        for (Product product : products) {
            if(product.price()<=price){
                Resultproducts.add(product);
            }
        }
        return Resultproducts;
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
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }
}

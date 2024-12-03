package org.neuefische;

import com.opencsv.bean.CsvBindByPosition;

public class EanProduct {
    @CsvBindByPosition(position = 0)
    private String Ean;
    @CsvBindByPosition(position =1)
    private String productName;
    @CsvBindByPosition(position=2)
    private double price;
    @CsvBindByPosition(position=3)
    private int quantity;

    public String getEan() {
        return Ean;
    }

    public void setEan(String ean) {
        Ean = ean;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

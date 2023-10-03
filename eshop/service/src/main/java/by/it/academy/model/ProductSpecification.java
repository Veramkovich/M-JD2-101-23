package by.it.academy.model;

import java.io.Serializable;

public class ProductSpecification implements Serializable {

    private String productName;

    private Double productPrice;

    public ProductSpecification() {
    }

    public ProductSpecification(String productName, Double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}

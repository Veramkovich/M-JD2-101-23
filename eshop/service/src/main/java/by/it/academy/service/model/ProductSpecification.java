package by.it.academy.service.model;

import java.io.Serializable;

public class ProductSpecification implements Serializable {

    private Long id;

    private String productName;

    private Double productPrice;

    public ProductSpecification() {
    }

    public ProductSpecification(String productName, Double productPrice, Long id) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

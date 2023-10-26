package by.it.academy.service.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

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

    public static void main(String[] args) throws ClassNotFoundException {
        LocalDate paymentDate = LocalDate.parse("2022-07-23");
        System.out.println(paymentDate);
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(UUID.randomUUID());

    }
}

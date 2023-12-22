package by.it.academy.data.pojo;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_PRODUCT_SPECIFICATION")
public class ProductSpecification {

    @Id
    private int id;

    @Column(name = "product_name", length = 150, nullable = false)
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_image")
    @Lob
    private byte[] productImage;

    @ManyToMany(mappedBy = "products", cascade = {
            CascadeType.ALL
    })
    private List<Promo> promoList;

    public ProductSpecification() {
    }

    public ProductSpecification(int id, String productName, double productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public List<Promo> getPromoList() {
        return promoList;
    }

    public void setPromoList(List<Promo> promoList) {
        this.promoList = promoList;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSpecification that = (ProductSpecification) o;

        if (id != that.id) return false;
        if (Double.compare(that.productPrice, productPrice) != 0) return false;
        if (!Objects.equals(productName, that.productName)) return false;
        return Arrays.equals(productImage, that.productImage);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(productImage);
        return result;
    }
}

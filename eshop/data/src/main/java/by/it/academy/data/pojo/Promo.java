package by.it.academy.data.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_PROMO")
public class Promo {

    @Id
    private int id;

    @Column(name = "promo_name", length = 150, nullable = false)
    private String promoName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "T_PRODUCT_PROMO",
            joinColumns = @JoinColumn(name = "PROMO_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private List<ProductSpecification> products;

    public Promo() {
        products = new ArrayList<>();
    }

    public Promo(int id, String promoName, Date startDate, Date endDate) {
        this();
        this.id = id;
        this.promoName = promoName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<ProductSpecification> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSpecification> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promo promo = (Promo) o;

        if (id != promo.id) return false;
        if (!Objects.equals(promoName, promo.promoName)) return false;
        if (!Objects.equals(startDate, promo.startDate)) return false;
        return Objects.equals(endDate, promo.endDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (promoName != null ? promoName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}

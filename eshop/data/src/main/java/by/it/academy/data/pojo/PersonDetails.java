package by.it.academy.data.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_PERSON_DETAILS")
public class PersonDetails {

    @Id
    @GenericGenerator(strategy = "uuid", name = "person_uuid")
    @GeneratedValue(generator = "person_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDetails that = (PersonDetails) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(mobileNumber, that.mobileNumber);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        return result;
    }
}

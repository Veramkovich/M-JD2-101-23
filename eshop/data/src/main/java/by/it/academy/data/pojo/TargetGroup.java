package by.it.academy.data.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_TARGET_GROUP")
public class TargetGroup {

    @Id
    @GenericGenerator(strategy = "uuid", name = "target_group_uuid")
    @GeneratedValue(generator = "target_group_uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(mappedBy = "targetGroup")
    private List<Person> persons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TargetGroup that = (TargetGroup) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(groupName, that.groupName)) return false;
        return Objects.equals(persons, that.persons);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (persons != null ? persons.hashCode() : 0);
        return result;
    }
}

package by.it.academy.data.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
}

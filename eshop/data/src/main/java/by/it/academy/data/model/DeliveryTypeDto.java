package by.it.academy.data.model;

public class DeliveryTypeDto {

    private Integer id;

    private String name;

    public DeliveryTypeDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

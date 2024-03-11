package net.guides.springboot2.springboot2jpacrudexample.model;

public class Floor {

    private Integer id;
    private Integer floor;

    public Floor() {
    }

    public Floor(Integer id, Integer floor) {
        this.id = id;
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}

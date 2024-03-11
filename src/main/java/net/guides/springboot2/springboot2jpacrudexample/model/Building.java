package net.guides.springboot2.springboot2jpacrudexample.model;

import jakarta.persistence.*;

@Entity
@Table(name = "building")
public class Building {

    private Integer id;
    private Integer locationId;
    private String buildingName;

    public Building() {
    }

    public Building(Integer id, Integer locationId, String buildingName) {
        this.id = id;
        this.locationId = locationId;
        this.buildingName = buildingName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "location_id", nullable = false)
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }


    @Column(name = "building_name", nullable = false)
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }





}

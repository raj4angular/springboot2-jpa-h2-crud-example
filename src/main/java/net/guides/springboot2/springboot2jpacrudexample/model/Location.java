package net.guides.springboot2.springboot2jpacrudexample.model;

import jakarta.persistence.*;


@Entity
@Table(name = "location")
public class Location {

    private Integer id;
    private String locationName;


    public Location() {
    }

    public Location(Integer id, String locationName) {
        this.id = id;
        this.locationName = locationName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "location_name", nullable = false)
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }


}

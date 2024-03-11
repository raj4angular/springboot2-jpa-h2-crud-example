package net.guides.springboot2.springboot2jpacrudexample.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    private Integer id;
    private String roomName;
    private Integer roomLocationId;
    private Integer roomBuildingId;
    private Integer roomFloor;
    private Integer roomSeatingCapacity;
    private String roomDescription;
    private String roomLocationName;
    private String roomBuildingName;

    public Room() {
    }

    public Room(String roomName, Integer roomLocationId, Integer roomBuildingId, Integer roomFloor, Integer roomSeatingCapacity, String roomDescription) {
        this.roomName = roomName;
        this.roomLocationId = roomLocationId;
        this.roomBuildingId = roomBuildingId;
        this.roomFloor = roomFloor;
        this.roomSeatingCapacity = roomSeatingCapacity;
        this.roomDescription = roomDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "room_name", nullable = false)
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Column(name = "room_location_id", nullable = false)
    public Integer getRoomLocationId() {
        return roomLocationId;
    }

    public void setRoomLocationId(Integer roomLocationId) {
        this.roomLocationId = roomLocationId;
    }

    @Column(name = "room_building_id", nullable = false)
    public Integer getRoomBuildingId() {
        return roomBuildingId;
    }

    public void setRoomBuildingId(Integer roomBuildingId) {
        this.roomBuildingId = roomBuildingId;
    }

    @Column(name = "room_floor", nullable = false)
    public Integer getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(Integer roomFloor) {
        this.roomFloor = roomFloor;
    }

    @Column(name = "room_seating_capacity", nullable = false)
    public Integer getRoomSeatingCapacity() {
        return roomSeatingCapacity;
    }

    public void setRoomSeatingCapacity(Integer roomSeatingCapacity) {
        this.roomSeatingCapacity = roomSeatingCapacity;
    }

    @Column(name = "room_description", nullable = false)
    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomLocationName() {
        return roomLocationName;
    }

    public void setRoomLocationName(String roomLocationName) {
        this.roomLocationName = roomLocationName;
    }

    public String getRoomBuildingName() {
        return roomBuildingName;
    }

    public void setRoomBuildingName(String roomBuildingName) {
        this.roomBuildingName = roomBuildingName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", roomName=" + roomName + ", roomLocation=" + roomLocationId + ", roomBuilding=" + roomBuildingId +"";
    }

}

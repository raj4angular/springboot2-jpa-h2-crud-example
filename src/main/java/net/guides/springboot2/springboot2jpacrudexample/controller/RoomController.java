package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import net.guides.springboot2.springboot2jpacrudexample.model.Building;
import net.guides.springboot2.springboot2jpacrudexample.model.Location;
import net.guides.springboot2.springboot2jpacrudexample.model.Time;
import net.guides.springboot2.springboot2jpacrudexample.repository.BuildingRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Room;
import net.guides.springboot2.springboot2jpacrudexample.repository.RoomRepository;

@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/v1")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Integer roomId)
            throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {

        Location location = locationRepository.findById(room.getRoomLocationId()).get();
        Building building = buildingRepository.findById(room.getRoomBuildingId()).get();
        room.setRoomLocationName(location.getLocationName());
        room.setRoomBuildingName(building.getBuildingName());

        return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Integer roomId,
                                           @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));

        /*room.setEmailId(roomDetails.getEmailId());
        room.setLastName(roomDetails.getLastName());
        room.setFirstName(roomDetails.getFirstName());*/
        room.setRoomLocationId(roomDetails.getRoomLocationId());
        room.setRoomBuildingId(roomDetails.getRoomBuildingId());
        room.setRoomFloor(roomDetails.getRoomFloor());
        room.setRoomName(roomDetails.getRoomName());
        room.setRoomDescription(roomDetails.getRoomDescription());

        final Room updatedRoom = roomRepository.save(room);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Integer roomId)
            throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));

        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/getTimeList")
    public List<Time> getTimeList() {
        List<Time> timeList = new ArrayList<>();
        timeList.add( new Time(1,"12:00AM") );  timeList.add( new Time(2,"12:30AM") );
        timeList.add( new Time(3,"01:00AM") );  timeList.add( new Time(4,"01:30AM") );
        timeList.add( new Time(5,"02:00AM") );  timeList.add( new Time(6,"02:30AM") );
        timeList.add( new Time(7,"03:00AM") );  timeList.add( new Time(8,"03:30AM") );
        timeList.add( new Time(9,"04:00AM") );  timeList.add( new Time(10,"04:30AM") );
        timeList.add( new Time(11,"05:00AM") );  timeList.add( new Time(12,"05:30AM") );
        timeList.add( new Time(13,"06:00AM") );  timeList.add( new Time(14,"06:30AM") );
        timeList.add( new Time(15,"07:00AM") );  timeList.add( new Time(16,"07:30AM") );
        timeList.add( new Time(17,"08:00AM") );  timeList.add( new Time(18,"08:30AM") );
        timeList.add( new Time(19,"09:00AM") );  timeList.add( new Time(20,"09:30AM") );
        timeList.add( new Time(21,"10:00AM") );  timeList.add( new Time(22,"10:30AM") );
        timeList.add( new Time(23,"11:00AM") );  timeList.add( new Time(24,"11:30AM") );

        timeList.add( new Time(25,"12:00PM") );  timeList.add( new Time(26,"12:30PM") );
        timeList.add( new Time(27,"01:00PM") );  timeList.add( new Time(28,"01:30PM") );
        timeList.add( new Time(29,"02:00PM") );  timeList.add( new Time(30,"02:30PM") );
        timeList.add( new Time(31,"03:00PM") );  timeList.add( new Time(32,"03:30PM") );
        timeList.add( new Time(33,"04:00PM") );  timeList.add( new Time(34,"04:30PM") );
        timeList.add( new Time(35,"05:00PM") );  timeList.add( new Time(36,"05:30PM") );
        timeList.add( new Time(37,"06:00PM") );  timeList.add( new Time(38,"06:30PM") );
        timeList.add( new Time(39,"07:00PM") );  timeList.add( new Time(40,"07:30PM") );
        timeList.add( new Time(41,"08:00PM") );  timeList.add( new Time(42,"08:30PM") );
        timeList.add( new Time(43,"09:00PM") );  timeList.add( new Time(44,"09:30PM") );
        timeList.add( new Time(45,"10:00PM") );  timeList.add( new Time(46,"10:30PM") );
        timeList.add( new Time(47,"11:00PM") );  timeList.add( new Time(48,"11:30PM") );

        return timeList;
    }


    @GetMapping("/roomsByBuilding")
    public ResponseEntity<List<Room>> getRoomsByBuilding(@RequestParam(name = "building_id") Integer building_id)
            throws ResourceNotFoundException {
        List<Room> roomList = getAllRooms().stream()
                .filter(r-> (r.getRoomBuildingId() == building_id)   )
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(roomList);
    }

}

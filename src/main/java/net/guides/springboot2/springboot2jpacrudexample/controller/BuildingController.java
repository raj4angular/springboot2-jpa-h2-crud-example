package net.guides.springboot2.springboot2jpacrudexample.controller;


import jakarta.validation.Valid;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Building;
import net.guides.springboot2.springboot2jpacrudexample.model.Floor;
import net.guides.springboot2.springboot2jpacrudexample.model.Time;
import net.guides.springboot2.springboot2jpacrudexample.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/v1")
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;


    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @GetMapping("/buildings/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable(value = "id") Integer buildingId)
            throws ResourceNotFoundException {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + buildingId));
        return ResponseEntity.ok().body(building);
    }

    @GetMapping("/buildingsByLocation")
    public ResponseEntity<List<Building>> getBuildingByLocationId(@RequestParam(name = "location_id") Integer locationId)
            throws ResourceNotFoundException {
        List<Building> buildingList = getAllBuildings().stream()
                .filter(b-> (b.getLocationId() == locationId)   )
                .collect(Collectors.toList());
                //.orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + locationId));
        return ResponseEntity.ok().body(buildingList);
    }





    @PostMapping("/buildings")
    public Building createBuilding(@Valid @RequestBody Building building) {
        return buildingRepository.save(building);
    }

    @DeleteMapping("/buildings/{id}")
    public Map<String, Boolean> deleteBuilding(@PathVariable(value = "id") Integer buildingId)
            throws ResourceNotFoundException {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new ResourceNotFoundException("Building not found for this id :: " + buildingId));

        buildingRepository.delete(building);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @GetMapping("/floors")
    public List<Floor> getFloors() {
        List<Floor> floorList = new ArrayList<>();

        for(int i=1;i<=10;i++){
            floorList.add( new Floor(i,i) );
        }


        return floorList;
    }


}

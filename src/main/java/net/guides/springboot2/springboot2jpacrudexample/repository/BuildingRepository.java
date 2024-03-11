package net.guides.springboot2.springboot2jpacrudexample.repository;


import net.guides.springboot2.springboot2jpacrudexample.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Integer> {
}

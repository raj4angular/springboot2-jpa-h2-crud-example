package net.guides.springboot2.springboot2jpacrudexample.repository;


import net.guides.springboot2.springboot2jpacrudexample.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {
}

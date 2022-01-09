package com.jv.example.springbootdtotutorial.repository;

import com.jv.example.springbootdtotutorial.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

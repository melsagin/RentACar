package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelRepository extends JpaRepository<Fuel,Integer> {
    Optional<Fuel> findByNameIgnoreCase(String name);
    boolean existsById(int id);
}

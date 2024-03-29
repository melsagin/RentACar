package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}

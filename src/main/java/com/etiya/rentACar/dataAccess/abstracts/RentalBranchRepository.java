package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.RentalBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalBranchRepository extends JpaRepository<RentalBranch, Integer> {

}

package com.etiya.rentACar.entities;

import com.etiya.rentACar.core.entitities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<RentalBranch> rentalBranches;

}

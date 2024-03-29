package com.etiya.rentACar.entities;

import com.etiya.rentACar.core.entitities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    //@JsonIgnoreProperties(value = "models", allowSetters = true)
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "transmission_id")
    //@JsonIgnoreProperties(value = "models", allowSetters = true)
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "fuel_id")
    //@JsonIgnoreProperties(value = "models", allowSetters = true)
    private Fuel fuel;
}

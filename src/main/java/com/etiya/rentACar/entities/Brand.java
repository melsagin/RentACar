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

//brand - model(car) - fuel ve transmission
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="brands")
public class Brand extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}

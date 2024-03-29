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
@Table(name = "cars")
public class Car extends BaseEntity {

//    private String modelName;
//
//    private String rentalBranchCityName;
//
//    private String modelBrandName;

    @Column(name ="kilometer")
    private int kilometer;//bunu daha sonra ilgili tüm yerlerde double yap

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "plate")
    private String plate;

    @Column(name = "modelYear")
    private int modelYear;

    //müsait, kirada, bakımda
    @Column(name = "carState")//1-Available, 2-Rented, 3-Under Maintenance
    private int carState;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "rental_branch_id")//bunun isimlendirlmesini sorarsın
    private RentalBranch rentalBranch;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;



}

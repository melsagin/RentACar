package com.etiya.rentACar.entities;

import com.etiya.rentACar.core.entitities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rental_branches")
public class RentalBranch extends BaseEntity {
    //Neden city bilgisini alıyoruz direkt name veya id alabilirdik? çünkü veritabanında aynı şehri örn. Ankara her defasında aynı veriye girmek zorunda kalacaktım
    //ama ben bunu bir tablo olarak yazdığımda ihtiyaç halinde 1 yerden alıyorum buna "normalizayon" diyoruz.
    @ManyToOne
    @JoinColumn(name = "city_id")//hangi kolon ile join edeceğim bilgisidir bura
    private City city;

    @OneToMany(mappedBy = "rentalBranch")
    private List<Car> cars;

    //kiralanacak arabanın hangi şehirde olacağı bilgisi olacak - hizmet verdiğimiz şehirler
    //en son rental ile ilişkilendirilmelidir
}

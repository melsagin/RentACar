package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    //Reflection
    //Aslında BrandImpl yok ama varmış gibi davranıyor bu noktada reflection devreye girer
    //çalışma zamanında JPARepository'i getiriyor

    Optional<Brand> findByNameIgnoreCase(String name);
//    List<Brand> findByName(String name);
}

//select * from brands where lower(name) = lower('abc)

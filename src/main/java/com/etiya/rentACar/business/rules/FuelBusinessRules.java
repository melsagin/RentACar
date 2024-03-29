package com.etiya.rentACar.business.rules;

import com.etiya.rentACar.business.constants.Messages;
import com.etiya.rentACar.core.exceptions.types.BusinessException;
import com.etiya.rentACar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentACar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FuelBusinessRules {
    private FuelRepository fuelRepository;
    public void fuelNameCannotBeDuplicated(String fuelName){
        Optional<Fuel> fuel = fuelRepository.findByNameIgnoreCase(fuelName);

        if(fuel.isPresent()){//brand varsa
            throw new BusinessException("Fuel Exist");//bu marka zaten var diye hata fırlat
        }
    }

    public Fuel checkByFuelId(int id){
        if(!fuelRepository.existsById(id)){
            throw new BusinessException(Messages.FuelMessages.FUEL_NOT_FOUND_ID);
        }
        return fuelRepository.findById(id).orElseThrow();
    }

}

package com.etiya.rentACar.business.rules;

import com.etiya.rentACar.core.exceptions.types.BusinessException;
import com.etiya.rentACar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentACar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionBusinessRules {
    private TransmissionRepository transmissionRepository;
    public void transmissionNameCannotBeDuplicated(String transmissionName){
        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(transmissionName);

        if(transmission.isPresent()){//brand varsa
            throw new BusinessException("Transmission Exist");//bu marka zaten var diye hata fırlat
        }
    }
}

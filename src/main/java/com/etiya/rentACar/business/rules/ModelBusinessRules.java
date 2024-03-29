package com.etiya.rentACar.business.rules;

import com.etiya.rentACar.core.exceptions.types.BusinessException;
import com.etiya.rentACar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    ModelRepository modelRepository;

    public void modelNameCannotBeDuplicated(String modelName){
        Optional<Model> model = modelRepository.findByNameIgnoreCase(modelName);

        if(model.isPresent()){//brand varsa
            throw new BusinessException("Model Exist");//bu marka zaten var diye hata fırlat
        }
    }
}

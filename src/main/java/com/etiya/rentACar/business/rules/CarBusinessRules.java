package com.etiya.rentACar.business.rules;

import com.etiya.rentACar.business.constants.Messages;
import com.etiya.rentACar.core.exceptions.types.BusinessException;
import com.etiya.rentACar.dataAccess.abstracts.CarRepository;
import com.etiya.rentACar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private CarRepository carRepository;
    public void carPlateCannotBeDuplicated(String plate){
        Optional<Car> car = carRepository.findByPlateIgnoreCase(plate);

        if(car.isPresent())
        {
            throw new BusinessException(Messages.CarMessages.SAME_PLATE_CAR_EXISTS);
        }
    }

    public Car checkByCarId(int id){
        if(!carRepository.existsById(id)){
            throw new BusinessException(Messages.CarMessages.CAR_NOT_FOUND);
        }
        return carRepository.findById(id).get();
    }

}

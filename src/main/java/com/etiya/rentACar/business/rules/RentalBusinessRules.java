package com.etiya.rentACar.business.rules;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.constants.Messages;
import com.etiya.rentACar.business.dtos.responses.cars.GetCarListResponse;
import com.etiya.rentACar.core.exceptions.types.BusinessException;
import com.etiya.rentACar.dataAccess.abstracts.RentalRepository;
import com.etiya.rentACar.entities.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private CarService carService;//burada rentalde old. için direkt repositorye erişim olmamalıdır bu nedenle service üzerinden erişilir.
    private RentalRepository rentalRepository;

    public void checkIfCarState(int carId){
        GetCarListResponse response = carService.getByCarId(carId);
        if(response.getCarState()==2)
            throw new BusinessException(Messages.RentalMessages.RENTED_BEFORE);

        else if(response.getCarState()==3)
            throw new BusinessException(Messages.RentalMessages.UNDER_MAINTENANCE);
    }

    public void checkIfCarIdIsSame(int id, int carId){
        Rental getRental = rentalRepository.findById(id).get();
        int rentedCarId = getRental.getCar().getId();
        if(carId != rentedCarId){
            throw new BusinessException("Araba uyuşmuyor");
        }
    }

}

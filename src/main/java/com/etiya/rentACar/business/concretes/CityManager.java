package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.dtos.requests.cities.CreateCityRequest;
import com.etiya.rentACar.business.dtos.requests.cities.UpdateCityRequest;
import com.etiya.rentACar.business.dtos.responses.cities.CreatedCityResponse;
import com.etiya.rentACar.business.dtos.responses.cities.GetCityListResponse;
import com.etiya.rentACar.business.dtos.responses.cities.GetCityResponse;
import com.etiya.rentACar.business.dtos.responses.cities.UpdatedCityResponse;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CityRepository;
import com.etiya.rentACar.entities.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CityManager implements CityService {
    private CityRepository cityRepository;//bu ifadeyi newlemektense constructorda çağırarak dependecy injection yapılır
    private ModelMapperService modelMapperService;
    //private CityBusinessRules cityBusinessRules;

    @Override
    public List<GetCityListResponse> getAll() {
        List<City> cities = cityRepository.findAll();
        List<GetCityListResponse> cityResponse = cities.stream()
                .map(city ->this.modelMapperService.forResponse()
                        .map(city, GetCityListResponse.class)).collect(Collectors.toList());
        return cityResponse;
    }

    @Override
    public GetCityResponse getById(int id) {
        City city = cityRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetCityResponse cityResponse = modelMapperService.forResponse().map(city, GetCityResponse.class);
        return cityResponse;
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        //Burada biz modelMapper ile mapledikten sonra önce veritabanına ekleyelim ve sonra onu alarak responseda map edelim
        //çünkü veritabanına kayıt gerekiyor biz bunu direkt alırsak veritabanını yok saymak olur ve bu böyle olmamalı
        //cityBusinessRules.cityNameCannotBeDuplicated(createCityRequest.getName());
        //checkIfCityNameExist(createCityRequest.getName());
        City city = modelMapperService.forRequest().map(createCityRequest, City.class);
        //city.setCreatedDate(LocalDateTime.now());
        City createdCity = cityRepository.save(city);
        CreatedCityResponse createdCityResponse = modelMapperService.forResponse().map(createdCity, CreatedCityResponse.class);
        return createdCityResponse;
    }

    @Override
    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest) {
        //cityBusinessRules.cityNameCannotBeDuplicated(updateCityRequest.getName());

        City getCity = cityRepository.findById(updateCityRequest.getId()).get();
        City city = modelMapperService.forRequest().map(updateCityRequest, City.class);
        //city.setUpdatedDate(LocalDateTime.now());
        city.setCreatedDate(getCity.getCreatedDate());
        City updatedCity = cityRepository.save(city);
        UpdatedCityResponse updatedCityResponse = modelMapperService.forResponse().map(updatedCity, UpdatedCityResponse.class);
        return updatedCityResponse;
    }

    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }

}

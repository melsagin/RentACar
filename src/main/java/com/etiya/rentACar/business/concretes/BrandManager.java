package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.core.exceptions.types.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentACar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandListResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.etiya.rentACar.business.rules.BrandBusinessRules;
import com.etiya.rentACar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    //Rules için burada if görmemeliyiz
    private BrandRepository brandRepository;//bu ifadeyi newlemektense constructorda çağırarak dependecy injection yapılır
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> brandResponse = brands.stream()
                .map(brand ->this.modelMapperService.forResponse()
                        .map(brand, GetBrandListResponse.class)).collect(Collectors.toList());
        return brandResponse;
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetBrandResponse brandResponse = modelMapperService.forResponse().map(brand, GetBrandResponse.class);
        return brandResponse;
    }

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCannotBeDuplicated(createBrandRequest.getName());
        //checkIfBrandNameExist(createBrandRequest.getName());
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        //brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand = brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse = modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {

        Brand getBrand = brandRepository.findById(updateBrandRequest.getId()).get();
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        //brand.setUpdatedDate(LocalDateTime.now());
        brand.setCreatedDate(getBrand.getCreatedDate());
        Brand updatedBrand = brandRepository.save(brand);
        UpdatedBrandResponse updatedBrandResponse = modelMapperService.forResponse().map(updatedBrand, UpdatedBrandResponse.class);
        return updatedBrandResponse;
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }


//    @Override
//    public CreatedBrandResponse save(CreateBrandRequest createBrandRequest) {


        //mapping
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());
//        brand.setCreatedDate(LocalDateTime.now());
//
//        Brand createdBrand =  this.brandRepository.save(brand);//veritabanına set ettiğin brand nesnesinin özelliklerini kayıt et

        //mapping
//        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
//        createdBrandResponse.setId(createdBrand.getId());
//        createdBrandResponse.setName(createdBrand.getName());
//        createdBrandResponse.setCreatedDate(createdBrand.getCreatedDate());
//
//        return createdBrandResponse;
//    }

//    @Override
//    public List<CreatedBrandResponse> findAll() {
//        List<Brand> brands = brandRepository.findAll();
//        List<CreatedBrandResponse> brandResponses = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, CreatedBrandResponse.class)).collect(Collectors.toList());

//        List<CreatedBrandResponse> createdBrandResponses = new ArrayList<>();
//        for(Brand brand: brands){
//            if(brand.getDeleteDate() == null) {
//                CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
//                createdBrandResponse.setId(brand.getId());
//                createdBrandResponse.setName(brand.getName());
//                createdBrandResponse.setCreatedDate(brand.getCreatedDate());
//                createdBrandResponses.add(createdBrandResponse);
//            }
//        }

//        return brandResponses;
//    }
//
//    @Override
//    public CreatedBrandResponse findById(int id) {
//        Optional<Brand> brand = getById(id);
//        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
//        createdBrandResponse.setId(brand.get().getId());
//        createdBrandResponse.setName(brand.get().getName());
//        createdBrandResponse.setCreatedDate(brand.get().getCreatedDate());
//        return createdBrandResponse;
//    }
//
//    @Override
//    public String update(UpdateBrandRequest updateBrandRequest) {
//        Optional<Brand> brand = getById(updateBrandRequest.getId());
//        brand.get().setName(updateBrandRequest.getName());
//        brand.get().setUpdateDate(LocalDateTime.now());
//        brandRepository.save(brand.get());
//        return "Updated";
//    }
//
//    @Override
//    public String delete(int id) {
//        Optional<Brand> brand = getById(id);
//        brand.get().setDeleteDate(LocalDateTime.now());
//        brandRepository.save(brand.get());
//        return "Deleted";
//    }
//
//    public Optional<Brand> getById(int id){
//        return brandRepository.findById(id);
//    }

}
//Tüm entityler için Add,Update,Delete, GetAll,GetById operasyonlarını uçtan uca yazınız.
//tamamında response-request pattern uygulanmalı

//@Service, @Component, @Bean, @Repository anotasyonlarını detaylı araştırınız.IoC

package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentACar.business.dtos.responses.brands.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandListResponse;
import com.etiya.rentACar.business.dtos.responses.brands.GetBrandResponse;
import com.etiya.rentACar.business.dtos.responses.brands.UpdatedBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {
    private BrandService brandService;

    @GetMapping("/getAll")
    public List<GetBrandListResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return  brandService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest){
        return brandService.add(createBrandRequest);
    }

    @PutMapping
    public UpdatedBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest){
        return brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        brandService.delete(id);
    }

//    @GetMapping("/{id}")
//    //tek değişken durumunda pathvariable
//    public CreatedBrandResponse findById(@PathVariable int id){
//       return brandService.findById(id);
//    }
//
//    @GetMapping()
//    public List<CreatedBrandResponse> findAll() {
//        return brandService.findAll();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)//201
//    //nesneler için kullanılır birden fazla değer için ve inputlar alırken requestbody
//    //valid 2 ile 30 arasında mı ve notnull mı kontrol eder
//    public CreatedBrandResponse save(@Valid @RequestBody CreateBrandRequest createBrandRequest){
//        return brandService.save(createBrandRequest);
//    }
//
//    @PutMapping
//    public void update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest){
//        brandService.update(updateBrandRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable int id){
//        return brandService.delete(id);
//    }

}
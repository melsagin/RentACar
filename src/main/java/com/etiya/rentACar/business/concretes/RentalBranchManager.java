package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.RentalBranchService;
import com.etiya.rentACar.business.dtos.requests.rentalBranches.CreateRentalBranchRequest;
import com.etiya.rentACar.business.dtos.requests.rentalBranches.UpdateRentalBranchRequest;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.CreatedRentalBranchResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.GetRentalBranchListResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.GetRentalBranchResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.UpdatedRentalBranchResponse;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.RentalBranchRepository;
import com.etiya.rentACar.entities.RentalBranch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RentalBranchManager implements RentalBranchService {
    //Rules için burada if görmemeliyiz
    private RentalBranchRepository rentalBranchRepository;//bu ifadeyi newlemektense constructorda çağırarak dependecy injection yapılır
    private ModelMapperService modelMapperService;
    //private RentalBranchBusinessRules rentalBranchBusinessRules;

    @Override
    public List<GetRentalBranchListResponse> getAll() {
        List<RentalBranch> rentalBranches = rentalBranchRepository.findAll();
        List<GetRentalBranchListResponse> rentalBranchResponse = rentalBranches.stream()
                .map(rentalBranch ->this.modelMapperService.forResponse()
                        .map(rentalBranch, GetRentalBranchListResponse.class)).collect(Collectors.toList());
        return rentalBranchResponse;
    }

    @Override
    public GetRentalBranchResponse getById(int id) {
        RentalBranch rentalBranch = rentalBranchRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetRentalBranchResponse rentalBranchResponse = modelMapperService.forResponse().map(rentalBranch, GetRentalBranchResponse.class);
        return rentalBranchResponse;
    }

    @Override
    public CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest) {
        //rentalBranchBusinessRules.rentalBranchNameCannotBeDuplicated(createRentalBranchRequest.getName());
        //checkIfRentalBranchNameExist(createRentalBranchRequest.getName());
        RentalBranch rentalBranch = modelMapperService.forRequest().map(createRentalBranchRequest, RentalBranch.class);
        rentalBranch.setId(0);

        RentalBranch createdRentalBranch = rentalBranchRepository.save(rentalBranch);
        CreatedRentalBranchResponse createdRentalBranchResponse = modelMapperService.forResponse().map(createdRentalBranch, CreatedRentalBranchResponse.class);
        return createdRentalBranchResponse;
    }

    @Override
    public UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest) {

        RentalBranch getRentalBranch = rentalBranchRepository.findById(updateRentalBranchRequest.getId()).get();
        RentalBranch rentalBranch = modelMapperService.forRequest().map(updateRentalBranchRequest, RentalBranch.class);

        rentalBranch.setCreatedDate(getRentalBranch.getCreatedDate());
        RentalBranch updatedRentalBranch = rentalBranchRepository.save(rentalBranch);
        UpdatedRentalBranchResponse updatedRentalBranchResponse = modelMapperService.forResponse().map(updatedRentalBranch, UpdatedRentalBranchResponse.class);
        return updatedRentalBranchResponse;
    }

    @Override
    public void delete(int id) {
        rentalBranchRepository.deleteById(id);
    }

}

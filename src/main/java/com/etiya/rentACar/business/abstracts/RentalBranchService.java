package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.rentalBranches.CreateRentalBranchRequest;
import com.etiya.rentACar.business.dtos.requests.rentalBranches.UpdateRentalBranchRequest;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.CreatedRentalBranchResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.GetRentalBranchListResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.GetRentalBranchResponse;
import com.etiya.rentACar.business.dtos.responses.rentalBranches.UpdatedRentalBranchResponse;

import java.util.List;

public interface RentalBranchService {
    List<GetRentalBranchListResponse> getAll();

    GetRentalBranchResponse getById(int id);
    CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest);

    UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest);

    void delete(int id);

}

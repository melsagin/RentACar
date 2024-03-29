package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.dtos.requests.invoices.CreateInvoiceRequest;
import com.etiya.rentACar.business.dtos.requests.invoices.UpdateInvoiceRequest;
import com.etiya.rentACar.business.dtos.responses.invoices.CreatedInvoiceResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.GetInvoiceListResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.GetInvoiceResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.UpdatedInvoiceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/invoices")
public class InvoiceController {
    private InvoiceService invoiceService;

    @GetMapping("/getAll")
    public List<GetInvoiceListResponse> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById(@PathVariable int id){
        return  invoiceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedInvoiceResponse add(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest){
        return invoiceService.add(createInvoiceRequest);
    }

    @PutMapping
    public UpdatedInvoiceResponse update(@Valid @RequestBody UpdateInvoiceRequest updateInvoiceRequest){
        return invoiceService.update(updateInvoiceRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        invoiceService.delete(id);
    }

}

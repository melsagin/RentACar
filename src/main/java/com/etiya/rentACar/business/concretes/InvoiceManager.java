package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.dtos.requests.invoices.CreateInvoiceRequest;
import com.etiya.rentACar.business.dtos.requests.invoices.UpdateInvoiceRequest;
import com.etiya.rentACar.business.dtos.responses.invoices.CreatedInvoiceResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.GetInvoiceListResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.GetInvoiceResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.UpdatedInvoiceResponse;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.InvoiceRepository;
import com.etiya.rentACar.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;
    //private InvoiceBusinessRules invoiceBusinessRules;

    @Override
    public List<GetInvoiceListResponse> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<GetInvoiceListResponse> invoiceResponse = invoices.stream()
                .map(invoice ->this.modelMapperService.forResponse()
                        .map(invoice, GetInvoiceListResponse.class)).collect(Collectors.toList());
        return invoiceResponse;
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetInvoiceResponse invoiceResponse = modelMapperService.forResponse().map(invoice, GetInvoiceResponse.class);
        return invoiceResponse;
    }

    @Override
    public CreatedInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest) {
        //invoiceBusinessRules.invoiceNameCannotBeDuplicated(createInvoiceRequest.getName());
        Invoice invoice = modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
        //invoice.setCreatedDate(LocalDateTime.now());
        Invoice createdInvoice = invoiceRepository.save(invoice);
        CreatedInvoiceResponse createdInvoiceResponse = modelMapperService.forResponse().map(createdInvoice, CreatedInvoiceResponse.class);
        return createdInvoiceResponse;
    }

    @Override
    public UpdatedInvoiceResponse update(UpdateInvoiceRequest updateInvoiceRequest) {
        //invoiceBusinessRules.invoiceNameCannotBeDuplicated(updateInvoiceRequest.getName());
        Invoice getInvoice = invoiceRepository.findById(updateInvoiceRequest.getId()).get();
        Invoice invoice = modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
//    invoice.setUpdatedDate(LocalDateTime.now());
        invoice.setCreatedDate(getInvoice.getCreatedDate());
        Invoice updatedInvoice = invoiceRepository.save(invoice);
        UpdatedInvoiceResponse updatedInvoiceResponse = modelMapperService.forResponse().map(updatedInvoice, UpdatedInvoiceResponse.class);
        return updatedInvoiceResponse;
    }

    @Override
    public void delete(int id) {
        invoiceRepository.deleteById(id);
    }

}

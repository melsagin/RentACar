package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.invoices.CreateInvoiceRequest;
import com.etiya.rentACar.business.dtos.requests.invoices.UpdateInvoiceRequest;
import com.etiya.rentACar.business.dtos.responses.invoices.CreatedInvoiceResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.GetInvoiceListResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.GetInvoiceResponse;
import com.etiya.rentACar.business.dtos.responses.invoices.UpdatedInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetInvoiceListResponse> getAll();

    GetInvoiceResponse getById(int id);

    CreatedInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest);

    UpdatedInvoiceResponse update(UpdateInvoiceRequest updateInvoiceRequest);

    void delete(int id);

}

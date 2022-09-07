package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Invoice;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Invoice;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public interface InvoiceServiceInterface {

    Invoice getInvoiceById(Integer id);
    List<Invoice> getAllInvoices();
    List<Invoice> getInvoiceByClientId(Integer clientId);
    List<Invoice> getInvoiceByDate(Date d);
    Invoice postInvoice(Invoice invoice)throws ApiException;
    Invoice updateInvoice(Invoice invoice) throws ApiException;
    Invoice delete(Integer id) throws ApiException;
}

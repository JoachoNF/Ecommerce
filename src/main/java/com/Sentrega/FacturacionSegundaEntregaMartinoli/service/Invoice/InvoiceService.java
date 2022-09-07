package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Invoice;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Invoice;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService implements InvoiceServiceInterface {

    @Autowired
    private InvoiceRepository repository;
    @Override
    public Invoice getInvoiceById(Integer id){
        return (Invoice) repository.findById(id).orElse(null);
    }
    @Override
    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }
    @Override
    public List<Invoice> getInvoiceByClientId(Integer clientId) {
        return repository.findByClientId(clientId);
    }
    @Override
    public List<Invoice> getInvoiceByDate(Date d) {
        return repository.findByDate(d);
    }
    @Override
    public Invoice postInvoice(Invoice invoice)throws ApiException{
        try{
            invoice.setDate(Date.from(Instant.now()));
            return repository.save(invoice);
        }catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Invoice updateInvoice(Invoice invoice) throws ApiException{
        try{
            if(getInvoiceById(invoice.getInvoiceId()) !=null){
                invoice.setDate(getInvoiceById((invoice.getInvoiceId())).getDate());
                return repository.save(invoice);
            }else{
                System.out.println("Non-existing Invoice");
                if(false)throw new ApiException("unattainable");
                return invoice;
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Invoice delete(Integer id) throws ApiException {
        try{
            Invoice returning = repository.findById(id).orElse(null);
            if(returning !=null){
                repository.deleteById(id);
                return returning;
            }else{
                System.out.println("Non-existing Invoice");
                //Agregar una devolución de error
                if(false)throw new ApiException("unattainable");
                return returning;
            }
        }catch(ApiException e) {
            throw new ApiException(e.getMessage());
        }
    }
}

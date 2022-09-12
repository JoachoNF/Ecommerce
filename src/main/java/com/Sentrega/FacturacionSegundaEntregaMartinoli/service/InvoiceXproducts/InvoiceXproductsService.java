package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.InvoiceXproducts;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Invoice;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.InvoiceXproducts;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.InvoiceXproductsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvoiceXproductsService implements InvoiceXproductsServiceInterface{

    @Autowired
    private InvoiceXproductsRepository repository;

    @Override
    public InvoiceXproducts getInvoiceXproductsById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public List<InvoiceXproducts> getInvoiceXproductsByInvoiceId(Integer id){
        return repository.findByInvoiceId(id);
    }

    @Override
    public List<InvoiceXproducts> getAllInvoicesXproducts() {
        return repository.findAll();
    }

    @Override
    public InvoiceXproducts postInvoiceXproducts(InvoiceXproducts invXprod) throws ApiException {
        try{
            return repository.save(invXprod);
        }catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public InvoiceXproducts updateInvoiceXproducts(InvoiceXproducts invXprod) throws ApiException {
        try{
            if(getInvoiceXproductsById(invXprod.getInvoiceId()) !=null){
                return repository.save(invXprod);
            }else{
                System.out.println("Non-existing Invoice");
                if(false)throw new ApiException("unattainable");
                return invXprod;
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public InvoiceXproducts delete(Integer id) throws ApiException {
        try{
            InvoiceXproducts returning = repository.findById(id).orElse(null);
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

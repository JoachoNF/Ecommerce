package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.InvoiceXproducts;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.InvoiceXproducts;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;

import java.util.Date;
import java.util.List;

public interface InvoiceXproductsServiceInterface {
    InvoiceXproducts getInvoiceXproductsById(Integer id);

    List<InvoiceXproducts> getInvoiceXproductsByInvoiceId(Integer id);

    List<InvoiceXproducts> getAllInvoicesXproducts();
    InvoiceXproducts postInvoiceXproducts(InvoiceXproducts invoice)throws ApiException;
    InvoiceXproducts updateInvoiceXproducts(InvoiceXproducts invoice) throws ApiException;
    InvoiceXproducts delete(Integer id) throws ApiException;
}

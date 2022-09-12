package com.Sentrega.FacturacionSegundaEntregaMartinoli.repository;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.InvoiceXproducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceXproductsRepository extends JpaRepository<InvoiceXproducts,Integer> {
    List<InvoiceXproducts> findByInvoiceId(Integer id);
}

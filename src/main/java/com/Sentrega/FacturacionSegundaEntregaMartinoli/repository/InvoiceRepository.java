package com.Sentrega.FacturacionSegundaEntregaMartinoli.repository;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    List<Invoice> findByDate(Date date);
    List<Invoice> findByClientId(Integer clientId);
}

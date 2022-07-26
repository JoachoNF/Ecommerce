package com.Sentrega.FacturacionSegundaEntregaMartinoli.repository;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findBySex(char s);
}

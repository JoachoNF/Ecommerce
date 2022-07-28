package com.Sentrega.FacturacionSegundaEntregaMartinoli.repository;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findBySex(char s);
    @Modifying
    @Query("Update Cliente c SET c.nombre=:nombre WHERE c.id_cliente=:id_cliente")
    public Void updateNombre(@Param("id_cliente") Integer id, @Param("nombre") String nombre);
}

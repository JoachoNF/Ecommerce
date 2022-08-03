package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Cliente;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClienteServiceInterface {
    Cliente getClienteById(Integer id);
    List<Cliente> getClientes();
    List<Cliente> getClientesBySex(Character s);
    Cliente postCliente(Cliente cliente) throws ApiException;
    Cliente putCliente(Cliente cliente) throws ApiException;
    Cliente deleteCliente(Integer id) throws ApiException;

    void deleteAll()throws ApiException;
}

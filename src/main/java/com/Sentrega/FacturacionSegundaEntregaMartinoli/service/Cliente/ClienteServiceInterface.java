package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Cliente;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClienteServiceInterface {
    Cliente getClienteById(Integer id);
    List<Cliente> getClientes();
    List<Cliente> getClientesBySex(Character s);
    Cliente postCliente(Cliente cliente);
    Cliente putCliente(Cliente cliente);
    Cliente deleteCliente(Integer id);
}

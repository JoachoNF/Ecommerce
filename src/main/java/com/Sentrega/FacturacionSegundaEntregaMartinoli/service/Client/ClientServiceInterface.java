package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Client;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Client;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClientServiceInterface {
    Client getClientById(Integer id);
    List<Client> getAllClients();
    List<Client> getClientsBySex(Character s);
    Client postClient(Client client) throws ApiException;
    Client putClient(Client client) throws ApiException;
    Client deleteClient(Integer id) throws ApiException;

    void deleteAll()throws ApiException;
}

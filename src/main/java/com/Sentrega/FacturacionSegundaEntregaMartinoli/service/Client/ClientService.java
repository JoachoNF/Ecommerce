package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Client;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Client;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientRepository repository;
    @Override
    public Client getClientById(Integer id) {
        return (Client) repository.findById(id).orElse(null);
    }
    @Override
    public List<Client> getAllClients() {
        return repository.findAll();
    }
    @Override
    public List<Client> getClientsBySex(Character s) {
        return repository.findBySex(s);
    }
    @Override
    public Client postClient(Client client) throws ApiException {
        try {
            if(client.getClientId()!=null){
                if(getClientById(client.getClientId())!=null) {
                    System.out.println("Already existing client");
                    return repository.findById(client.getClientId()).orElse(null);
                }else{
                    System.out.println("Non-relevant Id");
                    return repository.save(client);
                }
            }else{
                return repository.save(client);
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Client putClient(Client client) throws ApiException {
        try{
            if(getClientById(client.getClientId()) != null){
            return repository.save(client);
            }else{
            System.out.println("Client not found");
            return client;
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Client deleteClient(Integer id) throws ApiException {
        try{
            Client returning = repository.findById(id).orElse(null);
            if(returning !=null){
                repository.deleteById(id);
                return returning;
            }else{
                System.out.println("Client notFound");
                if(false){throw new ApiException("");}
                return returning;
            }
        } catch(ApiException e) {
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public void deleteAll()throws ApiException{
        try{
            repository.deleteAll();
        }catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }
}

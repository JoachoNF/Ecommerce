package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Cliente;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteServiceInterface {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente getClienteById(Integer id) {
        return (Cliente) repository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    @Override
    public List<Cliente> getClientesBySex(Character s) {
        return repository.findBySex(s);
    }

    @Override
    public Cliente postCliente(Cliente cliente) throws ApiException {
        try {
            if(cliente.getId_cliente()!=null){
                if(getClienteById(cliente.getId_cliente())!=null) {
                    throw new ApiException("Id existente");
                }else{
                    return repository.save(cliente);
                    //Agregar mensaje de omision del id.
                }
            }else{
                return repository.save(cliente);
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Cliente putCliente(Cliente cliente) throws ApiException {
        try{
            if(getClienteById(cliente.getId_cliente()) != null){
            return repository.save(cliente);
        }else{
            throw new ApiException("Cliente no existente");
        }}catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Cliente deleteCliente(Integer id) throws ApiException {
        try{
            Cliente retorno = repository.findById(id).orElse(null);
            if(retorno !=null){
                repository.deleteById(id);
                return retorno;
            }else{
                throw new ApiException("Cliente no existente");
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

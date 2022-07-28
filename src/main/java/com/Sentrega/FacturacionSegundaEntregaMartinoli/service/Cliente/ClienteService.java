package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Cliente;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
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
    public Cliente postCliente(Cliente cliente) {
        return repository.save(cliente);
    }
    @Override
    public Cliente putCliente(Cliente cliente) {
        Cliente clienteAModify = repository.findById(cliente.getId_cliente()).orElse(null);
        EntityManagerFactory EM_Factory = Persistence.createEntityManagerFactory("MyPU");
        EntityManager manager = EM_Factory.createEntityManager();
        EntityTransaction t = null;
        try {
            t = manager.getTransaction();
            t.begin();

            manager.merge(clienteAModify);
            manager.refresh(clienteAModify);

            t.commit();
        }catch(Exception e){
            if(t != null){
                t.rollback();
                System.out.println(e.getMessage());
            }
        }finally{
            manager.close();
        }
        return clienteAModify;
        }
    @Override
    public Cliente deleteCliente(Integer id) {
        Cliente retorno = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return retorno;
    }
    @Override
    public String updateNombre(Cliente update){
        Cliente old = repository.findById(update.getId_cliente()).orElse(null);
        repository.updateNombre(old.getId_cliente(),update.getNombre());
        return update.getNombre();
    };
}

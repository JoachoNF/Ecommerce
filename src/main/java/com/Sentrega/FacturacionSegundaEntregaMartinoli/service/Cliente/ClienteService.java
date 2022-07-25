package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Cliente;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
        EntityManagerFactory EM_Factory = Persistence.createEntityManagerFactory("MyPU");
        EntityManager manager = EM_Factory.createEntityManager();
        EntityTransaction transaction = null;
        Cliente clienteAModify = repository.findById(cliente.getId_cliente()).orElse(null);
        try {
            transaction = manager.getTransaction();
            transaction.begin();

            if (clienteAModify==null){
                repository.save(cliente);
                clienteAModify = cliente;
            }else{
                clienteAModify = cliente;
                repository.deleteById(clienteAModify.getId_cliente());
                repository.save(clienteAModify);
            }
            transaction.commit();

        }catch(Exception e){
            if(transaction != null){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
        }finally{
            manager.close();
        }
        manager.persist(clienteAModify);
        return clienteAModify;
        }
    @Override
    public Cliente deleteCliente(Integer id) {
        Cliente retorno = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return retorno;
    }

}

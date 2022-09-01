package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Factura;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Factura;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class FacturaService implements FacturaServiceInterface {

    @Autowired
    private FacturaRepository repository;

    @Override
    public Factura getFacturaById(Integer id){
        return (Factura) repository.findById(id).orElse(null);
    }

    @Override
    public List<Factura> getFacturas() {
        return repository.findAll();
    }

    @Override
    public List<Factura> getFacturasByClienteId(Integer idCliente) {
        return null;
    }

    @Override
    public List<Factura> getFacturaByFecha(Date d) {
        return repository.findByFecha(d);
    }
    @Override
    public Factura postFactura(Factura f)throws ApiException{
        try{
            f.setFecha(Date.from(Instant.now()));
            return repository.save(f);
        }catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Factura updateFactura(Factura f) throws ApiException{
        try{
            if(getFacturaById(f.getId_factura())!=null){
                return repository.save(f);
            }else{
                System.out.println("Cliente inexistente");
                //Agregar una devolución de error
                if(false)throw new ApiException("E");
                return f;
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Factura delete(Integer id) throws ApiException {
        try{
            Factura retorno = repository.findById(id).orElse(null);
            if(retorno !=null){
                repository.deleteById(id);
                return retorno;
            }else{
                System.out.println("Cliente inexistente");
                //Agregar una devolución de error
                if(false)throw new ApiException("E");
                return retorno;
            }
        }catch(ApiException e) {
            throw new ApiException(e.getMessage());

        }
    }
}

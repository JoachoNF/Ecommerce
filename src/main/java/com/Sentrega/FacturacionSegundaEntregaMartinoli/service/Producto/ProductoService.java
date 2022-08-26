package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Producto;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Producto;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements ProductoServiceInterface {

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto getProductoById(Integer id){
        return (Producto) repository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getProductoByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Producto> getProductos() {
        return repository.findAll();
    }

    @Override
    public List<Producto> getProductosSinStock() throws ApiException {
        List<Producto> retorno = new ArrayList<Producto>();
        try{
            for(Producto p:repository.findAll()){
                if(p.getStock()==0){
                    retorno.add(p);
                }
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }finally {
            return retorno;
        }
    }

    @Override
    public Producto postProducto(Producto p)throws ApiException{
        try{
            return repository.save(p);
        }catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Producto updateProducto(Producto p) throws ApiException{
        try{
            if(getProductoById(p.getId_producto())!=null){
                return repository.save(p);
            }else{
                throw new ApiException("Cliente inexistente");
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Producto delete(Integer id) throws ApiException {
        try{
            Producto retorno = repository.findById(id).orElse(null);
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
    @Override
    public List<Producto> borrarSinStock()throws ApiException{
        List<Producto> retorno = new ArrayList<Producto>();
        try{
            List<Producto> aBorrar = getProductosSinStock();
            for(Producto p:aBorrar){
                retorno.add(delete(p.getId_producto()));
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }finally {
            return retorno;
        }
    }
}

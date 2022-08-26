package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Producto;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Producto;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductoServiceInterface {
    Producto getProductoById(Integer id);
    List<Producto> getProductoByNombre(String nombre);
    List<Producto> getProductos();
    List<Producto> getProductosSinStock() throws ApiException;

    Producto postProducto(Producto p)throws ApiException;

    Producto updateProducto(Producto p) throws ApiException;
    Producto delete(Integer id) throws ApiException;

    List<Producto> borrarSinStock()throws ApiException;
}

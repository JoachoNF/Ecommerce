package com.Sentrega.FacturacionSegundaEntregaMartinoli.controller;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Producto;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Producto.ProductoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

    @Autowired
    private ProductoServiceInterface productoService;

    //Productos
    @GetMapping("")
    private List<Producto> getProductos(){
        return productoService.getProductos();
    }
    @GetMapping("/{id}")
    private Producto getProductoById(@PathVariable Integer id){
        return productoService.getProductoById(id);
    }
    @GetMapping("/{name}")
    private List<Producto> getProductoByName(@PathVariable String name){
        return productoService.getProductoByNombre(name);
    }
    @GetMapping("/SinStock")
    private List<Producto> getProductosSinStock() throws ApiException {
        return productoService.getProductosSinStock();
    }
    @DeleteMapping("/Borrar/{id}")
    private String deleteProducto(@PathVariable Integer id) throws ApiException{productoService.delete(id);return null;}
    @PostMapping("/New")
    private Producto newProducto(@RequestBody Producto p) throws ApiException{
        return productoService.postProducto(p);
    }
}

package com.Sentrega.FacturacionSegundaEntregaMartinoli.controller;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Producto;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Producto.ProductoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

    @Autowired
    private ProductoServiceInterface productoService;

    //Productos
    @GetMapping("")
    private ResponseEntity<?> getProductos(){
        return ResponseEntity.ok(productoService.getProductos());
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getProductoById(@PathVariable Integer id){
        return ResponseEntity.ok(productoService.getProductoById(id));
    }
    @GetMapping("/{nombre}")
    private ResponseEntity<?> getProductoByName(@PathVariable String nombre){
        return ResponseEntity.ok(productoService.getProductoByNombre(nombre));
    }
    @GetMapping("/SinStock")
    private ResponseEntity<?> getProductosSinStock() throws ApiException {
        return ResponseEntity.ok(productoService.getProductosSinStock());
    }
    @DeleteMapping("/Borrar/{id}")
    private ResponseEntity<?> deleteProducto(@PathVariable Integer id) throws ApiException{
        Producto retorno = productoService.delete(id);
        if(retorno!=null){
            return ResponseEntity.ok(retorno);
        }else{
            return ResponseEntity.ok("No se encontro el elemento: "+id);
        }

    }
    @DeleteMapping("/BorrarSinStock")
    private ResponseEntity<?> borrarSinStock()throws ApiException{
        return ResponseEntity.ok(productoService.borrarSinStock());
    }
    @PostMapping("/New")
    private ResponseEntity<?> newProducto(@RequestBody Producto p) throws ApiException{
        return ResponseEntity.ok(productoService.postProducto(p));
    }
}

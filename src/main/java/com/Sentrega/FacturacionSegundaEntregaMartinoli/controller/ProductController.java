package com.Sentrega.FacturacionSegundaEntregaMartinoli.controller;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Product;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Product.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    private ProductServiceInterface productService;

    //Productos
    @GetMapping("")
    private ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getProductById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @GetMapping("/{name}")
    private ResponseEntity<?> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }
    @GetMapping("/OutOfStock")
    private ResponseEntity<?> getProductsOutOfStock() throws ApiException {
        return ResponseEntity.ok(productService.getProductsOutOfStock());
    }
    @DeleteMapping("/Delete/{id}")
    private ResponseEntity<?> deleteProduct(@PathVariable Integer id) throws ApiException{
        Product returning = productService.delete(id);
        if(returning!=null){
            return ResponseEntity.ok(returning);
        }else{
            return ResponseEntity.ok("Id: ("+id+") Not found");
        }

    }
    @DeleteMapping("/DeleteOutOfStock")
    private ResponseEntity<?> deleteOutOfStock()throws ApiException{
        return ResponseEntity.ok(productService.deleteOutOfStock());
    }
    @PostMapping("/New")
    private ResponseEntity<?> newProduct(@RequestBody Product product) throws ApiException{
        return ResponseEntity.ok(productService.postProduct(product));
    }
}

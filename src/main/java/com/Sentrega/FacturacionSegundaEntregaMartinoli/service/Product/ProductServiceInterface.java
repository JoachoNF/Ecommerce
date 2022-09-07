package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Product;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Product;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductServiceInterface {
    Product getProductById(Integer id);
    List<Product> getProductByName(String name);
    List<Product> getProducts();
    List<Product> getProductsOutOfStock() throws ApiException;
    Product postProduct(Product product)throws ApiException;
    Product updateProduct(Product product) throws ApiException;
    Product delete(Integer id) throws ApiException;
    List<Product> deleteOutOfStock()throws ApiException;
}

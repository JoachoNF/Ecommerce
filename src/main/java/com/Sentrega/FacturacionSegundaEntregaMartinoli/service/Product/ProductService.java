package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Product;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Product;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product getProductById(Integer id){
        return (Product) repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> getProductsOutOfStock() throws ApiException {
        List<Product> returning = new ArrayList<Product>();
        try{
            for(Product p:repository.findAll()){
                if(p.getStock()==0){
                    returning.add(p);
                }
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }finally {
            return returning;
        }
    }

    @Override
    public Product postProduct(Product p)throws ApiException{
        try{
            return repository.save(p);
        }catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Product updateProduct(Product product) throws ApiException{
        try{
            if(getProductById(product.getProductId())!=null){
                return repository.save(product);
            }else{
                throw new ApiException("Non-Existing Product");
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }
    }
    @Override
    public Product delete(Integer id) throws ApiException {
        try{
            Product returning = repository.findById(id).orElse(null);
            if(returning !=null){
                repository.deleteById(id);
                return returning;
            }else{
                System.out.println("Non-Existing Product");
                if(false)throw new ApiException("Unattainable");
                return returning;
            }
        }catch(ApiException e) {
            throw new ApiException(e.getMessage());

        }
    }
    @Override
    public List<Product> deleteOutOfStock()throws ApiException{
        List<Product> returning = new ArrayList<Product>();
        try{
            List<Product> toDelete = getProductsOutOfStock();
            for(Product p:toDelete){
                returning.add(delete(p.getProductId()));
            }
        }catch(Exception e){
            throw new ApiException(e.getMessage());
        }finally {
            return returning;
        }
    }
}

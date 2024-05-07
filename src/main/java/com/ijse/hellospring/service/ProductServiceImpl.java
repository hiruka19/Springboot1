package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.Product;
import com.ijse.hellospring.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    @Override
    public List<Product> getAllproducts(){
        return ProductRepository.findAll();
    }
    
    @Override
    public Product getProductById(Long id){
        return ProductRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product){
        return ProductRepository.save(product);
    }
    @Override
    public  Product updateProduct(Long id, Product product) {
        Product existProduct = ProductRepository.findById(id).orElse(null);

        if(existProduct == null) {
            return null;
        }

        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        existProduct.setCategory(product.getCategory());
         
        return ProductRepository.save(existProduct);
    }
}



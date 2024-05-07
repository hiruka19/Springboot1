package com.ijse.hellospring.controller;

import java.util.List;

//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.service.CategoryService;
import com.ijse.hellospring.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ijse.hellospring.dto.ProductDto;
import com.ijse.hellospring.entity.Category;
import com.ijse.hellospring.entity.Product;
//import com.ijse.hellospring.service.ProductService;
//import com.ijse.hellospring.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public List<Product> getAllproducts() {
        return productService.getAllproducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> geProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            return ResponseEntity.status(404).build();

        } else {
            return ResponseEntity.status(200).body(product);
        }

    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);

        Product createProduct = productService.createProduct(product);
        return ResponseEntity.status(201).body(createProduct);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product product = new Product();//aluthen product ekk hadanwa

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        Category category = categoryService.getCategoryById(productDto.getCategoryId()); //category ek gnnwa
        product.setCategory(category); //category ek thiye nam methant set karann meka dano

        Product updateProduct = productService.updateProduct(id, product); // use the service layer to update product / update karanwa product eka =>servce layer ek product ek updata krnw

        if (updateProduct == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(updateProduct);
        }
    }
}

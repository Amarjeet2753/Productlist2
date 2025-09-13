package com.example.product.controller;


import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //create product
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
         return productService.createProduct(productDTO);
    }

//    get all
    @GetMapping

    public List<ProductDTO> getAllProcuct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")

    public ProductDTO getByID(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // delete
    @DeleteMapping("/{id}")
    public  String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    //update
    @PutMapping("/{id}")

    public ProductDTO update(@RequestBody ProductDTO productDTO , @PathVariable Long id){
        return productService.updateProduct(productDTO,id);
    }

}

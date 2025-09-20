package com.example.product.controller;


import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product service CRUD Rest API",
        description = "Create read update and delete operation for product API"
)

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //create product
    @Operation(
            summary = "Create product ",
            description = "Product REST API create  product "
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
         return productService.createProduct(productDTO);
    }

//    get all
    @Operation(
            summary = "Fetch all product",
            description = "Product REST API Fetch all product "
    )
    @GetMapping
    public List<ProductDTO> getAllProcuct(){
        return productService.getAllProduct();
    }


    @Operation(
            summary = "Fetch product by id",
            description = "Product REST API Fetch  product by id"
    )
    @GetMapping("/{id}")

    public ProductDTO getByID(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // delete
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @Operation(
            summary = "Delete product by id",
            description = "Product REST API delete  product by id"
    )
    @DeleteMapping("/{id}")
    public  String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    //update

    @Operation(
            summary = "Update product by id",
            description = "Product REST API Update product by id"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")

    public ProductDTO update(@RequestBody ProductDTO productDTO , @PathVariable Long id){
        return productService.updateProduct(productDTO,id);
    }

}

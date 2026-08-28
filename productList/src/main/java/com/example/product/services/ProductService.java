package com.example.product.services;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.exceptions.CategoryNotFoundException;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

//    create product
    public ProductDTO createProduct(ProductDTO productDTO ){

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->
                new CategoryNotFoundException("category " +productDTO.getCategoryId()+" not found")
        );

        Product product = ProductMapper.toProductEntity(productDTO,category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

//    get all product
    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

//    get product by id
    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not available"));
        return ProductMapper.toProductDTO(product);
    }

//    delete

    public  String deleteProduct(Long id){
        Product product  = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        productRepository.deleteById(id);
        return "product "+ product.getName()+" deleted successfully !";
    }

    //update

    public ProductDTO updateProduct(ProductDTO productDTO, Long id){
        Product product  = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        product.setPrice(productDTO.getPrice());

        product = productRepository.save(product);

        return ProductMapper.toProductDTO(product);
    }

}

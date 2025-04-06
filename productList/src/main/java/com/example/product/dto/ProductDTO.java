package com.example.product.dto;


import com.example.product.entity.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private  Long id;
    private  String name;
    private  String description;
    private  Double price;



    private Long category_id;
}

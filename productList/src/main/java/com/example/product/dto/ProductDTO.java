package com.example.product.dto;


import com.example.product.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(
        name = "Product",
        description = "It holds products detail"
)
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

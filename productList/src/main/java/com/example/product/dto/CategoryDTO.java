package com.example.product.dto;


import com.example.product.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Data for alll get bby defaul
public class CategoryDTO {

    private  Long id;
    private  String name;
    private List<ProductDTO> products = new ArrayList<>();
}

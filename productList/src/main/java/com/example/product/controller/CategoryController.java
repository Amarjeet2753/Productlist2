package com.example.product.controller;

import com.example.product.dto.CategoryDTO;
import com.example.product.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

//@NoArgsConstructor
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    //create category
//@Autowired
 private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
     return  new ResponseEntity<>(categoryService.createCategory(categoryDTO) , HttpStatus.CREATED);

    }

//    get by id

//    get all

}

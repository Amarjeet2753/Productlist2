package com.example.product.controller;

import com.example.product.dto.CategoryDTO;
import com.example.product.exceptions.CategoryAlreadyExistException;
import com.example.product.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@NoArgsConstructor
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    //create category
//@Autowired
 private CategoryService categoryService;
    @PostMapping
//    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){

//        try{
            CategoryDTO savedCat = categoryService.createCategory(categoryDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(savedCat);
//        }catch (CategoryAlreadyExistException e){
//            return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//
//        }

//     return  new ResponseEntity<>(categoryService.createCategory(categoryDTO) , HttpStatus.CREATED);

    }

//    get by id
    @GetMapping("/{id}")
    public CategoryDTO getCatById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }


//    get all
    @GetMapping
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }

//    delete
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);

    }


}

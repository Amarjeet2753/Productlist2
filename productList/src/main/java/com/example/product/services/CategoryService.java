package com.example.product.services;


import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.exceptions.CategoryAlreadyExistException;
import com.example.product.mapper.CategoryMapper;
import com.example.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

//    @Autowired
    private CategoryRepository categoryRepository;

//    create category

    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw  new CategoryAlreadyExistException("Categary  "  +categoryDTO.getName()+" already exist");
        }

        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);

        return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategory(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public  CategoryDTO getCategoryById(Long id){
        Category category =categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("invalid category id"));
        return  CategoryMapper.toCategoryDTO(category);
    }

    public String deleteCategory(Long id){
        Category category =categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("invalid category id"));
        categoryRepository.deleteById(id);
        return "Category : "+category.getName()+" deleted Successfuly";
//        return "Category  deleted Successfuly";
    }


}

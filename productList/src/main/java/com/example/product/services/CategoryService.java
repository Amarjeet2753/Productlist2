package com.example.product.services;


import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.mapper.CategoryMapper;
import com.example.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

//    @Autowired
    private CategoryRepository categoryRepository;

//    create category

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);

        return CategoryMapper.toCategoryDTO(category);
    }


}

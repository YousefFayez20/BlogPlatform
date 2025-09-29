package org.tasks.blogplatform.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tasks.blogplatform.domain.Category;
import org.tasks.blogplatform.domain.dtos.CategoryDto;
import org.tasks.blogplatform.mappers.CategoryMapper;
import org.tasks.blogplatform.repositories.CategoryRepository;
import org.tasks.blogplatform.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> allCategories(){
        List<Category> categoryList = categoryService.listCategories();
        return ResponseEntity.ok(categoryList.stream().map(categoryMapper::toDto).toList());

    }
}

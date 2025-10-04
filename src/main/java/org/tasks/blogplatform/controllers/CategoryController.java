package org.tasks.blogplatform.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tasks.blogplatform.domain.Category;
import org.tasks.blogplatform.domain.dtos.CategoryDto;
import org.tasks.blogplatform.domain.dtos.CreateCategoryRequest;
import org.tasks.blogplatform.mappers.CategoryMapper;
import org.tasks.blogplatform.repositories.CategoryRepository;
import org.tasks.blogplatform.services.CategoryService;

import java.util.List;
import java.util.UUID;

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

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @Valid  @RequestBody CreateCategoryRequest createCategoryRequest
            ){
        Category category = categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(categoryMapper.toDto(savedCategory), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(
            @PathVariable UUID id
    ){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

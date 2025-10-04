package org.tasks.blogplatform.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tasks.blogplatform.domain.Category;
import org.tasks.blogplatform.mappers.CategoryMapper;
import org.tasks.blogplatform.repositories.CategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> listCategories() {
        List<Category> categories = categoryRepository.listCategories();
        categories.forEach(category ->
                System.out.println("Category ID: " + category.getId() + ", Name: " + category.getName())
        );
        return categories;
    }
    @Override
    public Category createCategory(Category category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("Category name already exists: " + category.getName());
        }
        System.out.println("Before save - Category ID: " + category.getId());
        Category savedCategory = categoryRepository.save(category);
        System.out.println("After save - Category ID: " + savedCategory.getId());
        if (savedCategory.getId() == null) {
            throw new IllegalStateException("Failed to generate ID for category: " + category.getName());
        }
        return savedCategory;
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        Category category = getCategoryById(id);
        if(!category.getPosts().isEmpty()){
            throw  new IllegalStateException("cannot delete category: "+category.getName()+"It has associated posts");
        }
        categoryRepository.delete(category);
    }

    private Category getCategoryById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category not found with id : "+ id));
    }


}

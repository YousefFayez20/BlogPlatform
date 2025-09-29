package org.tasks.blogplatform.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tasks.blogplatform.domain.Category;
import org.tasks.blogplatform.repositories.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.listCategories();
    }

    @Override
    public Category createCategory(Category category) {
        if(categoryRepository.existsByNameIgnoreCase(category.getName())){

        }
    }


}

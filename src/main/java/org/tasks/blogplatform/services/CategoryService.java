package org.tasks.blogplatform.services;

import org.tasks.blogplatform.domain.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService  {
    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);
}

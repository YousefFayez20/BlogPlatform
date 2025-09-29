package org.tasks.blogplatform.services;

import org.tasks.blogplatform.domain.Category;

import java.util.List;

public interface CategoryService  {
    List<Category> listCategories();
    Category createCategory(Category category);
}

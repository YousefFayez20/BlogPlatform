package org.tasks.blogplatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tasks.blogplatform.domain.Category;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.posts")
    public List<Category> listCategories();

    boolean existsByNameIgnoreCase(String name);
}
